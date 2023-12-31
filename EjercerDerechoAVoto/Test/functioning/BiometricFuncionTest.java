package functioning;
import data.VotingOption;
import evoting.biometricdataperipherial.HumanBiometricScanner;
import evoting.biometricdataperipherial.HumanScanner;
import evoting.biometricdataperipherial.PassportBiometricReader;
import evoting.biometricdataperipherial.PassportReader;
import evoting.votingKiosk;
import exceptions.*;
import exceptions.biometricaldataperipherial.BiometricVerificationFailedException;
import exceptions.biometricaldataperipherial.HumanBiometricScanningException;
import exceptions.biometricaldataperipherial.PassportBiometricReadingException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import services.*;

import java.net.ConnectException;

import static org.junit.Assert.*;

public class BiometricFuncionTest  implements FunctionTest{
    ElectoralOrganism electoralOrganism;
    LocalService localService;
    Scrutiny scrutiny;
    votingKiosk vKiosk;
    PassportBiometricReader passportBiometricReader;
    HumanBiometricScanner humanBiometricScanner;

    @BeforeEach
    @Override
    public void initialize() throws NifIsNullException, NifNotValidException, PasswordIsNullException {
        electoralOrganism = new ElectoralOrganismImpl();
        localService = new LocalServiceImpl();
        scrutiny = new ScrutinyImpl();
        passportBiometricReader = new PassportReader();
        humanBiometricScanner = new HumanScanner();

        vKiosk = new votingKiosk();
        vKiosk.setElectoralOrganism(electoralOrganism);
        vKiosk.setScrutiny(scrutiny);
        vKiosk.setLocalService(localService);
        vKiosk.setHumanBiometricScanner(humanBiometricScanner);
        vKiosk.setPassportBiometricReader(passportBiometricReader);
    }

    @Override
    @Test
    public void setIncorrectDocumentOption() throws ProceduralException {
        vKiosk.initVoting();
        assertThrows(InvalidDocumentIdentificationTypeException.class, () -> vKiosk.setDocument('A'));
    }

    @Override
    @Test
    public void consultIncorrectVotingOption() throws ProceduralException, InvalidDocumentIdentificationTypeException, NifIsNullException, PassportBiometricReadingException, NifNotValidException, NotValidPassportException, ExplicitConsetNotAprovedException, HumanBiometricScanningException, BiometricVerificationFailedException, NotEnabledException, ConnectException {
        VotingOption vO = new VotingOption("invalidParty");
        vKiosk.initVoting();
        vKiosk.setDocument('P');
        vKiosk.grantExplicitConsent('C');
        vKiosk.readPassport();
        vKiosk.readFaceBiometrics();
        vKiosk.readFingerPrintBiometrics();
        vKiosk.initOptionsNavigation();
        assertThrows(InvalidVotingOptionException.class, () -> vKiosk.consultVotingOption(vO));
    }

    @Override
    @Test
    public void wrongInputVotingOption() throws ProceduralException, InvalidDocumentIdentificationTypeException, ExplicitConsetNotAprovedException, NifIsNullException, PassportBiometricReadingException, NifNotValidException, NotValidPassportException, HumanBiometricScanningException, BiometricVerificationFailedException, NotEnabledException, ConnectException, InvalidVotingOptionException {
        VotingOption vO = new VotingOption("party1");
        vKiosk.initVoting();
        vKiosk.setDocument('P');
        vKiosk.grantExplicitConsent('C');
        vKiosk.readPassport();
        vKiosk.readFaceBiometrics();
        vKiosk.readFingerPrintBiometrics();
        vKiosk.initOptionsNavigation();
        vKiosk.consultVotingOption(vO);
        vKiosk.vote();
        assertThrows(InvalidConfirmOptionInput.class, () -> vKiosk.confirmVotingOption('A'));
    }

    @Override
    @Test
    public void electoralOrganismConexionErrorinCanVote() throws ProceduralException, InvalidDocumentIdentificationTypeException, ExplicitConsetNotAprovedException, NifIsNullException, PassportBiometricReadingException, NifNotValidException, NotValidPassportException, HumanBiometricScanningException {
        electoralOrganism.setConnectionError();
        vKiosk.initVoting();
        vKiosk.setDocument('P');
        vKiosk.grantExplicitConsent('C');
        vKiosk.readPassport();
        vKiosk.readFaceBiometrics();
        assertThrows(ConnectException.class, () -> vKiosk.readFingerPrintBiometrics());
    }

    @Override
    @Test
    public void electoralOrganismConexionErrorInDisableVoter() throws ProceduralException, InvalidDocumentIdentificationTypeException, ExplicitConsetNotAprovedException, NifIsNullException, PassportBiometricReadingException, NifNotValidException, NotValidPassportException, HumanBiometricScanningException, BiometricVerificationFailedException, NotEnabledException, ConnectException, InvalidVotingOptionException {
        VotingOption vO = new VotingOption("party1");
        vKiosk.initVoting();
        vKiosk.setDocument('P');
        vKiosk.grantExplicitConsent('C');
        vKiosk.readPassport();
        vKiosk.readFaceBiometrics();
        vKiosk.readFingerPrintBiometrics();
        vKiosk.initOptionsNavigation();
        vKiosk.consultVotingOption(vO);
        vKiosk.vote();
        electoralOrganism.setConnectionError();
        assertThrows(ConnectException.class, () -> vKiosk.confirmVotingOption('C'));
    }

    @Test
    public void enterInvalidConsentInput(){
        //assertThrows(ExplicitConsetNotAprovedException.class, () -> );
    }

    @Test
    public void validateNoneValidPassport(){
        //assertThrows(NotValidPassportException.class, () -> );
    }

    @Test
    public void getCorruptedPassportBiometricData(){
        //assertThrows(PassportBiometricReadingException.class, () -> );
    }
}

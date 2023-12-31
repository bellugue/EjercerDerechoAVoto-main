package procedure.biometric;
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

public class correctProcedure implements ProcedureTest{
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
    public void iniVoting() throws ProceduralException {
        vKiosk.initVoting();
        assertEquals(vKiosk.getCurrentPhase(), 2);
    }

    @Override
    @Test
    public void setDocument() throws ProceduralException, InvalidDocumentIdentificationTypeException {
        vKiosk.initVoting();
        vKiosk.setDocument('P');
        assertEquals(vKiosk.getCurrentPhase(), 3);
    }

    @Override
    @Test
    public void grantExplicitContent() throws ProceduralException, InvalidDocumentIdentificationTypeException, ExplicitConsetNotAprovedException {
        vKiosk.initVoting();
        vKiosk.setDocument('P');
        vKiosk.grantExplicitConsent('C');
        assertEquals(vKiosk.getCurrentPhase(), 4);
    }

    @Override
    @Test
    public void readPassport() throws ProceduralException, InvalidDocumentIdentificationTypeException, NifIsNullException, PassportBiometricReadingException, NifNotValidException, NotValidPassportException, ExplicitConsetNotAprovedException {
        vKiosk.initVoting();
        vKiosk.setDocument('P');
        vKiosk.grantExplicitConsent('C');
        vKiosk.readPassport();
        assertEquals(vKiosk.getCurrentPhase(), 5);
    }

    @Override
    @Test
    public void readFaceBiometrics() throws ProceduralException, InvalidDocumentIdentificationTypeException, NifIsNullException, PassportBiometricReadingException, NifNotValidException, NotValidPassportException, HumanBiometricScanningException, ExplicitConsetNotAprovedException {
        vKiosk.initVoting();
        vKiosk.setDocument('P');
        vKiosk.grantExplicitConsent('C');
        vKiosk.readPassport();
        vKiosk.readFaceBiometrics();
        assertEquals(vKiosk.getCurrentPhase(), 6);
    }

    @Override
    @Test
    public void readFingerPrintBiometrics() throws ProceduralException, InvalidDocumentIdentificationTypeException, NifIsNullException, PassportBiometricReadingException, NifNotValidException, NotValidPassportException, HumanBiometricScanningException, BiometricVerificationFailedException, NotEnabledException, ConnectException, ExplicitConsetNotAprovedException {
        vKiosk.initVoting();
        vKiosk.setDocument('P');
        vKiosk.grantExplicitConsent('C');
        vKiosk.readPassport();
        vKiosk.readFaceBiometrics();
        vKiosk.readFingerPrintBiometrics();
        assertEquals(vKiosk.getCurrentPhase(), 7);
    }

    @Override
    @Test
    public void initOptionsNavigator() throws ProceduralException, InvalidDocumentIdentificationTypeException, NifIsNullException, PassportBiometricReadingException, NifNotValidException, NotValidPassportException, HumanBiometricScanningException, BiometricVerificationFailedException, NotEnabledException, ConnectException, ExplicitConsetNotAprovedException {
        vKiosk.initVoting();
        vKiosk.setDocument('P');
        vKiosk.grantExplicitConsent('C');
        vKiosk.readPassport();
        vKiosk.readFaceBiometrics();
        vKiosk.readFingerPrintBiometrics();
        vKiosk.initOptionsNavigation();
        assertEquals(vKiosk.getCurrentPhase(), 8);
    }

    @Override
    @Test
    public void consultVotingOption() throws ProceduralException, InvalidDocumentIdentificationTypeException, NifIsNullException, PassportBiometricReadingException, NifNotValidException, NotValidPassportException, HumanBiometricScanningException, BiometricVerificationFailedException, NotEnabledException, ConnectException, ExplicitConsetNotAprovedException, InvalidVotingOptionException {
        VotingOption option = new VotingOption("party1");
        vKiosk.initVoting();
        vKiosk.setDocument('P');
        vKiosk.grantExplicitConsent('C');
        vKiosk.readPassport();
        vKiosk.readFaceBiometrics();
        vKiosk.readFingerPrintBiometrics();
        vKiosk.initOptionsNavigation();
        vKiosk.consultVotingOption(option);
        assertEquals(vKiosk.getCurrentPhase(), 9);
    }

    @Override
    @Test
    public void vote() throws ProceduralException, InvalidDocumentIdentificationTypeException, NifIsNullException, PassportBiometricReadingException, NifNotValidException, NotValidPassportException, HumanBiometricScanningException, BiometricVerificationFailedException, NotEnabledException, ConnectException, ExplicitConsetNotAprovedException, InvalidVotingOptionException {
        VotingOption option = new VotingOption("party1");
        vKiosk.initVoting();
        vKiosk.setDocument('P');
        vKiosk.grantExplicitConsent('C');
        vKiosk.readPassport();
        vKiosk.readFaceBiometrics();
        vKiosk.readFingerPrintBiometrics();
        vKiosk.initOptionsNavigation();
        vKiosk.consultVotingOption(option);
        vKiosk.vote();
        assertEquals(vKiosk.getCurrentPhase(), 10);
    }

    @Override
    @Test
    public void confirmVotingOption() throws ProceduralException, InvalidDocumentIdentificationTypeException, NifIsNullException, PassportBiometricReadingException, NifNotValidException, NotValidPassportException, HumanBiometricScanningException, BiometricVerificationFailedException, NotEnabledException, ConnectException, ExplicitConsetNotAprovedException, InvalidVotingOptionException {
        VotingOption option = new VotingOption("party1");
        vKiosk.initVoting();
        vKiosk.setDocument('P');
        vKiosk.grantExplicitConsent('C');
        vKiosk.readPassport();
        vKiosk.readFaceBiometrics();
        vKiosk.readFingerPrintBiometrics();
        vKiosk.initOptionsNavigation();
        vKiosk.consultVotingOption(option);
        vKiosk.vote();
        vKiosk.confirmVotingOption('C');
        assertEquals(vKiosk.getCurrentPhase(), 11);
    }
}

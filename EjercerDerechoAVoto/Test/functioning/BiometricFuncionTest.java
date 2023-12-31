package functioning;
import evoting.votingKiosk;
import exceptions.*;
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

    @BeforeEach
    @Override
    public void initialize() throws NifIsNullException, NifNotValidException, PasswordIsNullException {
        electoralOrganism = new ElectoralOrganismImpl();
        localService = new LocalServiceImpl();
        scrutiny = new ScrutinyImpl();

        vKiosk = new votingKiosk();
        vKiosk.setElectoralOrganism(electoralOrganism);
        vKiosk.setScrutiny(scrutiny);
        vKiosk.setLocalService(localService);
    }

    @Override
    @Test
    public void setIncorrectDocumentOption() throws ProceduralException {
        vKiosk.initVoting();
        assertThrows(InvalidDocumentIdentificationTypeException.class, () -> vKiosk.setDocument('A'));
    }

    @Override
    @Test
    public void consultIncorrectVotingOption() {
        //assertThrows(InvalidVotingOptionException.class, () -> );
    }

    @Override
    @Test
    public void wrongInputVotingOption() {
        //assertThrows(InvalidConfirmOptionInput.class, () -> );
    }

    @Override
    @Test
    public void electoralOrganismConexionErrorinCanVote() {
        //assertThrows(ConnectException.class, () -> );
    }

    @Override
    @Test
    public void electoralOrganismConexionErrorInDisableVoter() {
        //assertThrows(ConnectException.class, () -> );
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

import data.Nif;
import data.Password;
import data.biometricaldataperipherial.SingleBiometricData;
import evoting.votingKiosk;
import exceptions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import services.*;

import java.net.ConnectException;

import static org.junit.Assert.*;

public class evotingTest implements TestingIntf{
    ElectoralOrganism electoralOrganism;
    LocalService localService;
    Scrutiny scrutiny;
    PoliceDepartament policeDepartament;
    votingKiosk vKiosk;

    @BeforeEach
    @Override
    public void initialize() throws NifIsNullException, NifNotValidException, PasswordIsNullException {
        electoralOrganism = new ElectoralOrganismImpl();
        localService = new LocalServiceImpl();
        scrutiny = new ScrutinyImpl();
        policeDepartament = new PoliceDepartamentDNI();

        vKiosk = new votingKiosk();
        vKiosk.setPoliceDepartament(policeDepartament);
        vKiosk.setElectoralOrganism(electoralOrganism);
        vKiosk.setScrutiny(scrutiny);
        vKiosk.setLocalService(localService);
    }
    @Override
    @Test
    public void initVotingTest() throws ProceduralException {
        vKiosk.initVoting();
        assertEquals(vKiosk.getCurrentPhase(), 2);
    }


    @Test
    public void setDocumentTest() throws InvalidDocumentIdentificationTypeException, ProceduralException {
        vKiosk.setDocument('d');
        assertEquals(vKiosk.getCurrentPhase(), 3);
    }

    @Test
    public void enterAccountTest() throws ProceduralException, PasswordIsNullException, InvalidAccountException {
        Password testPassword = new Password("1234");
        vKiosk.enterAccount("usertest", testPassword);
        assertEquals(vKiosk.getCurrentPhase(), 4);
    }

    @Test
    public void confirmIdetifTest() throws ProceduralException, InvalidDNIDocumException {

        vKiosk.confirmIdentif('C');
        assertEquals(vKiosk.getCurrentPhase(), 5);
    }

    @Test
    public void enterNifTest() throws ProceduralException, NifIsNullException, NifNotValidException, NotEnabledException, ConnectException {
        Nif nif = new Nif("11111111S");
        vKiosk.enterNif(nif);
        assertEquals(vKiosk.getCurrentPhase(), 6);
    }
    @Test
    public void initOptionNavegationTest() throws ProceduralException {
        vKiosk.initOptionsNavigation();
        assertEquals(vKiosk.getCurrentPhase(), 7);
    }




}

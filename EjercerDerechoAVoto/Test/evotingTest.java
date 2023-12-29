import data.Nif;
import data.biometricaldataperipherial.SingleBiometricData;
import evoting.votingKiosk;
import exceptions.NifIsNullException;
import exceptions.NifNotValidException;
import exceptions.PasswordIsNullException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import services.*;

import static org.junit.Assert.*;

public class evotingTest implements TestingIntf{
    Passport passport;
    ElectoralOrganism electoralOrganism;
    LocalService localService;
    Scrutiny scrutiny;
    PoliceDepartament policeDepartament;
    votingKiosk vKiosk;

    @BeforeEach
    @Override
    public void initialize() throws NifIsNullException, NifNotValidException, PasswordIsNullException {
        passport = new Passport();
        passport.setNif(new Nif("11111111a"));
        passport.setUserData(new SingleBiometricData("FacialData1".getBytes()), new SingleBiometricData("FingerPrintsData1".getBytes()));
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
    public void initVotingTest(){
        vKiosk.initVoting();
        assertEquals(vKiosk.getCurrentPhase(), 2);
    }


}

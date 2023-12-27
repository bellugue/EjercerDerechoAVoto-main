import data.Nif;
import data.Passport;
import data.biometricaldataperipherial.SingleBiometricData;
import exceptions.NifIsNullException;
import exceptions.NifNotValidException;
import exceptions.PasswordIsNullException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import services.*;

import static org.junit.jupiter.api.Assertions.*;

public class evotingTest implements TestingIntf{
    Passport passport;
    ElectoralOrganism electoralOrganism;
    LocalService localService;
    Scrutiny scrutiny;
    PoliceDepartament policeDepartament;
    @BeforeEach
    @Override
    public void initialize() throws NifIsNullException, NifNotValidException, PasswordIsNullException {
        passport.setNif(new Nif("11111111a"));
        passport.setUserData(new SingleBiometricData("FacialData".getBytes()), new SingleBiometricData("FingerPrintsData".getBytes()));
        electoralOrganism = new ElectoralOrganismImpl();
        localService = new LocalServiceImpl();
        scrutiny = new ScrutinyImpl();
        policeDepartament = new PoliceDepartamentDNI();
    }
}

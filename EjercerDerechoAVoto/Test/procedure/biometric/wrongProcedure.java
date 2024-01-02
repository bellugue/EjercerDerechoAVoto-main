package procedure.biometric;
import data.VotingOption;
import evoting.votingKiosk;
import exceptions.NifIsNullException;
import exceptions.NifNotValidException;
import exceptions.PasswordIsWrongException;
import exceptions.ProceduralException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import services.*;

import static org.junit.Assert.*;

public class wrongProcedure implements ProcedureTest{
    ElectoralOrganism electoralOrganism;
    LocalService localService;
    Scrutiny scrutiny;
    votingKiosk vKiosk;

    @BeforeEach
    @Override
    public void initialize() throws NifIsNullException, NifNotValidException, PasswordIsWrongException {
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
    public void iniVoting() throws ProceduralException {
        vKiosk.initVoting();
        assertThrows(ProceduralException.class, () -> vKiosk.initVoting());
    }

    @Override
    @Test
    public void setDocument() {
        assertThrows(ProceduralException.class, ()  -> vKiosk.setDocument('P'));
    }

    @Override
    @Test
    public void grantExplicitContent() {
        assertThrows(ProceduralException.class, () -> vKiosk.grantExplicitConsent('C'));
    }

    @Override
    @Test
    public void readPassport() {
        assertThrows(ProceduralException.class, () -> vKiosk.readPassport());
    }

    @Override
    @Test
    public void readFaceBiometrics() {
        assertThrows(ProceduralException.class, () -> vKiosk.readFaceBiometrics());
    }

    @Override
    @Test
    public void readFingerPrintBiometrics() {
        assertThrows(ProceduralException.class, () -> vKiosk.readFingerPrintBiometrics());
    }

    @Override
    @Test
    public void initOptionsNavigator() {
        assertThrows(ProceduralException.class, () -> vKiosk.initOptionsNavigation());
    }

    @Override
    @Test
    public void consultVotingOption() {
        assertThrows(ProceduralException.class, () -> vKiosk.consultVotingOption(new VotingOption("party1")));
    }

    @Override
    @Test
    public void vote() {
        assertThrows(ProceduralException.class, () -> vKiosk.vote());
    }

    @Override
    @Test
    public void confirmVotingOption() {
        assertThrows(ProceduralException.class, () -> vKiosk.confirmVotingOption('C'));
    }
}

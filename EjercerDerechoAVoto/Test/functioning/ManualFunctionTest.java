package functioning;
import evoting.votingKiosk;
import exceptions.NifIsNullException;
import exceptions.NifNotValidException;
import exceptions.PasswordIsNullException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import services.*;

import static org.junit.Assert.*;

public class ManualFunctionTest implements FunctionTest{
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
    public void setIncorrectDocumentOption() {

    }

    @Override
    public void consultIncorrectVotingOption() {

    }

    @Override
    public void wrongInputVotingOption() {

    }

    @Override
    public void electoralOrganismConexionErrorinCanVote() {

    }

    @Override
    public void electoralOrganismConexionErrorInDisableVoter() {

    }

    @Test
    public void enterAccountWithInvalidUser(){

    }

    @Test
    public void enterAccountWithValidUserButInvalidPassword(){

    }

    @Test
    public void enterInvalidNif(){

    }
}

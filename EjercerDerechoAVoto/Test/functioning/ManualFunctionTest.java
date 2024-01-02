package functioning;
import data.Nif;
import data.Password;
import data.VotingOption;
import evoting.votingKiosk;
import exceptions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import services.*;

import java.net.ConnectException;

import static org.junit.Assert.*;

public class ManualFunctionTest implements FunctionTest{
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
    public void setIncorrectDocumentOption() throws ProceduralException {
        vKiosk.initVoting();
        assertThrows(InvalidDocumentIdentificationTypeException.class, () -> vKiosk.setDocument('A'));
    }

    @Override
    @Test
    public void consultIncorrectVotingOption() throws PasswordIsWrongException, NifIsNullException, NifNotValidException,
            ProceduralException, InvalidDocumentIdentificationTypeException, InvalidAccountException, InvalidDNIDocumException,
            NotEnabledException, ConnectException {
        Nif nif = new Nif("11111111a");
        Password testPassword = new Password("password1");
        VotingOption option1 = new VotingOption("incorrectParty");
        vKiosk.initVoting();
        vKiosk.setDocument('d');
        vKiosk.enterAccount("user1", testPassword);
        vKiosk.confirmIdentif('C');
        vKiosk.enterNif(nif);
        vKiosk.initOptionsNavigation();
        assertThrows(InvalidVotingOptionException.class, () -> vKiosk.consultVotingOption(option1));
    }

    @Override
    @Test
    public void wrongInputVotingOption() throws NifIsNullException, NifNotValidException, PasswordIsWrongException,
            ProceduralException, InvalidDocumentIdentificationTypeException, InvalidAccountException, InvalidDNIDocumException,
            NotEnabledException, ConnectException, InvalidVotingOptionException {
        Nif nif = new Nif("11111111a");
        Password testPassword = new Password("password1");
        VotingOption option1 = new VotingOption("party1");
        vKiosk.initVoting();
        vKiosk.setDocument('d');
        vKiosk.enterAccount("user1", testPassword);
        vKiosk.confirmIdentif('C');
        vKiosk.enterNif(nif);
        vKiosk.initOptionsNavigation();
        vKiosk.consultVotingOption(option1);
        vKiosk.vote();
        assertThrows(InvalidConfirmOptionInput.class, () -> vKiosk.confirmVotingOption('A'));
    }

    @Override
    @Test
    public void electoralOrganismConexionErrorinCanVote() throws NifIsNullException, NifNotValidException, PasswordIsWrongException,
            ProceduralException, InvalidDocumentIdentificationTypeException, InvalidAccountException, InvalidDNIDocumException,
            NotEnabledException, ConnectException {
        Nif nif = new Nif("11111111a");
        Password testPassword = new Password("password1");
        VotingOption option1 = new VotingOption("party1");
        vKiosk.initVoting();
        vKiosk.setDocument('d');
        vKiosk.enterAccount("user1", testPassword);
        vKiosk.confirmIdentif('C');
        electoralOrganism.setConnectionError();
        assertThrows(ConnectException.class, () -> vKiosk.enterNif(nif));
    }

    @Override
    @Test
    public void electoralOrganismConexionErrorInDisableVoter() throws NifIsNullException, NifNotValidException, PasswordIsWrongException,
            ProceduralException, InvalidDocumentIdentificationTypeException, InvalidAccountException, InvalidDNIDocumException,
            NotEnabledException, ConnectException, InvalidVotingOptionException {
        Nif nif = new Nif("11111111a");
        Password testPassword = new Password("password1");
        VotingOption option1 = new VotingOption("party1");
        vKiosk.initVoting();
        vKiosk.setDocument('d');
        vKiosk.enterAccount("user1", testPassword);
        vKiosk.confirmIdentif('C');
        vKiosk.enterNif(nif);
        vKiosk.initOptionsNavigation();
        vKiosk.consultVotingOption(option1);
        vKiosk.vote();
        electoralOrganism.setConnectionError();
        assertThrows(ConnectException.class, () -> vKiosk.confirmVotingOption('C'));
    }

    @Override
    @Test
    public void userHasVotedCantVoteAgain() throws NifIsNullException, NifNotValidException, PasswordIsWrongException,
            ProceduralException, InvalidDocumentIdentificationTypeException, InvalidAccountException, InvalidDNIDocumException,
            NotEnabledException, ConnectException, InvalidVotingOptionException, InvalidConfirmOptionInput {
        Nif nif = new Nif("11111111a");
        Password testPassword = new Password("password1");
        VotingOption option1 = new VotingOption("party1");
        vKiosk.initVoting();
        vKiosk.setDocument('d');
        vKiosk.enterAccount("user1", testPassword);
        vKiosk.confirmIdentif('C');
        vKiosk.enterNif(nif);
        vKiosk.initOptionsNavigation();
        vKiosk.consultVotingOption(option1);
        vKiosk.vote();
        vKiosk.confirmVotingOption('C');
        vKiosk.finalizeSession();
        vKiosk.initVoting();
        vKiosk.setDocument('d');
        vKiosk.enterAccount("user1", testPassword);
        vKiosk.confirmIdentif('C');
    }

    @Test
    public void enterAccountWithInvalidUser() throws NifIsNullException, NifNotValidException, PasswordIsWrongException,
            ProceduralException, InvalidDocumentIdentificationTypeException {
        Password testPassword = new Password("password1");
        vKiosk.initVoting();
        vKiosk.setDocument('d');
        assertThrows(InvalidAccountException.class, () -> vKiosk.enterAccount("invalidUser", testPassword));
    }

    @Test
    public void enterAccountWithValidUserButInvalidPassword() throws PasswordIsWrongException, ProceduralException,
            InvalidDocumentIdentificationTypeException {
        Password testPassword = new Password("invalidPassword1");
        vKiosk.initVoting();
        vKiosk.setDocument('d');
        assertThrows(InvalidAccountException.class, () -> vKiosk.enterAccount("user1", testPassword));
    }

    @Test
    public void enterInvalidNif() throws NifIsNullException, NifNotValidException, PasswordIsWrongException, ProceduralException,
            InvalidDocumentIdentificationTypeException, InvalidAccountException, InvalidDNIDocumException {
        Nif nif = new Nif("12345678b");
        Password testPassword = new Password("password1");
        vKiosk.initVoting();
        vKiosk.setDocument('d');
        vKiosk.enterAccount("user1", testPassword);
        vKiosk.confirmIdentif('C');
        assertThrows(NotEnabledException.class, () -> vKiosk.enterNif(nif));
    }

}

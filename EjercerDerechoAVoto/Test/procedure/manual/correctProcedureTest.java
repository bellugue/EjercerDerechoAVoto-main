package procedure.manual;

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

public class correctProcedureTest implements ProcedureTests {
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
    public void initVotingTest() throws ProceduralException {
        vKiosk.initVoting();
        assertEquals(vKiosk.getCurrentPhase(), 2);
    }

    @Override
    @Test
    public void setDocumentTest() throws InvalidDocumentIdentificationTypeException, ProceduralException {
        vKiosk.initVoting();
        vKiosk.setDocument('d');
        assertEquals(vKiosk.getCurrentPhase(), 3);
    }

    @Override
    @Test
    public void enterAccountTest() throws ProceduralException, PasswordIsNullException, InvalidAccountException, InvalidDocumentIdentificationTypeException {
        Password testPassword = new Password("password1");
        vKiosk.initVoting();
        vKiosk.setDocument('d');
        vKiosk.enterAccount("user1", testPassword);
        assertEquals(vKiosk.getCurrentPhase(), 4);
    }

    @Override
    @Test
    public void confirmIdetifTest() throws ProceduralException, InvalidDNIDocumException, PasswordIsNullException, InvalidDocumentIdentificationTypeException, InvalidAccountException {
        Password testPassword = new Password("password1");
        vKiosk.initVoting();
        vKiosk.setDocument('d');
        vKiosk.enterAccount("user1", testPassword);
        vKiosk.confirmIdentif('C');
        assertEquals(vKiosk.getCurrentPhase(), 5);
    }

    @Override
    @Test
    public void enterNifTest() throws ProceduralException, NifIsNullException, NifNotValidException, NotEnabledException, ConnectException, PasswordIsNullException, InvalidDocumentIdentificationTypeException, InvalidAccountException, InvalidDNIDocumException {
        Nif nif = new Nif("11111111a");
        Password testPassword = new Password("password1");
        vKiosk.initVoting();
        vKiosk.setDocument('d');
        vKiosk.enterAccount("user1", testPassword);
        vKiosk.confirmIdentif('C');
        vKiosk.enterNif(nif);
        assertEquals(vKiosk.getCurrentPhase(), 6);
    }
    @Override
    @Test
    public void initOptionNavegationTest() throws ProceduralException, NifIsNullException, NifNotValidException, PasswordIsNullException, InvalidDocumentIdentificationTypeException, InvalidAccountException, InvalidDNIDocumException, NotEnabledException, ConnectException {
        Nif nif = new Nif("11111111a");
        Password testPassword = new Password("password1");
        vKiosk.initVoting();
        vKiosk.setDocument('d');
        vKiosk.enterAccount("user1", testPassword);
        vKiosk.confirmIdentif('C');
        vKiosk.enterNif(nif);
        vKiosk.initOptionsNavigation();
        assertEquals(vKiosk.getCurrentPhase(), 7);
    }

    @Override
    @Test
    public void consultVotingOption() throws ProceduralException, NifIsNullException, NifNotValidException, PasswordIsNullException, InvalidDocumentIdentificationTypeException, InvalidAccountException, InvalidDNIDocumException, NotEnabledException, ConnectException, InvalidVotingOptionException {
        Nif nif = new Nif("11111111a");
        Password testPassword = new Password("password1");
        VotingOption option = new VotingOption("party1");
        vKiosk.initVoting();
        vKiosk.setDocument('d');
        vKiosk.enterAccount("user1", testPassword);
        vKiosk.confirmIdentif('C');
        vKiosk.enterNif(nif);
        vKiosk.initOptionsNavigation();
        vKiosk.consultVotingOption(option);
        assertEquals(vKiosk.getCurrentPhase(), 8);
    }

    @Override
    @Test
    public void vote() throws ProceduralException, NifIsNullException, NifNotValidException, PasswordIsNullException, InvalidDocumentIdentificationTypeException, InvalidAccountException, InvalidDNIDocumException, NotEnabledException, ConnectException, InvalidVotingOptionException {
        Nif nif = new Nif("11111111a");
        Password testPassword = new Password("password1");
        VotingOption option = new VotingOption("party1");
        vKiosk.initVoting();
        vKiosk.setDocument('d');
        vKiosk.enterAccount("user1", testPassword);
        vKiosk.confirmIdentif('C');
        vKiosk.enterNif(nif);
        vKiosk.initOptionsNavigation();
        vKiosk.consultVotingOption(option);
        vKiosk.vote();
        assertEquals(vKiosk.getCurrentPhase(), 9);
    }

    @Override
    @Test
    public void confirmVotingOption() throws ProceduralException, NifIsNullException, NifNotValidException, PasswordIsNullException, InvalidDocumentIdentificationTypeException, InvalidAccountException, InvalidDNIDocumException, NotEnabledException, ConnectException, InvalidVotingOptionException {
        Nif nif = new Nif("11111111a");
        Password testPassword = new Password("password1");
        VotingOption option = new VotingOption("party1");
        vKiosk.initVoting();
        vKiosk.setDocument('d');
        vKiosk.enterAccount("user1", testPassword);
        vKiosk.confirmIdentif('C');
        vKiosk.enterNif(nif);
        vKiosk.initOptionsNavigation();
        vKiosk.consultVotingOption(option);
        vKiosk.vote();
        vKiosk.confirmVotingOption('C');
        assertEquals(vKiosk.getCurrentPhase(), 10);
    }
    @Test
    public void userNoConfirmsOptionFirstTime() throws ProceduralException, NifIsNullException, NifNotValidException, PasswordIsNullException, InvalidDocumentIdentificationTypeException, InvalidAccountException, InvalidDNIDocumException, NotEnabledException, ConnectException, InvalidVotingOptionException {
        Nif nif = new Nif("11111111a");
        Password testPassword = new Password("password1");
        VotingOption option1 = new VotingOption("party1");
        VotingOption option2 = new VotingOption("party2");
        vKiosk.initVoting();
        vKiosk.setDocument('d');
        vKiosk.enterAccount("user1", testPassword);
        vKiosk.confirmIdentif('C');
        vKiosk.enterNif(nif);
        vKiosk.initOptionsNavigation();
        vKiosk.consultVotingOption(option1);
        vKiosk.vote();
        vKiosk.confirmVotingOption('X');
        vKiosk.consultVotingOption(option1);
        vKiosk.vote();
        vKiosk.confirmVotingOption('C');
        assertEquals(vKiosk.getCurrentPhase(), 10);
    }
}

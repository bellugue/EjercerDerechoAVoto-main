package procedure.manual;

import data.Nif;
import data.Password;
import data.VotingOption;
import evoting.votingKiosk;
import exceptions.*;
import services.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

import java.net.ConnectException;

public class wrongProcedureTest implements ProcedureTests{
    ElectoralOrganism electoralOrganism;
    LocalService localService;
    Scrutiny scrutiny;
    PoliceDepartament policeDepartament;
    votingKiosk vKiosk;
    @Override
    @BeforeEach
    public void initialize() throws NifIsNullException, NifNotValidException, PasswordIsNullException {
        electoralOrganism = new ElectoralOrganismImpl();
        localService = new LocalServiceImpl();
        scrutiny = new ScrutinyImpl();
        policeDepartament = new PoliceDepartamentDNI();

        vKiosk = new votingKiosk();
        vKiosk.setElectoralOrganism(electoralOrganism);
        vKiosk.setScrutiny(scrutiny);
        vKiosk.setLocalService(localService);
    }

    @Override
    @Test
    public void initVotingTest() throws ProceduralException, InvalidDocumentIdentificationTypeException {
        vKiosk.initVoting();
        vKiosk.setDocument('d');
        assertThrows(ProceduralException.class, () -> vKiosk.initVoting());
    }

    @Override
    @Test
    public void setDocumentTest() throws InvalidDocumentIdentificationTypeException, ProceduralException {
        assertThrows(ProceduralException.class, () -> vKiosk.setDocument('d'));
    }

    @Override
    @Test
    public void enterAccountTest() throws PasswordIsNullException, InvalidAccountException, InvalidDocumentIdentificationTypeException {
        Password testPsw = new Password("aaaa");
        assertThrows(ProceduralException.class, () -> vKiosk.enterAccount("user", testPsw));
    }

    @Override
    @Test
    public void confirmIdetifTest() throws ProceduralException, InvalidDNIDocumException, PasswordIsNullException, InvalidDocumentIdentificationTypeException, InvalidAccountException {
        assertThrows(ProceduralException.class, () -> vKiosk.confirmIdentif('C'));
    }

    @Override
    @Test
    public void enterNifTest() throws ProceduralException, NifIsNullException, NifNotValidException, NotEnabledException, ConnectException, PasswordIsNullException, InvalidDocumentIdentificationTypeException, InvalidAccountException, InvalidDNIDocumException {
        Nif nif = new Nif("11111111a");
        assertThrows(ProceduralException.class, () -> vKiosk.enterNif(nif));
    }

    @Override
    @Test
    public void initOptionNavegationTest() throws ProceduralException, NifIsNullException, NifNotValidException, PasswordIsNullException, InvalidDocumentIdentificationTypeException, InvalidAccountException, InvalidDNIDocumException, NotEnabledException, ConnectException {
        assertThrows(ProceduralException.class, () -> vKiosk.initOptionsNavigation());
    }

    @Override
    @Test
    public void consultVotingOption() throws ProceduralException, NifIsNullException, NifNotValidException, PasswordIsNullException, InvalidDocumentIdentificationTypeException, InvalidAccountException, InvalidDNIDocumException, NotEnabledException, ConnectException {
        VotingOption option = new VotingOption("party1");
        assertThrows(ProceduralException.class, () -> vKiosk.consultVotingOption(option));
    }

    @Override
    @Test
    public void vote() throws ProceduralException, NifIsNullException, NifNotValidException, PasswordIsNullException, InvalidDocumentIdentificationTypeException, InvalidAccountException, InvalidDNIDocumException, NotEnabledException, ConnectException {
        assertThrows(ProceduralException.class, () -> vKiosk.vote());
    }

    @Override
    @Test
    public void confirmVotingOption() throws ProceduralException, NifIsNullException, NifNotValidException, PasswordIsNullException, InvalidDocumentIdentificationTypeException, InvalidAccountException, InvalidDNIDocumException, NotEnabledException, ConnectException {
        assertThrows(ProceduralException.class, () -> vKiosk.confirmVotingOption('C'));
    }
}

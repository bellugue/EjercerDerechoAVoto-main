package functioning;

import exceptions.NifIsNullException;
import exceptions.NifNotValidException;
import exceptions.PasswordIsNullException;

public interface FunctionTest {

    void initialize() throws NifIsNullException, NifNotValidException, PasswordIsNullException;

    void setIncorrectDocumentOption();
    void consultIncorrectVotingOption();
    void wrongInputVotingOption();
    void electoralOrganismConexionErrorinCanVote();
    void electoralOrganismConexionErrorInDisableVoter();




}

package functioning;

import exceptions.NifIsNullException;
import exceptions.NifNotValidException;
import exceptions.PasswordIsNullException;
import exceptions.ProceduralException;

public interface FunctionTest {

    void initialize() throws NifIsNullException, NifNotValidException, PasswordIsNullException;

    void setIncorrectDocumentOption() throws ProceduralException;
    void consultIncorrectVotingOption();
    void wrongInputVotingOption();
    void electoralOrganismConexionErrorinCanVote();
    void electoralOrganismConexionErrorInDisableVoter();




}

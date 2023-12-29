import exceptions.NifIsNullException;
import exceptions.NifNotValidException;
import exceptions.PasswordIsNullException;
import exceptions.ProceduralException;

public interface TestingIntf {
    void initialize() throws NifIsNullException, NifNotValidException, PasswordIsNullException;
    void initVotingTest() throws ProceduralException;

    //Default tests
}

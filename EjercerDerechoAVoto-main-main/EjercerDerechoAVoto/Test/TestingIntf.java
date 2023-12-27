import exceptions.NifIsNullException;
import exceptions.NifNotValidException;
import exceptions.PasswordIsNullException;

public interface TestingIntf {
    void initialize() throws NifIsNullException, NifNotValidException, PasswordIsNullException;
    void initVotingTest();

    //Default tests
}

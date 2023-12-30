package data;

import exceptions.NifIsNullException;
import exceptions.NifNotValidException;
import exceptions.PasswordIsNullException;

public interface dataTestingIntf {
    void init();
    void nifIsNull() throws NifIsNullException, NifNotValidException;
    void nifIsNotValid() throws NifIsNullException, NifNotValidException;
    void nifIsValid();
    void passwordIsNull() throws PasswordIsNullException;
    void passwordIsEmpty();
    void passwordIsCorrect();
}

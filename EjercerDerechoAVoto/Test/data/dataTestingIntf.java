package data;

import exceptions.NifIsNullException;
import exceptions.NifNotValidException;
import exceptions.PasswordIsWrongException;

public interface dataTestingIntf {
    void init();
    void nifIsNull() throws NifIsNullException, NifNotValidException;
    public void nifIsEmpty() throws NifNotValidException;
    void nifIsNotValid() throws NifIsNullException, NifNotValidException;
    void nifIsValid() throws NifIsNullException, NifNotValidException;
    void passwordIsNull() throws PasswordIsWrongException;
    void passwordIsEmpty() throws PasswordIsWrongException;
    void passwordIsValid() throws PasswordIsWrongException;
}

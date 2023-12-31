package data;

import exceptions.NifIsNullException;
import exceptions.NifNotValidException;
import exceptions.PasswordIsNullException;

public interface dataTestingIntf {
    void init();
    void nifIsNull() throws NifIsNullException, NifNotValidException;
    public void nifIsEmpty() throws NifNotValidException;
    void nifIsNotValid() throws NifIsNullException, NifNotValidException;
    void nifIsValid() throws NifIsNullException, NifNotValidException;
    void passwordIsNull() throws PasswordIsNullException;
    void passwordIsEmpty() throws PasswordIsNullException;
    void passwordIsValid() throws PasswordIsNullException;
}

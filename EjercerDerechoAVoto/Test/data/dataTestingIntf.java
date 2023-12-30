package data;

import exceptions.NifIsNullException;
import exceptions.NifNotValidException;
import exceptions.PasswordIsNullException;

public interface dataTestingIntf {
    void initNif() throws NifIsNullException, NifNotValidException;
    void nifIsNull() throws NifIsNullException, NifNotValidException;
    void nifIsNotValid() throws NifIsNullException, NifNotValidException;
    void initPassword() throws PasswordIsNullException;
    void password() throws PasswordIsNullException;
}

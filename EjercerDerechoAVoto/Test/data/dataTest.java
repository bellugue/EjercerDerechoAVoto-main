package data;

import exceptions.NifIsNullException;
import exceptions.NifNotValidException;
import exceptions.PasswordIsWrongException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class dataTest implements dataTestingIntf {
    private Nif nif;
    private Password password;

    @Override
    @BeforeEach
    public void init(){
        nif = null;
        password = null;
    }

    @Override
    @Test
    public void nifIsNull() throws NifIsNullException {
        assertThrows(NifIsNullException.class, () -> nif = new Nif(null));
    }

    @Override
    @Test
    public void nifIsEmpty() throws NifNotValidException {
        assertThrows(NifNotValidException.class, () -> nif = new Nif(""));
    }

    @Override
    @Test
    public void nifIsNotValid() throws NifNotValidException {
        assertThrows(NifNotValidException.class, () -> nif = new Nif("aaaaaaaaa"));
    }

    @Override
    @Test
    public void nifIsValid() throws NifIsNullException, NifNotValidException {
        nif = new Nif("11111111a");
    }

    @Override
    @Test
    public void passwordIsNull() throws PasswordIsWrongException {
        assertThrows(PasswordIsWrongException.class, () -> password = new Password(null));
    }

    @Override
    @Test
    public void passwordIsEmpty() throws PasswordIsWrongException {
        assertThrows(PasswordIsWrongException.class, () -> password = new Password(""));
    }

    @Override
    @Test
    public void passwordHasNotDigit() throws PasswordIsWrongException {
        assertThrows(PasswordIsWrongException.class, () -> password = new Password("aaaa"));
    }

    @Override
    @Test
    public void passwordHasNotChar() throws PasswordIsWrongException {
        assertThrows(PasswordIsWrongException.class, () -> password = new Password("1111"));
    }

    @Override
    @Test
    public void passwordIsValid() throws PasswordIsWrongException {
        password = new Password("testing1");
    }
}

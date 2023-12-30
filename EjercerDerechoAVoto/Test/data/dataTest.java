package data;

import exceptions.NifIsNullException;
import exceptions.NifNotValidException;
import exceptions.PasswordIsNullException;
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
    public void nifIsNotValid() throws NifNotValidException {
        assertThrows(NifNotValidException.class, () -> nif = new Nif("aaa"));
    }

    @Override
    public void nifIsValid() {

    }

    @Override
    public void passwordIsNull() throws PasswordIsNullException {

    }

    @Override
    public void passwordIsEmpty() {

    }

    @Override
    public void passwordIsCorrect() {

    }
}

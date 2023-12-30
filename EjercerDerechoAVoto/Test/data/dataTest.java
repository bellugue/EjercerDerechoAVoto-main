package data;

import exceptions.NifIsNullException;
import exceptions.NifNotValidException;
import exceptions.PasswordIsNullException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class dataTest implements dataTestingIntf {
    private Nif nif;
    private String numberOfNif = "aaa";

    @Override
    @BeforeEach
    public void initNif() throws NifIsNullException, NifNotValidException {

    }

    @Override
    @Test
    public void nifIsNull() throws NifIsNullException {
        assertThrows(NifIsNullException.class, () -> nif = new Nif(null));
    }

    @Override
    @Test
    public void nifIsNotValid() throws NifNotValidException {
        assertThrows(NifNotValidException.class, () -> nif = new Nif(numberOfNif));
    }

    @Override
    public void initPassword() throws PasswordIsNullException {

    }

    @Override
    public void password() throws PasswordIsNullException {

    }
}

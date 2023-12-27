import data.Nif;
import exceptions.NifIsNullException;
import exceptions.NifNotValidException;
import exceptions.PasswordIsNullException;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class dataTest implements dataTestingIntf {
    private Nif nif;
    private String numberOfNif = "aaa";

    @Override
    @BeforeEach
    public void initNif() throws NifIsNullException, NifNotValidException {
        nif = new Nif(numberOfNif);
    }

    @Override
    public void nifIsNull() throws NifIsNullException, NifNotValidException {
        //No se com acabar de comprovar aixo
        assertThrows(NifIsNullException.class, () -> nifIsNull());
    }

    @Override
    public void nifIsNotValid() throws NifIsNullException, NifNotValidException {

    }

    @Override
    public void initPassword() throws PasswordIsNullException {

    }

    @Override
    public void password() throws PasswordIsNullException {

    }
}

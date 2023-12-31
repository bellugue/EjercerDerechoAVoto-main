package evoting.biometricdataperipherial;

import data.Nif;
import data.biometricaldataperipherial.BiometricData;
import exceptions.NifIsNullException;
import exceptions.NifNotValidException;
import exceptions.biometricaldataperipherial.PassportBiometricReadingException;
import exceptions.NotValidPassportException;
public interface PassportBiometricReader {
    void validatePassport () throws NotValidPassportException, NifIsNullException, NifNotValidException;
    Nif getNifWithOCR ();
    BiometricData getPassportBiometricData ()
            throws PassportBiometricReadingException;
    void setErrorNif();
    void setErrorData();
}

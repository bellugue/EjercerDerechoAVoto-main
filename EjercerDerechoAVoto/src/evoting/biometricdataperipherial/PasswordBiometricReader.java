package evoting.biometricdataperipherial;

import data.Nif;
import data.biometricaldataperipherial.BiometricData;
import exceptions.biometricaldataperipherial.PassportBiometricReadingException;
import exceptions.NotValidPassportException;
public interface PasswordBiometricReader {
    void validatePassport () throws NotValidPassportException;
    Nif getNifWithOCR ();
    BiometricData getPassportBiometricData ()
            throws PassportBiometricReadingException;
}

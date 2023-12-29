package evoting.biometricdataperipherial;

import data.Nif;
import data.biometricaldataperipherial.BiometricData;
import exceptions.NotValidPassportException;
import exceptions.biometricaldataperipherial.PassportBiometricReadingException;

public class PassportReader implements PassportBiometricReader{
    @Override
    public void validatePassport() throws NotValidPassportException {

    }

    @Override
    public Nif getNifWithOCR() {
        return null;
    }

    @Override
    public BiometricData getPassportBiometricData() throws PassportBiometricReadingException {
        return null;
    }
}

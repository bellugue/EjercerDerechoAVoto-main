package evoting.biometricdataperipherial;

import data.Nif;
import data.biometricaldataperipherial.BiometricData;
import exceptions.NotValidPassportException;
import exceptions.biometricaldataperipherial.PassportBiometricReadingException;
import services.PoliceDepartamentDNI;

public class PassportReader implements PassportBiometricReader{
    PoliceDepartamentDNI policeDepartamentDNI;
    Nif nif;
    @Override
    public void validatePassport() throws NotValidPassportException {
        if (!policeDepartamentDNI.isDNIValid(nif)) {
            throw new NotValidPassportException("El nif" + nif + "no és vàlid.");
        }
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

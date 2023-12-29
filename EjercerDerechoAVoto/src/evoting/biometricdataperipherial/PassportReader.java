package evoting.biometricdataperipherial;

import data.Nif;
import data.biometricaldataperipherial.BiometricData;
import exceptions.NifIsNullException;
import exceptions.NifNotValidException;
import exceptions.NotValidPassportException;
import exceptions.biometricaldataperipherial.PassportBiometricReadingException;
import services.PoliceDepartament;
import services.PoliceDepartamentDNI;

public class PassportReader implements PassportBiometricReader{
    PoliceDepartament policeDepartamentDNI;
    Nif nif;

    public PassportReader() throws NifIsNullException, NifNotValidException {
        policeDepartamentDNI = new PoliceDepartamentDNI();
    }

    @Override
    public void validatePassport() throws NotValidPassportException {
        if (!policeDepartamentDNI.isDNIValid(nif)) {
            throw new NotValidPassportException("El nif" + nif + "no és vàlid.");
        }
    }

    @Override
    public Nif getNifWithOCR() {
        return nif;
    }

    @Override
    public BiometricData getPassportBiometricData() throws PassportBiometricReadingException {
        return null;
    }
}

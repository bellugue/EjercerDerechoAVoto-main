package evoting.biometricdataperipherial;

import data.Nif;
import data.biometricaldataperipherial.BiometricData;
import data.biometricaldataperipherial.SingleBiometricData;
import exceptions.NifIsNullException;
import exceptions.NifNotValidException;
import exceptions.NotValidPassportException;
import exceptions.biometricaldataperipherial.PassportBiometricReadingException;
import services.PoliceDepartament;
import services.PoliceDepartamentDNI;

public class PassportReader implements PassportBiometricReader{
    PoliceDepartament policeDepartamentDNI;
    Nif nif;
    BiometricData data;
    boolean errorNif = false;
    boolean errorData = false;
    public PassportReader() throws NifIsNullException, NifNotValidException {
        policeDepartamentDNI = new PoliceDepartamentDNI();
    }

    @Override
    public void validatePassport() throws NotValidPassportException, NifIsNullException, NifNotValidException {
        //"Lectura"
        if(errorNif){
            nif = new Nif("12345678b");
        }
        else{
            nif = new Nif("11111111a");
        }
        data = new BiometricData(new SingleBiometricData("FacialData1".getBytes()), new SingleBiometricData("FingerPrintData1".getBytes()));

        if (!policeDepartamentDNI.isDNIValid(nif)) {
            throw new NotValidPassportException("El nif" + nif + "no és vàlid.");
        }
        System.out.println("El passaport és vàlid.");
    }

    @Override
    public Nif getNifWithOCR() {
        return nif;
    }

    @Override
    public BiometricData getPassportBiometricData() throws PassportBiometricReadingException {
        if(errorData){
            throw new PassportBiometricReadingException("Error al llegir les dades biometriques");
        }
        return data;
    }

    @Override
    public void setErrorNif() {
        this.errorNif = true;
    }

    @Override
    public void setErrorData() {
        this.errorData = true;
    }

}

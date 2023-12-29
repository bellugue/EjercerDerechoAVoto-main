package evoting.biometricdataperipherial;

import data.Nif;
import data.biometricaldataperipherial.BiometricData;
import data.biometricaldataperipherial.SingleBiometricData;
import exceptions.NifIsNullException;
import exceptions.NifNotValidException;
import exceptions.biometricaldataperipherial.HumanBiometricScanningException;

import java.util.HashMap;

public class HumanScanner implements HumanBiometricScanner{

    boolean error = false;

    @Override
    public SingleBiometricData scanFaceBiometrics(Nif userNif) throws HumanBiometricScanningException {
        if(error)
            throw new HumanBiometricScanningException("No s'ha llegit correctament les dades biometriques facials");
        return new SingleBiometricData("FacialData1".getBytes());
    }

    @Override
    public SingleBiometricData scanFingerprintBiometrics(Nif userNif) throws HumanBiometricScanningException {
        if(error)
            throw new HumanBiometricScanningException("No s'ha llegit correctament les dades biometriques de les empremptes");
        return new SingleBiometricData("FingerPrintData1".getBytes());
    }

    public boolean setError(){
        error = true;
    }
}

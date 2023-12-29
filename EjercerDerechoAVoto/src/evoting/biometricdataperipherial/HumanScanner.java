package evoting.biometricdataperipherial;

import data.Nif;
import data.biometricaldataperipherial.BiometricData;
import data.biometricaldataperipherial.SingleBiometricData;
import exceptions.NifIsNullException;
import exceptions.NifNotValidException;
import exceptions.biometricaldataperipherial.HumanBiometricScanningException;

import java.util.HashMap;

public class HumanScanner implements HumanBiometricScanner{
    HashMap<Nif, BiometricData> read;
    public HumanScanner() throws NifIsNullException, NifNotValidException {
        read = new HashMap<>();
        read.put(new Nif("11111111a"), new BiometricData(new SingleBiometricData("FacialData1".getBytes()), new SingleBiometricData("FingerPrintsData1".getBytes())));
        read.put(new Nif("22222222a"), new BiometricData(new SingleBiometricData("FacialData2".getBytes()), new SingleBiometricData("FingerPrintsData2".getBytes())));
    }

    @Override
    public SingleBiometricData scanFaceBiometrics(Nif userNif) throws HumanBiometricScanningException {
        for (Nif nif : read.keySet()){
            if(nif.equals(nif)){
                return read.get(nif).getFacialData();
            }
        }
        throw new HumanBiometricScanningException("No s'ha llegit correctament les dades biometriques facials");
    }

    @Override
    public SingleBiometricData scanFingerprintBiometrics(Nif userNif) throws HumanBiometricScanningException {
        for(Nif nif : read.keySet()){
            if(nif.equals(userNif)){
                return read.get(nif).getFingerprintData();
            }
        }
        throw new HumanBiometricScanningException("No s'ha llegit correctament les dades biometriques de les empremtes dactilars");
    }
}

package evoting.biometricdataperipherial;

import data.Nif;
import data.biometricaldataperipherial.SingleBiometricData;
import exceptions.biometricaldataperipherial.HumanBiometricScanningException;

public interface HumanBiometricScanner {
    SingleBiometricData scanFaceBiometrics (Nif nif) throws HumanBiometricScanningException;
    SingleBiometricData scanFingerprintBiometrics (Nif usernif) throws HumanBiometricScanningException;
}

package evoting.biometricdataperipherial;

import data.biometricaldataperipherial.SingleBiometricData;
import exceptions.biometricaldataperipherial.HumanBiometricScanningException;

public interface HumanBiometricScanner {
    SingleBiometricData scanFaceBiometrics () throws HumanBiometricScanningException;
    SingleBiometricData scanFingerprintBiometrics () throws HumanBiometricScanningException;
}

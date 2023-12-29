package data.biometricaldataperipherial;

public class BiometricData {

    private SingleBiometricData facialData;
    private SingleBiometricData fingerprintData;

    public BiometricData(SingleBiometricData facialData, SingleBiometricData fingerprintData){
        this.facialData = facialData;
        this.fingerprintData = fingerprintData;
    }

    public void setFacialData(SingleBiometricData facialData){
        this.facialData = facialData;
    }

    public void setFingerprintData(SingleBiometricData fingerprintData){
        this.fingerprintData = fingerprintData;
    }

    public SingleBiometricData getFacialData(){
        return facialData;
    }

    public SingleBiometricData getFingerprintData(){
        return fingerprintData;
    }
}

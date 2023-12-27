package data.biometricaldataperipherial;

public class SingleBiometricData {

    private Byte[] data;

    public SingleBiometricData(byte[] data){
        this.data = data;
    }

    public Byte[] getData() {
        return data;
    }
}

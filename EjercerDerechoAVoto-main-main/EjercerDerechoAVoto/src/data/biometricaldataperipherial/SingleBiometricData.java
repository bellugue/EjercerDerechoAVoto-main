package data.biometricaldataperipherial;

public class SingleBiometricData {

    private byte[] data;

    public SingleBiometricData(byte[] data){
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }
}

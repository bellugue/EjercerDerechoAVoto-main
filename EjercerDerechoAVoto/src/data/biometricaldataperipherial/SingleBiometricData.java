package data.biometricaldataperipherial;

public class SingleBiometricData {

    private Byte[] data;

    public SingleBiometricData(Byte[] data){
        this.data = data;
    }

    public Byte[] getData() {
        return data;
    }
}

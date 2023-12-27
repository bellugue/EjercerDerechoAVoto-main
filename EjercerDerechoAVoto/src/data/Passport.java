package data;

import data.biometricaldataperipherial.BiometricData;
import data.biometricaldataperipherial.SingleBiometricData;

public class Passport {
    private Nif nif;
    private BiometricData userData;

    public void setNif(Nif nif){
        this.nif = nif;
    }

    public void setUserData(SingleBiometricData facialData, SingleBiometricData fingerPrintsData){
        this.userData = new BiometricData(facialData, fingerPrintsData);
    }

    public Nif getNif() {
        return nif;
    }

    public BiometricData getUserData(){return this.userData;}
}

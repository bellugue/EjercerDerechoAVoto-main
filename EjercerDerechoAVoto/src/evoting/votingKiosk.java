package evoting;

import data.Nif;
import data.Password;
import data.VotingOption;
import data.biometricaldataperipherial.BiometricData;
import exceptions.InvalidAccountException;
import exceptions.InvalidDNIDocumException;
import exceptions.NotEnabledException;
import exceptions.NotValidPassportException;
import exceptions.biometricaldataperipherial.BiometricVerificationFailedException;
import exceptions.biometricaldataperipherial.HumanBiometricScanningException;
import exceptions.biometricaldataperipherial.PassportBiometricReadingException;
import services.ElectoralOrganism;
import services.LocalService;
import services.Scrutiny;

import java.net.ConnectException;

public class votingKiosk {
    private ElectoralOrganism electoralOrganism;
    private LocalService localService;
    private Scrutiny scrutiny;

    private int currentPhase;
    private BiometricData userData;
    private VotingOption option;
    public votingKiosk(){currentPhase=1;}

    public void initVoting () {
        System.out.println("S'ha seleccionat la votacio electronica");
    }
    public void setDocument (char opt) {
        switch (opt){
            case 'd': //DNI (això ho he ficat així per ficar algo...)
            case 'D':
                System.out.println("DNI");
                break;
            case 'p': //Passaport (X2)
            case 'P':
                System.out.println("PASSPORT");
                break;
            default: //Lo que s'ha entrar no es ni un DNI ni passaport
                //throw new AlgunaException("DNI -> <...> ; Passport -> <...>");
        }
    }
    public void enterAccount (String login, Password pssw) throws InvalidAccountException {
        localService.verifyAccount(login, pssw);
        System.out.println("L'usuari ha accedit correctament.");
    }
    public void confirmIdentif (char conf) throws InvalidDNIDocumException {
        switch(conf){
            case('C'):
                System.out.println("S'ha confirmat la identificació");
            case('X'):
                throw new InvalidDNIDocumException("El document no es vàlid");
        }
    }
    public void enterNif (Nif nif) throws NotEnabledException, ConnectException {
        electoralOrganism.canVote(nif);
        System.out.println("El nif " + nif + " és vàlid");
    }
    public void initOptionsNavigation () {

    }
    public void consultVotingOption (VotingOption vopt) {
        System.out.println(vopt.toString());
    }
    public void vote () {

    }
    public void confirmVotingOption (char conf) throws ConnectException {

    }

    private void verifiyBiometricData(BiometricData humanBioD, BiometricData passpBioD)
            throws BiometricVerificationFailedException {
        if(!humanBioD.getFacialData().equals(passpBioD.getFacialData())){
            throw new BiometricVerificationFailedException("Les dades facials no concorden");
        }
        System.out.println("Verificació facial OK!");
        if(!humanBioD.getFingerprintData().equals(passpBioD.getFingerprintData())){
            throw new BiometricVerificationFailedException("Les dades de les empremtes dactilars no concorden");
        }
        System.out.println("Verificació de les empremtes dactilars OK!");
        System.out.println("Verificació de les dades biometriques de l'usuari OK.");

    }
    private void removeBiometricData () {
        userData = null;
    }

    public void grantExplicitConsent (char cons) {
        switch (cons){
            case('C'):
            case('c'):
                System.out.println("S'ha acceptat el consentiment explícit");
            case('X'):
            case('x'):
                System.out.println("No s'ha acceptat el consentiment");
        }
    }
    public void readPassport () throws NotValidPassportException, PassportBiometricReadingException {

    }

    public void readFaceBiometrics () throws HumanBiometricScanningException {

    }
    public void readFingerPrintBiometrics () throws NotEnabledException, HumanBiometricScanningException,
            BiometricVerificationFailedException, ConnectException {

    }

    private void finalizeSession () {

    }

    // Setter methods for injecting dependences and additional methods
    public void setElectoralOrganism(ElectoralOrganism electoralOrganism) {
        this.electoralOrganism = electoralOrganism;
    }

    public void setLocalService(LocalService localService) {
        this.localService = localService;
    }

    public void setScrutiny(Scrutiny scrutiny) {
        this.scrutiny = scrutiny;
    }
}

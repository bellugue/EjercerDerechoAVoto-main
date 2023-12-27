package evoting;

import data.Nif;
import data.Passport;
import data.Password;
import data.VotingOption;
import data.biometricaldataperipherial.BiometricData;
import exceptions.*;
import exceptions.biometricaldataperipherial.BiometricVerificationFailedException;
import exceptions.biometricaldataperipherial.HumanBiometricScanningException;
import exceptions.biometricaldataperipherial.PassportBiometricReadingException;
import services.ElectoralOrganism;
import services.LocalService;
import services.PoliceDepartament;
import services.Scrutiny;

import java.net.ConnectException;

public class votingKiosk {
    private ElectoralOrganism electoralOrganism;
    private LocalService localService;
    private Scrutiny scrutiny;
    private PoliceDepartament policeDepartament;

    private int currentPhase;
    private BiometricData userData;
    private VotingOption option;
    private Boolean vote = false;
    private Nif nif;
    private Boolean explicitContent = false;
    private Passport passport;
    public votingKiosk(){currentPhase=1;}

    public void initVoting () {
        System.out.println("S'ha seleccionat la votació electronica");
        currentPhase++;
    }
    public void setDocument (char opt) throws InvalidDocumentIdentificationTypeException {
        switch (opt){
            case 'd':
            case 'D':
                System.out.println("DNI");
                break;
            case 'p': //Passaport (X2)
            case 'P':
                System.out.println("PASSPORT");
                break;
            default: //Lo que s'ha entrar no es ni un DNI ni passaport
                throw new InvalidDocumentIdentificationTypeException("El document ha de ser o bé DNI <D/d>, o bé passaport <P/p>");
        }
        currentPhase++;
    }
    public void enterAccount (String login, Password pssw) throws InvalidAccountException {
        localService.verifyAccount(login, pssw);
        System.out.println("L'usuari ha accedit correctament.");
        currentPhase++;
    }
    public void confirmIdentif (char conf) throws InvalidDNIDocumException {
        switch(conf){
            case('C'):
                System.out.println("S'ha confirmat la identificació");
            case('X'):
                throw new InvalidDNIDocumException("El document no es vàlid");
        }
        currentPhase++;
    }
    public void enterNif (Nif nif) throws NotEnabledException, ConnectException {
        electoralOrganism.canVote(nif);
        this.nif = nif;
        System.out.println("El nif " + nif + " és vàlid");
        currentPhase++;
    }
    public void initOptionsNavigation () {
        for(VotingOption opt : scrutiny.getAllVotingOptions()){
            System.out.println(opt.getParty());
        }
        System.out.print("\nSeleccioni un partit a votar:\n");
        currentPhase++;
    }
    public void consultVotingOption (VotingOption vopt) {
        System.out.println("Informació relacionada de " + vopt.getParty());
        System.out.println(vopt.toString());
        currentPhase++;
    }
    public void vote () throws ProceduralException {
        if(option == null){
            throw new ProceduralException("Error -> S'ha votat un partit sense seleccionar-lo.");
        }
        System.out.println("S'ha seleccionat per votar el partit " + option.getParty());
        currentPhase++;
    }
    public void confirmVotingOption (char conf) throws ConnectException {
        switch (conf){
            case('C'):
            case('c'):
                System.out.println("S'ha confirmat correctament l'opció " + option.getParty());
                break;
            case('X'):
            case('x'):
                System.out.println("S'ha denegat l'opció seleccionada, seleccioni una opció.");
                return;
        }
        scrutiny.scrutinize(option);
        electoralOrganism.disableVoter(nif);
        currentPhase++;

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
        currentPhase++;
    }
    private void removeBiometricData () {
        userData = null;
        currentPhase++;
    }

    public void grantExplicitConsent (char cons) {
        switch (cons){
            case('C'):
            case('c'):
                System.out.println("S'ha acceptat el consentiment explícit");
                break;
            case('X'):
            case('x'):
                System.out.println("No s'ha acceptat el consentiment");
                break;
        }
        currentPhase++;
    }
    public void readPassport (Passport passport) throws NotValidPassportException, PassportBiometricReadingException {
        if(!policeDepartament.isDNIValid(passport.getNif())){
            throw new NotValidPassportException("Passport amb nif " + nif + " no és valid.");
        }
        BiometricData passportData = passport.getUserData();
        if(passportData == null){
            throw new PassportBiometricReadingException("No s'ha pogut llegir correctament les dades biometriques del passaport");
        }
        currentPhase++;
    }

    public void readFaceBiometrics () throws HumanBiometricScanningException {
        currentPhase++;
    }
    public void readFingerPrintBiometrics () throws NotEnabledException, HumanBiometricScanningException,
            BiometricVerificationFailedException, ConnectException {
        currentPhase++;
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

    public void setPoliceDepartament(PoliceDepartament policeDepartament) {
        this.policeDepartament = policeDepartament;
    }

    public int getCurrentPhase(){
        return this.currentPhase;
    }
}

package procedure.biometric;

import exceptions.*;
import exceptions.biometricaldataperipherial.BiometricVerificationFailedException;
import exceptions.biometricaldataperipherial.HumanBiometricScanningException;
import exceptions.biometricaldataperipherial.PassportBiometricReadingException;

import java.net.ConnectException;

public interface ProcedureTest {

    void initialize() throws NifIsNullException, NifNotValidException, PasswordIsNullException;
    void iniVoting() throws ProceduralException;
    void setDocument() throws ProceduralException, InvalidDocumentIdentificationTypeException;
    void grantExplicitContent() throws ProceduralException, InvalidDocumentIdentificationTypeException;
    void readPassport() throws ProceduralException, InvalidDocumentIdentificationTypeException, NifIsNullException, PassportBiometricReadingException, NifNotValidException, NotValidPassportException;
    void readFaceBiometrics() throws ProceduralException, InvalidDocumentIdentificationTypeException, NifIsNullException, PassportBiometricReadingException, NifNotValidException, NotValidPassportException, HumanBiometricScanningException;
    void readFingerPrintBiometrics() throws ProceduralException, InvalidDocumentIdentificationTypeException, NifIsNullException, PassportBiometricReadingException, NifNotValidException, NotValidPassportException, HumanBiometricScanningException, BiometricVerificationFailedException, NotEnabledException, ConnectException;
    void initOptionsNavigator() throws ProceduralException, InvalidDocumentIdentificationTypeException, NifIsNullException, PassportBiometricReadingException, NifNotValidException, NotValidPassportException, HumanBiometricScanningException, BiometricVerificationFailedException, NotEnabledException, ConnectException;
    void consultVotingOption();
    void vote();
    void confirmVotingOption();
}

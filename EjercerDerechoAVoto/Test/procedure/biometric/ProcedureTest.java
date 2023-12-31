package procedure.biometric;

import exceptions.*;
import exceptions.biometricaldataperipherial.BiometricVerificationFailedException;
import exceptions.biometricaldataperipherial.HumanBiometricScanningException;
import exceptions.biometricaldataperipherial.PassportBiometricReadingException;

import java.net.ConnectException;

public interface ProcedureTest {

    void initialize() throws NifIsNullException, NifNotValidException, PasswordIsWrongException;
    void iniVoting() throws ProceduralException;
    void setDocument() throws ProceduralException, InvalidDocumentIdentificationTypeException;
    void grantExplicitContent() throws ProceduralException, InvalidDocumentIdentificationTypeException, ExplicitConsetNotAprovedException;
    void readPassport() throws ProceduralException, InvalidDocumentIdentificationTypeException, NifIsNullException,
            PassportBiometricReadingException, NifNotValidException, NotValidPassportException, ExplicitConsetNotAprovedException;
    void readFaceBiometrics() throws ProceduralException, InvalidDocumentIdentificationTypeException, NifIsNullException,
            PassportBiometricReadingException, NifNotValidException, NotValidPassportException, HumanBiometricScanningException,
            ExplicitConsetNotAprovedException;
    void readFingerPrintBiometrics() throws ProceduralException, InvalidDocumentIdentificationTypeException, NifIsNullException,
            PassportBiometricReadingException, NifNotValidException, NotValidPassportException, HumanBiometricScanningException,
            BiometricVerificationFailedException, NotEnabledException, ConnectException, ExplicitConsetNotAprovedException;
    void initOptionsNavigator() throws ProceduralException, InvalidDocumentIdentificationTypeException, NifIsNullException,
            PassportBiometricReadingException, NifNotValidException, NotValidPassportException, HumanBiometricScanningException,
            BiometricVerificationFailedException, NotEnabledException, ConnectException, ExplicitConsetNotAprovedException;
    void consultVotingOption() throws ProceduralException, InvalidDocumentIdentificationTypeException, NifIsNullException,
            PassportBiometricReadingException, NifNotValidException, NotValidPassportException, HumanBiometricScanningException,
            BiometricVerificationFailedException, NotEnabledException, ConnectException, ExplicitConsetNotAprovedException,
            InvalidVotingOptionException;
    void vote() throws ProceduralException, InvalidDocumentIdentificationTypeException, NifIsNullException, PassportBiometricReadingException,
            NifNotValidException, NotValidPassportException, HumanBiometricScanningException, BiometricVerificationFailedException,
            NotEnabledException, ConnectException, ExplicitConsetNotAprovedException, InvalidVotingOptionException;
    void confirmVotingOption() throws ProceduralException, InvalidDocumentIdentificationTypeException, NifIsNullException,
            PassportBiometricReadingException, NifNotValidException, NotValidPassportException, HumanBiometricScanningException,
            BiometricVerificationFailedException, NotEnabledException, ConnectException, ExplicitConsetNotAprovedException,
            InvalidVotingOptionException, InvalidConfirmOptionInput;
}

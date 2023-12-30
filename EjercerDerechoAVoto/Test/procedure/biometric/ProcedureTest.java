package procedure.biometric;

import exceptions.*;
import exceptions.biometricaldataperipherial.PassportBiometricReadingException;

public interface ProcedureTest {

    void initialize() throws NifIsNullException, NifNotValidException, PasswordIsNullException;
    void iniVoting() throws ProceduralException;
    void setDocument() throws ProceduralException, InvalidDocumentIdentificationTypeException;
    void grantExplicitContent() throws ProceduralException, InvalidDocumentIdentificationTypeException;
    void readPassport() throws ProceduralException, InvalidDocumentIdentificationTypeException, NifIsNullException, PassportBiometricReadingException, NifNotValidException, NotValidPassportException;
    void readFaceBiometrics();
    void readFingerPrintBiometrics();
    void initOptionsNavigator();
    void consultVotingOption();
    void vote();
    void confirmVotingOption();
}

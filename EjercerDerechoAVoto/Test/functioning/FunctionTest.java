package functioning;

import exceptions.*;
import exceptions.biometricaldataperipherial.BiometricVerificationFailedException;
import exceptions.biometricaldataperipherial.HumanBiometricScanningException;
import exceptions.biometricaldataperipherial.PassportBiometricReadingException;

import java.net.ConnectException;

public interface FunctionTest {

    void initialize() throws NifIsNullException, NifNotValidException, PasswordIsNullException;

    void setIncorrectDocumentOption() throws ProceduralException;
    void consultIncorrectVotingOption() throws ProceduralException, InvalidDocumentIdentificationTypeException, NifIsNullException,
            PassportBiometricReadingException, NifNotValidException, NotValidPassportException, ExplicitConsetNotAprovedException,
            HumanBiometricScanningException, BiometricVerificationFailedException, NotEnabledException, ConnectException,
            PasswordIsNullException, InvalidAccountException, InvalidDNIDocumException;
    void wrongInputVotingOption() throws ProceduralException, InvalidDocumentIdentificationTypeException, ExplicitConsetNotAprovedException,
            NifIsNullException, PassportBiometricReadingException, NifNotValidException, NotValidPassportException, HumanBiometricScanningException,
            BiometricVerificationFailedException, NotEnabledException, ConnectException, InvalidVotingOptionException, PasswordIsNullException,
            InvalidAccountException, InvalidDNIDocumException;
    void electoralOrganismConexionErrorinCanVote() throws ProceduralException, InvalidDocumentIdentificationTypeException,
            ExplicitConsetNotAprovedException, NifIsNullException, PassportBiometricReadingException, NifNotValidException,
            NotValidPassportException, HumanBiometricScanningException, PasswordIsNullException, InvalidAccountException,
            InvalidDNIDocumException, NotEnabledException, ConnectException;
    void electoralOrganismConexionErrorInDisableVoter() throws ProceduralException, InvalidDocumentIdentificationTypeException,
            ExplicitConsetNotAprovedException, NifIsNullException, PassportBiometricReadingException, NifNotValidException,
            NotValidPassportException, HumanBiometricScanningException, BiometricVerificationFailedException, NotEnabledException,
            ConnectException, InvalidVotingOptionException, PasswordIsNullException, InvalidAccountException, InvalidDNIDocumException;
    void userHasVotedCantVoteAgain() throws ProceduralException, InvalidDocumentIdentificationTypeException, ExplicitConsetNotAprovedException,
            NifIsNullException, PassportBiometricReadingException, NifNotValidException, NotValidPassportException, HumanBiometricScanningException,
            BiometricVerificationFailedException, NotEnabledException, ConnectException, InvalidVotingOptionException, InvalidConfirmOptionInput,
            PasswordIsNullException, InvalidAccountException, InvalidDNIDocumException;


}

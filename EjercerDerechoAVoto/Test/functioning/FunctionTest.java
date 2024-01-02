package functioning;

import exceptions.*;
import exceptions.biometricaldataperipherial.BiometricVerificationFailedException;
import exceptions.biometricaldataperipherial.HumanBiometricScanningException;
import exceptions.biometricaldataperipherial.PassportBiometricReadingException;

import java.net.ConnectException;

public interface FunctionTest {

    void initialize() throws NifIsNullException, NifNotValidException, PasswordIsWrongException;

    void setIncorrectDocumentOption() throws ProceduralException;
    void consultIncorrectVotingOption() throws ProceduralException, InvalidDocumentIdentificationTypeException, NifIsNullException,
            PassportBiometricReadingException, NifNotValidException, NotValidPassportException, ExplicitConsetNotAprovedException,
            HumanBiometricScanningException, BiometricVerificationFailedException, NotEnabledException, ConnectException,
            PasswordIsWrongException, InvalidAccountException, InvalidDNIDocumException;
    void wrongInputVotingOption() throws ProceduralException, InvalidDocumentIdentificationTypeException, ExplicitConsetNotAprovedException,
            NifIsNullException, PassportBiometricReadingException, NifNotValidException, NotValidPassportException, HumanBiometricScanningException,
            BiometricVerificationFailedException, NotEnabledException, ConnectException, InvalidVotingOptionException, PasswordIsWrongException,
            InvalidAccountException, InvalidDNIDocumException;
    void electoralOrganismConexionErrorinCanVote() throws ProceduralException, InvalidDocumentIdentificationTypeException,
            ExplicitConsetNotAprovedException, NifIsNullException, PassportBiometricReadingException, NifNotValidException,
            NotValidPassportException, HumanBiometricScanningException, PasswordIsWrongException, InvalidAccountException,
            InvalidDNIDocumException, NotEnabledException, ConnectException;
    void electoralOrganismConexionErrorInDisableVoter() throws ProceduralException, InvalidDocumentIdentificationTypeException,
            ExplicitConsetNotAprovedException, NifIsNullException, PassportBiometricReadingException, NifNotValidException,
            NotValidPassportException, HumanBiometricScanningException, BiometricVerificationFailedException, NotEnabledException,
            ConnectException, InvalidVotingOptionException, PasswordIsWrongException, InvalidAccountException, InvalidDNIDocumException;
    void userHasVotedCantVoteAgain() throws ProceduralException, InvalidDocumentIdentificationTypeException, ExplicitConsetNotAprovedException,
            NifIsNullException, PassportBiometricReadingException, NifNotValidException, NotValidPassportException, HumanBiometricScanningException,
            BiometricVerificationFailedException, NotEnabledException, ConnectException, InvalidVotingOptionException, InvalidConfirmOptionInput,
            PasswordIsWrongException, InvalidAccountException, InvalidDNIDocumException;


}

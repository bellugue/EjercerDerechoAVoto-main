package procedure.manual;

import exceptions.*;

import java.net.ConnectException;

public interface ProcedureTests {
    void initialize() throws NifIsNullException, NifNotValidException, PasswordIsNullException;

    void initVotingTest() throws ProceduralException, InvalidDocumentIdentificationTypeException;

    void setDocumentTest() throws InvalidDocumentIdentificationTypeException, ProceduralException;

    void enterAccountTest() throws ProceduralException, PasswordIsNullException, InvalidAccountException,
            InvalidDocumentIdentificationTypeException;

    void confirmIdetifTest() throws ProceduralException, InvalidDNIDocumException, PasswordIsNullException,
            InvalidDocumentIdentificationTypeException, InvalidAccountException;

    void enterNifTest() throws ProceduralException, NifIsNullException, NifNotValidException, NotEnabledException,
            ConnectException, PasswordIsNullException, InvalidDocumentIdentificationTypeException, InvalidAccountException,
            InvalidDNIDocumException;

    void initOptionNavegationTest() throws ProceduralException, NifIsNullException, NifNotValidException, PasswordIsNullException,
            InvalidDocumentIdentificationTypeException, InvalidAccountException, InvalidDNIDocumException, NotEnabledException,
            ConnectException;

    void consultVotingOption() throws ProceduralException, NifIsNullException, NifNotValidException, PasswordIsNullException,
            InvalidDocumentIdentificationTypeException, InvalidAccountException, InvalidDNIDocumException, NotEnabledException,
            ConnectException, InvalidVotingOptionException;

    void vote() throws ProceduralException, NifIsNullException, NifNotValidException, PasswordIsNullException,
            InvalidDocumentIdentificationTypeException, InvalidAccountException, InvalidDNIDocumException, NotEnabledException,
            ConnectException, InvalidVotingOptionException;

    void confirmVotingOption() throws ProceduralException, NifIsNullException, NifNotValidException, PasswordIsNullException,
            InvalidDocumentIdentificationTypeException, InvalidAccountException, InvalidDNIDocumException, NotEnabledException,
            ConnectException, InvalidVotingOptionException, InvalidConfirmOptionInput;
    }
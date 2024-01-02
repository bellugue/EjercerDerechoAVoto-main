package procedure.manual;

import exceptions.*;

import java.net.ConnectException;

public interface ProcedureTests {
    void initialize() throws NifIsNullException, NifNotValidException, PasswordIsWrongException;

    void initVotingTest() throws ProceduralException, InvalidDocumentIdentificationTypeException;

    void setDocumentTest() throws InvalidDocumentIdentificationTypeException, ProceduralException;

    void enterAccountTest() throws ProceduralException, PasswordIsWrongException, InvalidAccountException,
            InvalidDocumentIdentificationTypeException;

    void confirmIdetifTest() throws ProceduralException, InvalidDNIDocumException, PasswordIsWrongException,
            InvalidDocumentIdentificationTypeException, InvalidAccountException;

    void enterNifTest() throws ProceduralException, NifIsNullException, NifNotValidException, NotEnabledException,
            ConnectException, PasswordIsWrongException, InvalidDocumentIdentificationTypeException, InvalidAccountException,
            InvalidDNIDocumException;

    void initOptionNavegationTest() throws ProceduralException, NifIsNullException, NifNotValidException, PasswordIsWrongException,
            InvalidDocumentIdentificationTypeException, InvalidAccountException, InvalidDNIDocumException, NotEnabledException,
            ConnectException;

    void consultVotingOption() throws ProceduralException, NifIsNullException, NifNotValidException, PasswordIsWrongException,
            InvalidDocumentIdentificationTypeException, InvalidAccountException, InvalidDNIDocumException, NotEnabledException,
            ConnectException, InvalidVotingOptionException;

    void vote() throws ProceduralException, NifIsNullException, NifNotValidException, PasswordIsWrongException,
            InvalidDocumentIdentificationTypeException, InvalidAccountException, InvalidDNIDocumException, NotEnabledException,
            ConnectException, InvalidVotingOptionException;

    void confirmVotingOption() throws ProceduralException, NifIsNullException, NifNotValidException, PasswordIsWrongException,
            InvalidDocumentIdentificationTypeException, InvalidAccountException, InvalidDNIDocumException, NotEnabledException,
            ConnectException, InvalidVotingOptionException, InvalidConfirmOptionInput;
    }
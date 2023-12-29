package data;

import exceptions.PasswordIsNullException;

final public class Password {
    private final String Password;

    public Password(String password) throws PasswordIsNullException {
        if (passwordIsValid(password))
            this.Password = password;
        else
            throw new PasswordIsNullException("Password is null");
    }

    private boolean passwordIsValid(String password){
        return password != null || password != "";
    }
}

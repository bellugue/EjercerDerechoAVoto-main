package data;

import exceptions.PasswordIsWrongException;

final public class Password {
    private final String Password;

    public Password(String password) throws PasswordIsWrongException {
        if (password == null) {
            throw new PasswordIsWrongException("La password no pot ser null.");
        } else if (password.length() < 4) {
            throw new PasswordIsWrongException("Password ha tenir llargada >= 4.");
        } else if (!passwordHasDigit(password)) {
            throw new PasswordIsWrongException("Password ha de tenir almenys un digit.");
        } else if (!passwordHasChar(password)) {
            throw new PasswordIsWrongException("Password ha de tenir almenys un caràcter.");
        }
        this.Password = password;
    }

    private boolean passwordHasDigit(String pass) {
        char[] passwd = pass.toCharArray();
        for (char c : passwd) {
            if (Character.isDigit(c))
                return true;
        }
        return false;
    }

    private boolean passwordHasChar(String pass) {
        char[] passwd = pass.toCharArray();
        for (char c : passwd) {
            if (Character.isAlphabetic(c))
                return true;
        }
        return false;
    }

    public String getPassword(){
        return this.Password;
    }
}

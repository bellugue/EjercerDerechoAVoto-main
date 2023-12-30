package services;

import data.Password;
import exceptions.InvalidAccountException;
import exceptions.PasswordIsNullException;

import java.util.HashMap;

public class LocalServiceImpl implements LocalService{
    private HashMap<String, Password> validAccounts;

    public LocalServiceImpl() throws PasswordIsNullException {
        validAccounts = new HashMap<>();
        Password password1 = new Password("password1");
        validAccounts.put("user1", password1);
        Password password2 = new Password("password2");
        validAccounts.put("user2", password2);
    }
    @Override
    public void verifyAccount(String login, Password pssw) throws InvalidAccountException {
        for(String loginValue : validAccounts.keySet()){
            if(loginValue.equals(login)){
                Password password = validAccounts.get(login);
                if(!password.getPassword().equals(pssw.getPassword())){
                    throw new InvalidAccountException("The password is not right");
                }
                else{
                    return;
                }
            }
        }
        throw new InvalidAccountException("The user is not right");
    }
}
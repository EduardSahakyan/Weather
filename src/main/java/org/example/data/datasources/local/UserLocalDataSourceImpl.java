package org.example.data.datasources.local;

import org.example.common.exceptions.IncorrectPasswordException;
import org.example.common.exceptions.UserExistException;
import org.example.common.exceptions.UserNotFoundException;

import java.util.Objects;
import java.util.prefs.Preferences;

public class UserLocalDataSourceImpl implements UserLocalDataSource{

    Preferences preferences = Preferences.userRoot();
    @Override
    public void signUp(String login, String password) throws UserExistException {
        String pas = preferences.get(login, "0");
        if (pas.equals("0")) {
            preferences.put(login, password);
        } else {
            throw new UserExistException("User already exists");
        }
    }

    @Override
    public void logIn(String login, String password) throws IncorrectPasswordException, UserNotFoundException {
        String pas = preferences.get(login, "0");
        if (pas.equals("0")){
            throw new UserNotFoundException("this user doesn't exist");
        } else if (!(pas.equals(password))) {
            throw new IncorrectPasswordException("Incorrect password");
        } else {

        }
    }
}

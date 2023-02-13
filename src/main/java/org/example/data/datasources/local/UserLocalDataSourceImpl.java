package org.example.data.datasources.local;

import org.example.common.exceptions.UserExistException;

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
}

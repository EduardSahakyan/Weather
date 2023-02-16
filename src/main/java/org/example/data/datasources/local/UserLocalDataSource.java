package org.example.data.datasources.local;

import org.example.common.exceptions.IncorrectPasswordException;
import org.example.common.exceptions.UserExistException;
import org.example.common.exceptions.UserNotFoundException;

public interface UserLocalDataSource {
    void signUp(String login, String password) throws UserExistException;
    void logIn(String login, String password) throws IncorrectPasswordException, UserNotFoundException;
}

package org.example.data.datasources.local;

import org.example.common.exceptions.UserExistException;

public interface UserLocalDataSource {
    void signUp(String login, String password) throws UserExistException;
}

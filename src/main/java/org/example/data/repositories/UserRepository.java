package org.example.data.repositories;

import org.example.common.exceptions.UserExistException;
import org.example.data.datasources.local.UserLocalDataSource;
import org.example.domain.gateways.UserGateway;

public class UserRepository implements UserGateway {

    private final UserLocalDataSource userLocalDataSource;

    public UserRepository(UserLocalDataSource userLocalDataSource) {
        this.userLocalDataSource = userLocalDataSource;
    }

    @Override
    public void signUp(String login, String password) throws UserExistException {
        userLocalDataSource.signUp(login, password);
    }
}

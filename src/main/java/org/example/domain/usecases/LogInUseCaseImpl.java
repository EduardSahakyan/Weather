package org.example.domain.usecases;

import org.example.common.exceptions.IncorrectPasswordException;
import org.example.common.exceptions.UserNotFoundException;
import org.example.domain.gateways.UserGateway;

public class LogInUseCaseImpl implements LogInUseCase {

    private final UserGateway userGateway;

    public LogInUseCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public void execute(String login, String password) throws IncorrectPasswordException, UserNotFoundException {
        userGateway.logIn(login, password);
    }
}

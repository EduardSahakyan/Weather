package org.example.domain.usecases;

import org.example.common.exceptions.UserExistException;
import org.example.domain.gateways.UserGateway;

public class SignUpUseCaseImpl implements SignUpUseCase{

    private final UserGateway userGateway;

    public SignUpUseCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public void execute(String login, String password) throws UserExistException {
        userGateway.signUp(login, password);
    }
}

package org.example.domain.gateways;

import org.example.common.exceptions.UserExistException;

public interface UserGateway {
    void signUp(String login, String password) throws UserExistException;
}

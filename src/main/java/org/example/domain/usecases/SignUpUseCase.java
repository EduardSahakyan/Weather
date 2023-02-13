package org.example.domain.usecases;

import org.example.common.exceptions.UserExistException;

public interface SignUpUseCase {
    void execute(String login, String password) throws UserExistException;
}

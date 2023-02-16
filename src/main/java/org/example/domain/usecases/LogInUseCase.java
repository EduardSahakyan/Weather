package org.example.domain.usecases;

import org.example.common.exceptions.IncorrectPasswordException;
import org.example.common.exceptions.UserExistException;
import org.example.common.exceptions.UserNotFoundException;

public interface LogInUseCase {

    void execute(String login, String password) throws IncorrectPasswordException, UserNotFoundException;

}

package org.example.presentation.loginscreen;

import org.example.common.exceptions.IncorrectPasswordException;
import org.example.common.exceptions.UserNotFoundException;
import org.example.domain.usecases.LogInUseCase;
import org.example.presentation.common.BaseViewModel;

import java.util.concurrent.SubmissionPublisher;

public class LogInViewModel extends BaseViewModel {

    private final LogInUseCase logInUseCase;

    public LogInViewModel(LogInUseCase logInUseCase) {
        this.logInUseCase = logInUseCase;
    }

    private final SubmissionPublisher<Boolean> successful = new SubmissionPublisher<>();

    public void logIn(String login, String password) {
        try {
            logInUseCase.execute(login, password);
            successful.submit(true);
        } catch (UserNotFoundException | IncorrectPasswordException e) {
            successful.submit(false);
        }
    }

    public SubmissionPublisher<Boolean> getSuccessful() {
        return successful;
    }

}

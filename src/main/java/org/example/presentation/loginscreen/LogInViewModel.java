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

    private final SubmissionPublisher<Integer> successful = new SubmissionPublisher<>();

    public void logIn(String login, String password) {
        try {
            logInUseCase.execute(login, password);
            successful.submit(0);
        } catch (UserNotFoundException e) {
            successful.submit(1);
        } catch (IncorrectPasswordException e) {
            successful.submit(2);
        }
    }

    public SubmissionPublisher<Integer> getSuccessful() {
        return successful;
    }

}

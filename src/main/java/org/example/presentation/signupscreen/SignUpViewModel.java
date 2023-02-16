package org.example.presentation.signupscreen;

import org.example.common.exceptions.UserExistException;
import org.example.domain.usecases.SignUpUseCase;
import org.example.presentation.common.BaseViewModel;
import java.util.concurrent.SubmissionPublisher;

public class SignUpViewModel extends BaseViewModel {

    private final SignUpUseCase signUpUseCase;


    private final SubmissionPublisher<Boolean> isSuccess = new SubmissionPublisher<>();

    public SignUpViewModel(SignUpUseCase signUpUseCase) {
        this.signUpUseCase = signUpUseCase;
    }

    public void signUp(String login, String password) {
        try {
            signUpUseCase.execute(login, password);
            isSuccess.submit(true);
        } catch (UserExistException e) {
            isSuccess.submit(false);;
        }
    }

    public SubmissionPublisher<Boolean> getIsSuccess() {
        return isSuccess;
    }
}

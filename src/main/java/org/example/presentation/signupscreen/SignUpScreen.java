package org.example.presentation.signupscreen;

import org.example.common.di.AppComponent;
import org.example.presentation.common.BaseScreen;
import org.example.presentation.common.LiveData;
import org.example.presentation.mainscreen.MainScreen;

import java.util.Scanner;

public class SignUpScreen extends BaseScreen {

    private final SignUpViewModel viewModel = AppComponent.getInstance().getSignUpViewModel();

    @Override
    public void onStart() {
        observers();
        showSignUpMenu();
    }

    @Override
    public void onFinish() {

    }

    private void showSignUpMenu() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter login");
            String login = scanner.nextLine();
            System.out.println("Please enter password");
            String password = scanner.nextLine();
            viewModel.signUp(login, password);
        }
    }

    private void observers() {
        viewModel.getIsSuccess().subscribe(new LiveData<Boolean>() {
            @Override
            public void onNext(Boolean isSuccess) {
                super.onNext(isSuccess);
                if (isSuccess) {
                    navigateTo(new MainScreen());
                } else {
                    System.out.println("Login is already used");
                }
            }
        });
    }
}

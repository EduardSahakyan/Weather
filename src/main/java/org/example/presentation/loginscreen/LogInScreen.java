package org.example.presentation.loginscreen;

import org.example.common.di.AppComponent;
import org.example.presentation.common.BaseScreen;
import org.example.presentation.common.LiveData;
import org.example.presentation.mainscreen.MainScreen;
import org.example.presentation.signupscreen.SignUpViewModel;

import java.util.Scanner;

public class LogInScreen extends BaseScreen {

    private final LogInViewModel viewModel = AppComponent.getInstance().getLogInViewModel();

    @Override
    public void onStart() {
        observers();
        showLogInMenu();
    }

    @Override
    public void onFinish() {

    }
    private void showLogInMenu() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter login");
            String login = scanner.nextLine();
            System.out.println("Please enter password");
            String password = scanner.nextLine();
            viewModel.logIn(login, password);
        }
    }
    private void observers() {
        viewModel.getSuccessful().subscribe(new LiveData<Boolean>() {
            @Override
            public void onNext(Boolean successful) {
                super.onNext(successful);
                if (successful) {
                    navigateTo(new MainScreen());
                } else {
                    System.out.println("User with this login don't exist");
                }
            }
        });
    }
}

package org.example.presentation.loginscreen;

import org.example.common.di.AppComponent;
import org.example.common.exceptions.UserNotFoundException;
import org.example.presentation.common.BaseScreen;
import org.example.presentation.common.LiveData;
import org.example.presentation.mainscreen.MainScreen;

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
        viewModel.getSuccessful().subscribe(new LiveData<Integer>() {
            @Override
            public void onNext(Integer successful) {
                super.onNext(successful);
                if (successful == 0) {
                    navigateTo(new MainScreen());
                } else if (successful == 1) {
                    System.out.println("This user doesn't exist");
                } else if (successful == 2){
                    System.out.println("Incorrect password");
                }
            }
        });
    }
}

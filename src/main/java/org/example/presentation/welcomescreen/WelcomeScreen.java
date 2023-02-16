package org.example.presentation.welcomescreen;

import org.example.presentation.common.BaseScreen;
import org.example.presentation.loginscreen.LogInScreen;
import org.example.presentation.signupscreen.SignUpScreen;

import java.util.Scanner;

public class WelcomeScreen extends BaseScreen {

    @Override
    public void onStart() {
        System.out.println("Welcome to app");
        System.out.println("1 - Register");
        System.out.println("2 - Login");
        System.out.println("q - Exit");
        Scanner scn = new Scanner(System.in);
        String key = scn.nextLine();
        switch (key) {
            case "1":
                navigateTo(new SignUpScreen());
                break;
            case "2":
                navigateTo(new LogInScreen());
                break;
            case "q":
                onFinish();
                break;
            default:
                System.out.println("Invalid key");
                onFinish();
                break;
        }
    }

    @Override
    public void onFinish() {

    }
}

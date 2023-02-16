package org.example.presentation.navigation;

import org.example.presentation.common.BaseScreen;
import org.example.presentation.loginscreen.LogInScreen;
import org.example.presentation.mainscreen.MainScreen;
import org.example.presentation.signupscreen.SignUpScreen;

public interface Navigator {

    BaseScreen startDestination = new LogInScreen();

    void navigateTo(BaseScreen screen);

}

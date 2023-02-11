package org.example.presentation.navigation;

import org.example.presentation.common.BaseScreen;
import org.example.presentation.mainscreen.MainScreen;

public interface Navigator {

    BaseScreen startDestination = new MainScreen();

    void navigateTo(BaseScreen screen);

}

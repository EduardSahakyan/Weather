package org.example.presentation.common;

import org.example.presentation.navigation.Navigator;

public abstract class BaseScreen implements Navigator {

    public abstract void onStart();

    @Override
    public void navigateTo(BaseScreen screen) {
        screen.onStart();
    }
}

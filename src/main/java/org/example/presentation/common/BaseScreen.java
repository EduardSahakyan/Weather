package org.example.presentation.common;

import org.example.presentation.navigation.Navigator;

public abstract class BaseScreen implements Navigator {

    public abstract void onStart();

    public abstract void onFinish();

    @Override
    public void navigateTo(BaseScreen screen) {
        onFinish();
        screen.onStart();
    }
}

package org.example.presentation.common;

import io.reactivex.rxjava3.disposables.CompositeDisposable;

public abstract class BaseViewModel {

    protected CompositeDisposable disposable = null;

    public void onFinish() {
        if (disposable != null)
            disposable.clear();
    }

}

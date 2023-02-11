package org.example.presentation.common;

import java.util.concurrent.Flow;

public abstract class LiveData<T> implements Flow.Subscriber<T> {
    private Flow.Subscription subscription;
    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        this.subscription.request(1);
    }
    @Override
    public void onNext(T item) {
        subscription.request(1);
    }
    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }
    @Override
    public void onComplete() {
        System.out.println("Done");
    }
}
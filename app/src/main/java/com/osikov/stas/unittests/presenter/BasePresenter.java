package com.osikov.stas.unittests.presenter;

public class BasePresenter<V> {

    private V view;

    void attachView(V view) {
        this.view = view;
    }

    V getView() {
        return view;
    }

    void detachView() {
        view = null;
    }
}

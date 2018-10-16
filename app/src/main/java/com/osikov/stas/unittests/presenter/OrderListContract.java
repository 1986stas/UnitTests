package com.osikov.stas.unittests.presenter;

import java.util.List;

public class OrderListContract {
    interface View{
        void showOrders(List<Order> orders);

        void showError(String message);

        void showProgress();

        void hideProgress();
    }

    interface Presenter {
        void refresh();
    }
}

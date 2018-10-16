package com.osikov.stas.unittests.presenter;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

public class OrderListPresenter extends BasePresenter<OrderListContract.View> implements OrderListContract.Presenter {

    private final OrderRepository orderRepository;
    private final Scheduler workScheduler, resultScheduler;

    public OrderListPresenter(OrderRepository orderRepository, Scheduler workScheduler, Scheduler resultScheduler) {
        this.orderRepository = orderRepository;
        this.workScheduler = workScheduler;
        this.resultScheduler = resultScheduler;
    }

    @Override
    public void refresh() {
        if (getView() == null) return;
        getView().showProgress();
        orderRepository.getOrders()
                .subscribeOn(workScheduler)
                .observeOn(resultScheduler)
                .subscribe(new DisposableObserver<List<Order>>() {
                    @Override
                    public void onNext(@NonNull List<Order> orders) {
                        if (getView() == null) return;
                        getView().hideProgress();
                        getView().showOrders(orders);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        if (getView() == null) return;
                        getView().hideProgress();
                        getView().showError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
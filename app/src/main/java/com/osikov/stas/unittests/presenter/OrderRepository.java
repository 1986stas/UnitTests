package com.osikov.stas.unittests.presenter;

import java.util.List;

import io.reactivex.Observable;

public interface OrderRepository {
    Observable<List<Order>> getOrders();

}

package com.osikov.stas.unittests.presenter;

import android.support.annotation.Nullable;

import java.io.Serializable;
import java.util.Objects;

public class Order implements Serializable {

    private long id;
    private float amount;
    private String description;
    private String name;



    public Order(long id, float amount, String description) {
        this.id = id;
        this.amount = amount;
        this.description = description;
    }

    public Order(){}

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if(obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Order order = (Order) obj;
        return order.description.equals(this.description)
                && order.name.equals(this.name) && order.id == this.id;
    }


    @Override
    public String toString() {
        return " " + name + description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

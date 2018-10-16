package com.osikov.stas.unittests.presenter;

public class Order {

    private long id;
    private float amount;
    private String description;

    public Order(long id, float amount, String description) {
        this.id = id;
        this.amount = amount;
        this.description = description;
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

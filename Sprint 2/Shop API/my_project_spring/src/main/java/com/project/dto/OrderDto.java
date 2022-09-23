package com.project.dto;

import com.project.model.Product;
import com.project.model.Transaction;

public class OrderDto {
    private Integer id;
    private int quantity;
    private Transaction transactionOrder;
    private Product product;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Transaction getTransactionOrder() {
        return transactionOrder;
    }

    public void setTransactionOrder(Transaction transactionOrder) {
        this.transactionOrder = transactionOrder;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}



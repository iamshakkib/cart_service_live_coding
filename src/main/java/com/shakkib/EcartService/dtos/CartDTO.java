package com.shakkib.EcartService.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shakkib.EcartService.entities.Item;

import java.util.ArrayList;
import java.util.List;

public class CartDTO {

    @JsonProperty("cart_id")
    private int cartId;

    @JsonProperty("customer_name")
    private String customerName;

    @JsonProperty("cart_items")
    private List<ItemDTO> items;

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }

    public CartDTO() {
        items = new ArrayList<>();
    }
}

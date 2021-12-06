package com.shakkib.EcartService.entities;

import com.shakkib.EcartService.dtos.ItemDTO;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Item{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;

    @Column(nullable = false)
    private String itemName;

    @Column(length = 500)
    private String itemDescription;

    private String category;

    @Column(nullable = false)
    private double cost;

    @Column(nullable = false)
    private LocalDateTime mfgdate;

    /*
    For the relationship
     */
    @ManyToOne
    @JoinColumn(name = "cart_id") //used to customize foreign key column
    private Cart cart;

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public LocalDateTime getMfgdate() {
        return mfgdate;
    }

    public void setMfgdate(LocalDateTime mfgdate) {
        this.mfgdate = mfgdate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }
}

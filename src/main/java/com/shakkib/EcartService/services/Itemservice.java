package com.shakkib.EcartService.services;

import com.shakkib.EcartService.entities.Cart;
import com.shakkib.EcartService.entities.Item;
import com.shakkib.EcartService.exceptions.CartNotFoundException;
import com.shakkib.EcartService.exceptions.CustomerNameNotFoundException;
import com.shakkib.EcartService.exceptions.ItemNotFoundException;

import java.util.List;

/*
again we are making service layer which means it contains the
buisness logic we have
we will declare and implemet all the methods defining here
 */
public interface Itemservice {

    public Item addItemToCart(Item item, int cartId) throws CartNotFoundException;

    public List<Item> getItemsFromTheCart(int cartId) throws CartNotFoundException;

    public Cart getCartOfTheItem(int itemId) throws ItemNotFoundException;

    public Cart findByCustomerName(String customerName) throws CustomerNameNotFoundException;
}

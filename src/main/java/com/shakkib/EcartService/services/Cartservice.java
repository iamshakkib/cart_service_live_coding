package com.shakkib.EcartService.services;
/*
we will declare all methods that we want to function
 */

import com.shakkib.EcartService.entities.Cart;
import com.shakkib.EcartService.exceptions.CartNotFoundException;
import com.shakkib.EcartService.exceptions.CustomerNameNotFoundException;

public interface Cartservice {
    /*
    this method will add a new cart , and reflect in db
     */
    public Cart createCart(Cart cart);

    public boolean deleteCart(int cartId);

    public Cart findCartbyId(int cartId) throws CartNotFoundException;

    public Cart findByCustomerName(String customerName) throws CustomerNameNotFoundException;
}

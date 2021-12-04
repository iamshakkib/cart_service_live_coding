package com.shakkib.EcartService.services.impl;

import com.shakkib.EcartService.daos.Cartdao;
import com.shakkib.EcartService.entities.Cart;
import com.shakkib.EcartService.exceptions.CartNotFoundException;
import com.shakkib.EcartService.exceptions.CustomerNameNotFoundException;
import com.shakkib.EcartService.services.Cartservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
its always a good practice to code for interface so first i did created
interfaces and then their corresponding implementing classes
and also ITS CORRESPONDING TEST CASES also written in test folder
 */

@Service
public class CartServiceImpl implements Cartservice {

    @Autowired
    private Cartdao cartDao;

    @Override
    public Cart createCart(Cart cart) {
        return cartDao.save(cart);
    }

    @Override
    public boolean deleteCart(int cartId) {
        cartDao.deleteById(cartId);
        return true;
    }

    @Override
    public Cart findCartbyId(int cartId) throws CartNotFoundException {
        return cartDao.findById(cartId).orElseThrow(()->new CartNotFoundException());
    }

    @Override
    public Cart findByCustomerName(String customerName) throws CustomerNameNotFoundException {
        Cart cart = cartDao.findByCustomerName(customerName);
        if(cart==null){
            throw new CustomerNameNotFoundException();
        }
        return cart;
    }
}

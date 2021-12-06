package com.shakkib.EcartService.services;

import com.shakkib.EcartService.daos.Cartdao;
import com.shakkib.EcartService.entities.Cart;
import com.shakkib.EcartService.exceptions.CartNotFoundException;
import com.shakkib.EcartService.exceptions.CustomerNameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements Cartservice{

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

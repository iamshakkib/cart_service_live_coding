package com.shakkib.cartService.services.impl;

import com.shakkib.cartService.daos.CartDao;
import com.shakkib.cartService.entities.Cart;
import com.shakkib.cartService.exceptions.CartNotFoundException;
import com.shakkib.cartService.exceptions.CustomerNameNotFoundException;
import com.shakkib.cartService.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CartServiceImpl implements CartService {

  @Autowired
  private CartDao cartDao ;

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
  public Cart findByCartId(int cartId) throws CartNotFoundException {
    return cartDao.findById(cartId).orElseThrow(() -> new CartNotFoundException());
  }

  @Override
  public Cart findByCustomerName(String customerName) throws CustomerNameNotFoundException {

    Cart cart = cartDao.findByCustomerName(customerName);
    if(cart== null){
      throw new CustomerNameNotFoundException();
    }
    return cart ;
  }
}

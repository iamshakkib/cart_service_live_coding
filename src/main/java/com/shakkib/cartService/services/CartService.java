package com.shakkib.cartService.services;

import com.shakkib.cartService.entities.Cart;
import com.shakkib.cartService.exceptions.CartNotFoundException;
import com.shakkib.cartService.exceptions.CustomerNameNotFoundException;



/**
 * We will define all the methods, that we want CartService to
 * support
 */
public interface CartService {

  /**
   * This method will add a new Cart, and persist in the DB
   * @param cart
   * @return
   */
  public Cart createCart(Cart cart);

  public boolean deleteCart(int cartId);

  public Cart findByCartId(int cartId) throws CartNotFoundException;

  public Cart findByCustomerName(String customerName) throws CustomerNameNotFoundException;
}

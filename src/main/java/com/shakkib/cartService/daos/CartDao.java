package com.shakkib.cartService.daos;

import com.shakkib.cartService.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * This will help us do the crud operation with the database
 */
public interface CartDao extends JpaRepository<Cart, Integer> {

  public Cart findByCustomerName(String name);
}

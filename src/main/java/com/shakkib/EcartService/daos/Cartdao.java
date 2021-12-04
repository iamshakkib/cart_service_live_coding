package com.shakkib.EcartService.daos;

import com.shakkib.EcartService.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

/*
This will be used to do crud operations with the databases
 */

public interface Cartdao extends JpaRepository<Cart,Integer> {
    public Cart findByCustomerName(String customerName);
}

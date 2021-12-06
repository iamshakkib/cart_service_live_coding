package com.shakkib.EcartService.daos;

import com.shakkib.EcartService.entities.Cart;
import com.shakkib.EcartService.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

/*
this will used to do the crud opoeration with the database MySQL
 */

public interface Itemdao extends JpaRepository<Item,Integer> {
    public List<Item> findItemsByCart(Cart cart);
}

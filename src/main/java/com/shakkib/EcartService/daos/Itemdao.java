package com.shakkib.EcartService.daos;

import com.shakkib.EcartService.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

/*
this will used to do the crud opoeration with the database MySQL
 */
public interface Itemdao extends JpaRepository<Item,Integer> {
}

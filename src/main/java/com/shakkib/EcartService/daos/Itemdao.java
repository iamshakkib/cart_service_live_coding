package com.shakkib.EcartService.daos;

import com.shakkib.EcartService.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Itemdao extends JpaRepository<Item,Integer> {
}

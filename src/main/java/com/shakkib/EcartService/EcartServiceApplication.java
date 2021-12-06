package com.shakkib.EcartService;

import com.shakkib.EcartService.daos.Cartdao;
import com.shakkib.EcartService.daos.Itemdao;
import com.shakkib.EcartService.entities.Cart;
import com.shakkib.EcartService.entities.Item;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalDateTime;

//@SpringBootApplication(scanBasePackages = {"com.shakkib.EcartService.services","com.shakkib.EcartService.services.impl"})
@SpringBootApplication
//@ComponentScan("com.shakkib.EcartService.services")
public class EcartServiceApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(EcartServiceApplication.class, args);

		/*
		Cartdao cartDao = ctx.getBean(Cartdao.class);
		Itemdao itemDao = ctx.getBean(Itemdao.class);
		System.out.println("cart dao"+cartDao);
		System.out.println("Itemdao"+itemDao);
		*/

		/*
		create cart
		 */

		/*
		Cart cart = new Cart();
		cart.setCustomerName("Md Sakib");
		cartDao.save(cart);
		*/
		/*
		create item
		 */
		/*
		Item item = new Item();
		item.setCategory("very important");
		item.setItemDescription("very expensive ipad cheap people cant afford it");
		item.setItemName("Ipad");
		item.setCost(110000);
		item.setMfgdate(LocalDateTime.of(2021,07,2,13,45));
		item.setCart(cart);
		itemDao.save(item);
		*/

	}

}

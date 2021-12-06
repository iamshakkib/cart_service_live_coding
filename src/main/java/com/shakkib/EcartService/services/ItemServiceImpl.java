package com.shakkib.EcartService.services;

import com.shakkib.EcartService.daos.Itemdao;
import com.shakkib.EcartService.entities.Cart;
import com.shakkib.EcartService.entities.Item;
import com.shakkib.EcartService.exceptions.CartNotFoundException;
import com.shakkib.EcartService.exceptions.CustomerNameNotFoundException;
import com.shakkib.EcartService.exceptions.ItemNotFoundException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

//@Service
public class ItemServiceImpl implements ItemService {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(com.shakkib.EcartService.services.ItemServiceImpl.class);

    @Autowired
    private Itemdao itemDao;

    @Autowired
    private Cartservice cartService;

    @Override
    public Item addItemToCart(Item item, int cartId) throws CartNotFoundException {
        LOGGER.info("inside the addItemToCart method");
        //need to fetch the cart based on the cartId
        Cart cart = cartService.findCartbyId(cartId);
        item.setCart(cart);
        LOGGER.info("returning from the method addItemToCart");
        return itemDao.save(item);
    }

    @Override
    public List<Item> getItemsFromTheCart(int cartId) throws CartNotFoundException {
        Cart cart = cartService.findCartbyId(cartId);
        // Lazy initialization
        List<Item> items = itemDao.findItemsByCart(cart);
        return items;
    }

    @Override
    public Cart getCartOfTheItem(int itemId) throws ItemNotFoundException {
        Item item = itemDao.findById(itemId).orElseThrow(() -> new ItemNotFoundException());
        /*
        Item -> Cart : Many to One : Eager Initialization
         */
        Cart cart = item.getCart();

        return cart;
    }

    @Override
    public Cart findByCustomerName(String customerName) throws CustomerNameNotFoundException {
        Cart cart = cartService.findByCustomerName(customerName);
        return cart;
    }



}

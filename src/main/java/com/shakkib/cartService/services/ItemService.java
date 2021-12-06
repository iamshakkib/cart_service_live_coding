package com.shakkib.cartService.services;

import com.shakkib.cartService.entities.Cart;
import com.shakkib.cartService.entities.Item;
import com.shakkib.cartService.exceptions.CartNotFoundException;
import com.shakkib.cartService.exceptions.ItemNotFoundException;
import java.util.List;


public interface ItemService {

  public Item addItemToCart(Item item, int cartId) throws CartNotFoundException;

  public List<Item> getItemsFromTheCart(int cartId) throws CartNotFoundException;

  public Cart getCartOfTheItem(int itemId) throws ItemNotFoundException;
}

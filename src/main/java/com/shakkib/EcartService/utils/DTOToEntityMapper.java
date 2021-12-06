package com.shakkib.EcartService.utils;

import com.shakkib.EcartService.dtos.CartDTO;
import com.shakkib.EcartService.dtos.ItemDTO;
import com.shakkib.EcartService.entities.Cart;
import com.shakkib.EcartService.entities.Item;

public class DTOToEntityMapper {

    public static Cart convertCartDTOToCartEntity(CartDTO cartDTO){

        Cart cart = new Cart();
        cart.setCartId(cartDTO.getCartId());
        cart.setCustomerName(cartDTO.getCustomerName());

        for(ItemDTO itemDTO : cartDTO.getItems()){
            cart.getItems().add(convertItemDTOToItemEntity(itemDTO));
        }
        return cart;
    }

    public static Item convertItemDTOToItemEntity(ItemDTO itemDTO){
        Item item = new Item();

        item.setItemName(itemDTO.getItemName());
        item.setItemDescription(itemDTO.getItemDescription());
        item.setCost(itemDTO.getCost());
        item.setCategory(itemDTO.getCategory());
        item.setMfgdate(itemDTO.getMfgDate());
        item.setItemId(itemDTO.getItemId());

        return item;
    }

    public static CartDTO convertCartEntityToCartDTO(Cart cart){
        CartDTO cartDTO = new CartDTO();
        cartDTO.setCartId(cartDTO.getCartId());
        cartDTO.setCustomerName(cartDTO.getCustomerName());

        for(Item item : cart.getItems()){
            cartDTO.getItems().add(convertItemEntityToItemDTO(item));
        }
        return cartDTO;
    }

    public static ItemDTO convertItemEntityToItemDTO(Item item){
        ItemDTO itemDTO = new ItemDTO();

        itemDTO.setItemName(itemDTO.getItemName());
        itemDTO.setItemDescription(itemDTO.getItemDescription());
        itemDTO.setCost(itemDTO.getCost());
        itemDTO.setCategory(itemDTO.getCategory());
        itemDTO.setMfgDate(itemDTO.getMfgDate());
        itemDTO.setItemId(itemDTO.getItemId());

        return itemDTO;
    }
}

package com.shakkib.EcartService.controllers;

import com.shakkib.EcartService.dtos.CartDTO;
import com.shakkib.EcartService.dtos.ItemDTO;
import com.shakkib.EcartService.entities.Cart;
import com.shakkib.EcartService.entities.Item;
import com.shakkib.EcartService.exceptions.CartNotFoundException;
import com.shakkib.EcartService.exceptions.ItemNotFoundException;
import com.shakkib.EcartService.services.Cartservice;
import com.shakkib.EcartService.services.ItemService;
import com.shakkib.EcartService.utils.DTOToEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



/*
127.0.01:8080/cartService/v1/carts
 */
@RestController
@RequestMapping("carts")
public class CartController {

    @Autowired
    public Cartservice cartService;

    //@Autowired
    //public ItemService itemService;

    @GetMapping
    public ResponseEntity helloStudents(){
        return new ResponseEntity("Hello Students", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createCart(@RequestBody CartDTO cartDTO){
        //Create and save Cart in the
        Cart cart = cartService.createCart(DTOToEntityMapper.convertCartDTOToCartEntity(cartDTO));
        CartDTO cartResponse = DTOToEntityMapper.convertCartEntityToCartDTO(cart);
        return new ResponseEntity(cartResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{cart_id}")
    public ResponseEntity getCart(@PathVariable("cart_id")int cartId) throws CartNotFoundException {
        Cart cart = cartService.findCartbyId(cartId);
        CartDTO cartResponse = DTOToEntityMapper.convertCartEntityToCartDTO(cart);
        return new ResponseEntity(cartResponse, HttpStatus.OK);
    }

    /*@PostMapping("/{cart_id}/items")
    public ResponseEntity addItemToCart(@RequestBody ItemDTO itemDTO, @PathVariable("cart_id") int cartId) throws CartNotFoundException, ItemNotFoundException {
        Item item = itemService.addItemToCart(DTOToEntityMapper.convertItemDTOToItemEntity(itemDTO),cartId);

        Cart cart = itemService.getCartOfTheItem(item.getItemId());
        CartDTO cartDTO = DTOToEntityMapper.convertCartEntityToCartDTO(cart);
        return new ResponseEntity(cartDTO, HttpStatus.CREATED);
    }*/


}

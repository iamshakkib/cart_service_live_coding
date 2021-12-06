package com.shakkib.EcartService.serviceimpl;

import com.shakkib.EcartService.daos.Cartdao;
import com.shakkib.EcartService.entities.Cart;
import com.shakkib.EcartService.exceptions.CartNotFoundException;
import com.shakkib.EcartService.exceptions.CustomerNameNotFoundException;
import com.shakkib.EcartService.services.CartServiceImpl;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assert.*;

@SpringBootTest
public class CartServiceImplTest {

    @Mock
    Cartdao cartDaoMock;

    @InjectMocks
    CartServiceImpl cartService;

    @Test
    public void test(){
        System.out.println("cart dao mockito" + cartDaoMock);
        System.out.println("cart service mockito "+ cartService);
    }

    /*
    Test for createcart
     */
    @Test
    public void testCreateCart(){
        //Create the data
        Cart cart = new Cart();
        cart.setCustomerName("shakkib");

        Cart cart1 = new Cart();
        cart1.setCustomerName("shakkib");
        cart1.setCartId(1);

        //Giving the functionality to mock
        Mockito.when(cartDaoMock.save(cart)).thenReturn(cart1);

        //Execute
        Cart savedCart = cartService.createCart(cart);

        //Testing
        Assertions.assertNotNull(savedCart);
        Assertions.assertEquals(1,savedCart.getCartId());

    }
    /*
    Test for deleteCart remaining
     */
        @Test
       public void testDeleteCart(){
            //Data

            //Mock --when we have to mock a method that returns nothing
            Mockito.doNothing().when(cartDaoMock).deleteById(1);

            //Execution
            boolean deleteResult = cartService.deleteCart(1);

            //Assertion
            Assertions.assertTrue(deleteResult);
        }
    /*
    Test for findByCartId
     */@Test
        public void testFindByCartId() throws CartNotFoundException {
            //Data
            Cart cart1 = new Cart();
            cart1.setCustomerName("shakkib");
            cart1.setCartId(1);

            //Mock
            Mockito.when(cartDaoMock.findById(1)).thenReturn(Optional.of(cart1));

            // execution
            Cart cart = cartService.findCartbyId(1);

            //Assertion
            Assertions.assertNotNull(cart);
            Assertions.assertEquals("shakkib",cart.getCustomerName());
        }
        @Test
        public void testFindByCartIdThrowsException() throws CartNotFoundException{
            //Data
            Cart cart1 = new Cart();
            cart1.setCustomerName("shakkib");
            cart1.setCartId(1);

            //Mock
            Mockito.when(cartDaoMock.findById(1)).thenReturn(Optional.empty());

            //Execution
            try {
                Cart cart = cartService.findCartbyId(1);
            }catch (Exception e){
                Assertions.assertEquals(CartNotFoundException.class,e.getClass());
            }
        }
    /*
    Test for findBycustomerName
     */
    @Test
    public void testFindByCustomerName() throws CustomerNameNotFoundException {
        Cart cart1 = new Cart();
        cart1.setCustomerName("shakkib");
        cart1.setCartId(1);

        Mockito.when(cartDaoMock.findByCustomerName("shakkib")).thenReturn(cart1);

        //Execution
        Cart cart = cartService.findByCustomerName("shakkib");

        //Assertion
        Assertions.assertNotNull(cart);
        Assertions.assertEquals("shakkib",cart.getCustomerName());
    }
}

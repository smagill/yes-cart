package org.yes.cart.shoppingcart.impl;

import org.junit.Test;
import org.springframework.security.core.context.SecurityContextHolder;
import org.yes.cart.domain.dto.ShoppingCart;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * User: Igor Azarny iazarny@yahoo.com
 * Date: 09-May-2011
 * Time: 14:12:54
 */
public class LogoutCommandImplTest {
    @Test
    public void testExecute() {
        ShoppingCart shoppingCart = new ShoppingCartImpl();

        //assertNull(shoppingCart.getAuthentication());

        Map<String,String> params = new HashMap<String,String>();
        params.put(LoginCommandImpl.EMAIL,"test@test.com");
        params.put(LoginCommandImpl.NAME,"John Doe");

        LoginCommandImpl loginCommand = new LoginCommandImpl(
                null,
                params
                );

        loginCommand.execute(shoppingCart);

       // assertNotNull(shoppingCart.getAuthentication());

        /*assertEquals("TEst that auth in spring security context",
                SecurityContextHolder.getContext().getAuthentication(),
                shoppingCart.getAuthentication());         */

        LogoutCommandImpl command = new LogoutCommandImpl(null, null);
        command.execute(shoppingCart);

        //ssertNull(shoppingCart.getAuthentication());
        assertNull(shoppingCart.getCustomerEmail());
        assertNull(SecurityContextHolder.getContext().getAuthentication());

        assertNull(shoppingCart.getCustomerName());

        //assertEquals(ShoppingCart.NOT_LOGGED, shoppingCart.getLogonState());

    }
}
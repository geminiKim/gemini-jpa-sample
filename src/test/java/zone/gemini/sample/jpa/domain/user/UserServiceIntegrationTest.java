package zone.gemini.sample.jpa.domain.user;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import zone.gemini.sample.TestWithContext;
import zone.gemini.sample.builder.CartBuilder;
import zone.gemini.sample.builder.UserBuilder;
import zone.gemini.sample.jpa.domain.cart.Cart;
import zone.gemini.sample.jpa.domain.cart.CartRepository;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by gemini on 9/20/16.
 */
public class UserServiceIntegrationTest extends TestWithContext {
    @Autowired private UserRepository userRepository;
    @Autowired private CartRepository cartRepository;
    @Autowired private UserService userService;

    private User testUser;

    @Before
    public void setup(){
        testUser = new UserBuilder()
                        .withName("gemini")
                        .withPhone("01099723163")
                        .build();
        userRepository.save(testUser);
    }

    @After
    public void tearDown(){
        userRepository.delete(testUser.getId());
    }

    @Test
    public void testAddCart() {
        Cart cart = new CartBuilder()
                .withTitle("가자고 특가 디럭스 호텔")
                .withQuantity(1)
                .withPrice(10000)
                .build();

        userService.addCart(testUser.getId(), cart);

        User user = userRepository.findOne(testUser.getId());
        assertThat(user.getTotalCartQuantity(), is(1));
        assertThat(user.getTotalCartPrice(), is(10000));

        List<Cart> userCarts = cartRepository.findByUserId(testUser.getId());
        assertThat(userCarts.size(), is(1));
    }
}
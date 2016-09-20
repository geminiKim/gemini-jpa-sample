package zone.gemini.sample.jpa.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zone.gemini.sample.jpa.domain.cart.Cart;
import zone.gemini.sample.jpa.domain.cart.CartRepository;

@Component
public class UserCartAppender {
    private UserRepository userRepository;
    private CartRepository cartRepository;

    @Autowired
    public UserCartAppender(UserRepository userRepository, CartRepository cartRepository) {
        this.userRepository = userRepository;
        this.cartRepository = cartRepository;
    }

    public void addCart(final long userId, final Cart cart) {
        User user = userRepository.findOne(userId);
//        user.addCart(cart);
    }
}


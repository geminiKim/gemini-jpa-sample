package zone.gemini.sample.jpa.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zone.gemini.sample.jpa.domain.cart.Cart;

@Component
public class UserInfoUpdater {
    private UserRepository userRepository;

    @Autowired
    public UserInfoUpdater(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void updateCartInfo(final long userId, final Cart cart) {
        User user = userRepository.findOne(userId);
        user.updateCartInfo(cart.getItemQuantity(), cart.getPrice());
        cart.setUser(user);
    }
}


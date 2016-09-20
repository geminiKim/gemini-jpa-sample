package zone.gemini.sample.jpa.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import zone.gemini.sample.jpa.domain.cart.Cart;

@Component
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void addCart(final long userId, final Cart cart) {
        User user = userRepository.findOne(userId);
        user.addCart(cart);
    }
}


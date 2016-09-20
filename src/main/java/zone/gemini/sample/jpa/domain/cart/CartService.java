package zone.gemini.sample.jpa.domain.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zone.gemini.sample.jpa.domain.user.UserInfoUpdater;

@Service
public class CartService {
    private CartRepository cartRepository;
    private UserInfoUpdater userInfoUpdater;

    @Autowired
    public CartService(CartRepository cartRepository, UserInfoUpdater userInfoUpdater) {
        this.cartRepository = cartRepository;
        this.userInfoUpdater = userInfoUpdater;
    }

    @Transactional
    public void addCart(final Long userId, final Cart cart) {
        userInfoUpdater.updateCartInfo(userId, cart);
        cartRepository.save(cart);
    }
}
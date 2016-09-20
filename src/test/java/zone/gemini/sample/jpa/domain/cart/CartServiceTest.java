package zone.gemini.sample.jpa.domain.cart;

import org.junit.Before;
import org.junit.Test;
import zone.gemini.sample.builder.CartBuilder;
import zone.gemini.sample.jpa.domain.user.UserInfoUpdater;

import static org.mockito.Mockito.*;

public class CartServiceTest {
    private CartRepository mockCartRepository;
    private UserInfoUpdater mockUserInfoUpdater;
    private CartService cartService;

    @Before
    public void setUp() throws Exception {
        mockCartRepository = mock(CartRepository.class);
        mockUserInfoUpdater = mock(UserInfoUpdater.class);
        cartService = new CartService(mockCartRepository, mockUserInfoUpdater);
    }

    @Test
    public void testAddCart() throws Exception {
        Cart cart = new CartBuilder()
                .withTitle("가자고 특가 디럭스 호텔")
                .withQuantity(1)
                .withPrice(10000)
                .build();

        cartService.addCart(1l, cart);

        verify(mockUserInfoUpdater, times(1)).updateCartInfo(1l, cart);
        verify(mockCartRepository, times(1)).save(cart);
    }
}
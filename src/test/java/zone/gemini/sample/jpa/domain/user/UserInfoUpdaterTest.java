package zone.gemini.sample.jpa.domain.user;

import org.junit.Before;
import org.junit.Test;
import zone.gemini.sample.builder.CartBuilder;
import zone.gemini.sample.jpa.domain.cart.Cart;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;

public class UserInfoUpdaterTest {

    private UserInfoUpdater userInfoUpdater;
    private UserRepository mockUserRepository;

    @Before
    public void setup() {
        mockUserRepository = mock(UserRepository.class);
        userInfoUpdater = new UserInfoUpdater(mockUserRepository);
    }

    @Test
    public void testUpdateCartInfo() {
        Cart cart = new CartBuilder()
                .withTitle("가자고 특가 디럭스 호텔")
                .withQuantity(1)
                .withPrice(10000)
                .build();

        User mockUser = mock(User.class);
        when(mockUserRepository.findOne(anyLong())).thenReturn(mockUser);

        userInfoUpdater.updateCartInfo(1L, cart);

        verify(mockUserRepository, times(1)).findOne(anyLong());
        verify(mockUser, times(1)).updateCartInfo(anyInt(), anyInt());
    }
}
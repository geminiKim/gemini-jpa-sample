package zone.gemini.sample.jpa.domain.user;

import org.junit.Test;
import zone.gemini.sample.builder.UserBuilder;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class UserTest {

    @Test
    public void testUpdateUserInfo() {
        User user = new UserBuilder().build();

        user.updateInfo("gemini","01011223344");

        assertThat(user.getName(), is("gemini"));
        assertThat(user.getPhone(), is("01011223344"));
    }

    @Test
    public void testUpdateCartInfo() {
        User user = new UserBuilder().build();

        user.updateCartInfo(2, 10000);
        assertThat(user.getTotalCartQuantity(), is(2));
        assertThat(user.getTotalCartPrice(), is(10000));
    }
}
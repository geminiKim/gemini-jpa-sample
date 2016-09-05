package zone.gemini.sample.jpa.domain.user;

import org.junit.Test;
import zone.gemini.sample.jpa.domain.MockEntity;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class UserTest {

    @Test
    public void testUpdateUserInfo() {
        User user = new User();

        user.updateInfo("gemini","01011223344");

        assertThat(user.getName(), is("gemini"));
        assertThat(user.getPhone(), is("01011223344"));
    }

    @Test
    public void testUpdateUserInfoByMock() {
        User user = MockEntity.mock(User.class, 1l);

        user.updateInfo("gemini","01011223344");

        assertThat(user.getId(), is(1l));
        assertThat(user.getName(), is("gemini"));
        assertThat(user.getPhone(), is("01011223344"));
    }
}
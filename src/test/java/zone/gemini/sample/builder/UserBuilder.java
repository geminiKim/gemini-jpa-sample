package zone.gemini.sample.builder;

import zone.gemini.sample.jpa.domain.user.User;

/**
 * Created by gemini on 9/8/16.
 */
public class UserBuilder {
    private Long id;
    private String name;
    private String phone;

    public UserBuilder withId(Long id){
        this.id = id;
        return this;
    }
    public UserBuilder withName(String name){
        this.name = name;
        return this;
    }
    public UserBuilder withPhone(String phone){
        this.phone = phone;
        return this;
    }

    public User build() {
        User user = new User();
        user.setId(id);
        user.updateInfo(name, phone);
        return user;
    }
}

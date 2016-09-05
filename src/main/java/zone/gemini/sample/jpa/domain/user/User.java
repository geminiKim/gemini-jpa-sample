package zone.gemini.sample.jpa.domain.user;

import lombok.Getter;
import zone.gemini.sample.jpa.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Entity
public class User extends BaseEntity {
    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 20, nullable = false, unique = true)
    private String phone;

    public void updateInfo(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}

package zone.gemini.sample.jpa.domain.cart;

import lombok.Getter;
import lombok.Setter;
import zone.gemini.sample.jpa.domain.BaseEntity;
import zone.gemini.sample.jpa.domain.user.User;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class Cart extends BaseEntity {
    @Column(length = 50, nullable = false)
    private String title;

    @Column(nullable = false)
    private int itemQuantity;

    @Column(nullable = false)
    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private User user;
}

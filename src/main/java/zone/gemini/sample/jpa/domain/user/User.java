package zone.gemini.sample.jpa.domain.user;

import lombok.Getter;
import lombok.Setter;
import zone.gemini.sample.jpa.domain.BaseEntity;
import zone.gemini.sample.jpa.domain.cart.Cart;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Setter
@Getter
@Entity
public class User extends BaseEntity {
    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 20, unique = true)
    private String phone;

    @Column
    private int totalCartQuantity = 0;

    @Column
    private int totalCartPrice = 0;

    @OneToMany(mappedBy = "user")
    private List<Cart> carts;

    public void updateInfo(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public void updateCartInfo(int quantity, int price) {
        this.totalCartQuantity += quantity;
        this.totalCartPrice += price;
    }
}
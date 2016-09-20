package zone.gemini.sample.builder;

import zone.gemini.sample.jpa.domain.cart.Cart;

/**
 * Created by gemini on 9/12/16.
 */
public class CartBuilder {

    private String title;
    private int quantity;
    private int price;

    public CartBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public CartBuilder withQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public CartBuilder withPrice(int price) {
        this.price = price;
        return this;
    }

    public Cart build() {
        Cart cart = new Cart();
        cart.setTitle(title);
        cart.setItemQuantity(quantity);
        cart.setPrice(price);
        return cart;
    }
}

package zone.gemini.sample.jpa.domain.order;

import lombok.Getter;
import zone.gemini.sample.jpa.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Entity
public class Cart extends BaseEntity {
    @Column(length = 50, nullable = false)
    private String title;
}

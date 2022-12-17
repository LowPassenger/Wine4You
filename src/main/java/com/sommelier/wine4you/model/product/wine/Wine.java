package com.sommelier.wine4you.model.product.wine;

import com.sommelier.wine4you.model.product.Alcohol;
import com.sommelier.wine4you.model.product.Event;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "wines")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Wine extends Alcohol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Event event;
    private WineTaste taste;
    private WineStyle style;
    private WineType type;
    private Wine(String country, String brand, BigDecimal price, boolean inStock,
                float bottleSizeL,float alcoholPercent, WineStyle style, WineType type,
                WineTaste taste) {
        super(country, brand, price, inStock, bottleSizeL, alcoholPercent);
        this.style = style;
        this.type = type;
        this.taste = taste;
    }
}

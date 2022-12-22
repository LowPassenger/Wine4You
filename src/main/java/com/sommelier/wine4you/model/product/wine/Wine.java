package com.sommelier.wine4you.model.product.wine;

import com.sommelier.wine4you.model.product.Alcohol;
import com.sommelier.wine4you.model.product.Event;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
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
    @ManyToMany(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<Event> event;
    @ManyToMany
    @JoinColumn(name = "taste_id")
    private Set<Taste> taste;
    private short style;
    private short type;
    private Wine(String country, String brand, @ManyToOne Price price, boolean inStock,
                float bottleSizeL,float alcoholPercent, WineStyle style,
                 @OneToOne WineType type,
                WineTaste taste) {
        super(country, brand, price, inStock, bottleSizeL, alcoholPercent);
        this.style = style;
        this.type = type;
        this.taste = taste;
    }
}

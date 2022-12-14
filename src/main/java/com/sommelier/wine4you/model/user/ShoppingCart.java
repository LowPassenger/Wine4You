package com.sommelier.wine4you.model.user;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "shopping_carts")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ShoppingCart {
    @Id
    private Long id;
    @OneToMany
    @JoinTable(name = "shopping_carts_products",
            joinColumns = @JoinColumn(name = "shopping_cart_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Order> orders;
    @MapsId
    @OneToOne
    @JoinColumn(name = "id")
    private User user;
}

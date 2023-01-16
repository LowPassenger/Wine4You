package com.sommelier.wine4you.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sommelier.wine4you.model.enums.PaymentType;
import com.sommelier.wine4you.model.enums.ShippingType;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
import lombok.Setter;

@Entity
@Table(name = "shopping_carts")
@Getter
@Setter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
   // @JoinTable(name = "shopping_carts_products",
     //       joinColumns = @JoinColumn(name = "shopping_cart_id", referencedColumnName = "id"),
       //     inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
    private List<Item> items;
    @MapsId
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "delivery_price")
    private Double deliveryPrice;
    private Integer discount;
    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @ManyToOne
    //@JoinColumn(name = "id")
    private OrderDetails orderDetails;
    @Column(name = "created_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss.SSS")
    private LocalDateTime createdDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Cart cart = (Cart) o;

        if (!Objects.equals(id, cart.id)) {
            return false;
        }
        if (!Objects.equals(items, cart.items)) {
            return false;
        }
        if (!Objects.equals(user, cart.user)) {
            return false;
        }
        if (!Objects.equals(deliveryPrice, cart.deliveryPrice)) {
            return false;
        }
        if (!Objects.equals(discount, cart.discount)) {
            return false;
        }
        if (!Objects.equals(totalAmount, cart.totalAmount)) {
            return false;
        }
        if (!Objects.equals(orderDetails, cart.orderDetails)) {
            return false;
        }
        return Objects.equals(createdDate, cart.createdDate);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (items != null ? items.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (deliveryPrice != null ? deliveryPrice.hashCode() : 0);
        result = 31 * result + (discount != null ? discount.hashCode() : 0);
        result = 31 * result + (totalAmount != null ? totalAmount.hashCode() : 0);
        result = 31 * result + (orderDetails != null ? orderDetails.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        return result;
    }
}

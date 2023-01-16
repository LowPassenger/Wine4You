package com.sommelier.wine4you.model;

import com.sommelier.wine4you.model.enums.PaymentType;
import com.sommelier.wine4you.model.enums.ShippingType;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "order_details")
@Setter
@Getter
public class OrderDetails {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Long id;
    @OneToOne
    private Address deliveryAddress;
    @Column(name = "is_called")
    private Boolean dontCallMeBack;
    @Column(name = "buy_as_gift")
    private Boolean buyAsGift;
    @Enumerated(value = EnumType.STRING)
    private ShippingType shipping;
    @Enumerated(value = EnumType.STRING)
    private PaymentType payment;
}

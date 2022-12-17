package com.sommelier.wine4you.model.product.wine;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Graphics {
    @Id
    private Long id;
    @MapsId
    @OneToOne
    @JoinColumn(name = "id")
    private Wine wine;
    private String minUrl;
    private String maxUrl;
    private String maximaxUrl;
}

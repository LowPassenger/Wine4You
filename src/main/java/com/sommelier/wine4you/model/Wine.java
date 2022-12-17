package com.sommelier.wine4you.model;

import com.sommelier.wine4you.model.enums.Event;
import com.sommelier.wine4you.model.enums.WineStyle;
import com.sommelier.wine4you.model.enums.WineTaste;
import com.sommelier.wine4you.model.enums.WineType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "wines")
public class Wine extends Product {
    @Column(name = "name")
    private String name;

    @Column(name = "wine_style")
    @Enumerated(EnumType.STRING)
    private WineStyle wineStyle;

    @Column(name = "wine_type")
    @Enumerated(EnumType.STRING)
    private WineType wineType;

    @Column(name = "wine_taste")
    @Enumerated(EnumType.STRING)
    private WineTaste wineTaste;

    @Column(name = "capasity")
    private double capasity;
    private Event event;

    @Column(name = "image_url")
    private String imageUrl;
    private String description;
}

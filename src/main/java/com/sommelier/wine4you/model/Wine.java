package com.sommelier.wine4you.model;

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
public class Wine extends Product{
    private String name;
    @Enumerated(EnumType.STRING)
    private WineStyle wineStyle;
    @Enumerated(EnumType.STRING)
    private WineType wineType;
    private String description;
}

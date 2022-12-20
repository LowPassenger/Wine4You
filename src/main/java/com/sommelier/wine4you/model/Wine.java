package com.sommelier.wine4you.model;

import com.sommelier.wine4you.model.enums.Event;
import com.sommelier.wine4you.model.enums.WineStyle;
import com.sommelier.wine4you.model.enums.WineTaste;
import com.sommelier.wine4you.model.enums.WineType;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
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

    @Column(name = "event")
    @Enumerated(EnumType.STRING)
    private Event event;

    @Column(name = "capasity")
    private double capasity;
    @OneToOne(mappedBy = "wine", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private WineImage image;
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Wine wine = (Wine) o;

        if (Double.compare(wine.capasity, capasity) != 0) {
            return false;
        }
        if (!Objects.equals(name, wine.name)) {
            return false;
        }
        if (wineStyle != wine.wineStyle) {
            return false;
        }
        if (wineType != wine.wineType) {
            return false;
        }
        if (wineTaste != wine.wineTaste) {
            return false;
        }
        if (event != wine.event) {
            return false;
        }
        if (!Objects.equals(image, wine.image)) {
            return false;
        }
        return Objects.equals(description, wine.description);
    }

    @Override
    public int hashCode() {
        int result;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + (wineStyle != null ? wineStyle.hashCode() : 0);
        result = 31 * result + (wineType != null ? wineType.hashCode() : 0);
        result = 31 * result + (wineTaste != null ? wineTaste.hashCode() : 0);
        long temp;
        temp = Double.doubleToLongBits(capasity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (event != null ? event.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Wine{"
                + "name='" + name + '\''
                + ", wineStyle=" + wineStyle
                + ", wineType=" + wineType
                + ", wineTaste=" + wineTaste
                + ", capasity=" + capasity
                + ", event=" + event
                + ", image=" + image
                + ", description='" + description + '\''
                + '}';
    }
}
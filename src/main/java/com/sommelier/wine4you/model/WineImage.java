package com.sommelier.wine4you.model;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "wine_images")
@NoArgsConstructor
public class WineImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String minImage;
    private String middleImage;
    private String maxImage;
    @OneToOne
    @JoinColumn(name = "wine_id")
    private Wine wine;

    public WineImage(String minImage, String middleImage, String maxImage, Wine wine) {
        this.minImage = minImage;
        this.middleImage = middleImage;
        this.maxImage = maxImage;
        this.wine = wine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        WineImage wineImage = (WineImage) o;

        if (!Objects.equals(id, wineImage.id)) {
            return false;
        }
        if (!Objects.equals(minImage, wineImage.minImage)) {
            return false;
        }
        if (!Objects.equals(middleImage, wineImage.middleImage)) {
            return false;
        }
        if (!Objects.equals(maxImage, wineImage.maxImage)) {
            return false;
        }
        return Objects.equals(wine, wineImage.wine);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (minImage != null ? minImage.hashCode() : 0);
        result = 31 * result + (middleImage != null ? middleImage.hashCode() : 0);
        result = 31 * result + (maxImage != null ? maxImage.hashCode() : 0);
        result = 31 * result + (wine != null ? wine.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "WineImage{"
                + "id=" + id
                + ", minImage='" + minImage + '\''
                + ", middleImage='" + middleImage + '\''
                + ", maxImage='" + maxImage + '\''
                + ", wine=" + wine
                + '}';
    }
}

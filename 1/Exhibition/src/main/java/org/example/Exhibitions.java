package org.example;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "exhibitions")
public class Exhibitions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotBlank
    private String Theme;
    @NotBlank
    private int Showroom;
    @NotBlank
    private Date WorkPeriod;
    @NotBlank
    private int Price;


    public Exhibitions(String theme, int showroom, Date workPeriod, int price) {
        this.Theme = theme;
        this.Showroom = showroom;
        this.WorkPeriod = workPeriod;
        this.Price = price;
    }

    public String getTheme() {
        return Theme;
    }

    public void setTheme(String theme) {
        Theme = theme;
    }

    public int getShowroom() {
        return Showroom;
    }

    public void setShowroom(int showroom) {
        Showroom = showroom;
    }

    public Date getWorkPeriod() {
        return WorkPeriod;
    }

    public void setWorkPeriod(Date workPeriod) {
        WorkPeriod = workPeriod;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }
}

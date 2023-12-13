package co.funzies.models;

import java.time.LocalDate;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Embeddable
class Grid{
    private int x;
    private int y;

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public Grid(int x, int y){
        this.x = x;
        this.y = y;
    }
}

@Entity
@Table(name="planets")
public class Planet extends PanacheEntity {
    public String name;
    public LocalDate creationDate;
    @Embedded
    public Grid area;

    @ManyToOne(cascade = CascadeType.ALL)
    public User user;
}

package motorbikes.server;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "motorbikes")
public class Motorbike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String brand;
    private String type;
    private String fuel;
    private int maxspeed;

    public Motorbike() {
    }

    public Motorbike(String brand, String type, String fuel, int maxspeed) {
        this.brand = brand;
        this.type = type;
        this.fuel = fuel;
        this.maxspeed = maxspeed;
    }

    public int getId() {
        return this.id;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getType() {
        return this.type;
    }

    public String getFuel() {
        return this.fuel;
    }

    public int getMaxspeed() {
        return this.maxspeed;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public void setMaxspeed(int maxspeed) {
        this.maxspeed = maxspeed;
    }

}

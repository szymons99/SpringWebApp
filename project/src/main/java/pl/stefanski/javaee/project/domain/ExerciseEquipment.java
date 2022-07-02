package pl.stefanski.javaee.project.domain;

import pl.stefanski.javaee.project.customValidation.ExerciseEquipmentNameConstraint;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class ExerciseEquipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name can't be null")
    @ExerciseEquipmentNameConstraint
    private String name;

    @NotNull(message = "Price can't be null")
    @Min(0)
    private float price;

    @ManyToOne
    private Producer producer;

    @ManyToMany(fetch =  FetchType.EAGER)
    private List<Distributor> distributors;

    @OneToOne(cascade = CascadeType.ALL)
    private UserManual userManual;

    public ExerciseEquipment(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public ExerciseEquipment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public List<Distributor> getDistributors() {
        return distributors;
    }

    public void setDistributors(List<Distributor> distributors) {
        this.distributors = distributors;
    }

    public UserManual getUserManual() {
        return userManual;
    }

    public void setUserManual(UserManual userManual) {
        this.userManual = userManual;
    }

    @Override
    public String toString() {
        return "ExerciseEquipment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", producer=" + producer +
                ", distributors=" + distributors +
                ", userManual=" + userManual +
                '}';
    }
}

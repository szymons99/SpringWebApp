package pl.stefanski.javaee.project.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Distributor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @Min(1600)
    @Max(2022)
    @NotNull
    private int yoe;

    @ManyToMany(mappedBy = "distributors", fetch = FetchType.EAGER)
    @JsonIgnore
    List<ExerciseEquipment> exerciseEquipments;

    public Distributor(String name, int yoe) {
        this.name = name;
        this.yoe = yoe;
    }

    public Distributor() {
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

    @Column(name = "year_of_establishment")
    public int getYoe() {
        return yoe;
    }

    public void setYoe(int yoe) {
        this.yoe = yoe;
    }

    public List<ExerciseEquipment> getExerciseEquipments() {
        return exerciseEquipments;
    }

    public void setExerciseEquipments(List<ExerciseEquipment> exerciseEquipments) {
        this.exerciseEquipments = exerciseEquipments;
    }

    @Override
    public String toString() {
        return "Distributor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", yoe=" + yoe +
                ", exerciseEquipments=" + exerciseEquipments +
                '}';
    }
}


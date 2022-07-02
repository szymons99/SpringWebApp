package pl.stefanski.javaee.project.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class UserManual {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String description;

    @NotNull
    private int numOfPages;

    public UserManual(String description, int numOfPages) {
        this.description = description;
        this.numOfPages = numOfPages;
    }

    public UserManual() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }

    @Override
    public String toString() {
        return "UserManual{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", numOfPages=" + numOfPages +
                '}';
    }
}

package epsi.psupiot.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "animal")
@Inheritance(strategy = InheritanceType.JOINED)
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "birth")
    private Date birth;

    @Column(name = "color")
    private String color;

    @ManyToOne
    @JoinColumn(name = "petstore_id")
    private PetStore petStore;

    public Animal() {}

    public Animal(Date birth, String color, PetStore petStore) {
        this.birth = birth;
        this.color = color;
        this.petStore = petStore;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public PetStore getPetStore() {
        return petStore;
    }

    public void setPetStore(PetStore petStore) {
        this.petStore = petStore;
    }
}

package epsi.psupiot.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "cat")
public class Cat extends Animal {

    @Column(name = "chip_id")
    private String chipId;

    public Cat() {}

    public Cat(Date birth, String color, PetStore petStore, String chipId) {
        super(birth, color, petStore);
        this.chipId = chipId;
    }

    public String getChipId() { return chipId; }
    public void setChipId(String chipId) { this.chipId = chipId; }
}

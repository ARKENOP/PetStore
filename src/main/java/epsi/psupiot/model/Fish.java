package epsi.psupiot.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "fish")
public class Fish extends Animal{

    @Enumerated(EnumType.STRING)
    private FishLivEnv livingEnv;

    public Fish() {}

    public Fish(Date birth, String color, PetStore petStore, FishLivEnv livingEnv) {
        super(birth, color, petStore);
        this.livingEnv = livingEnv;
    }

    public FishLivEnv getLivingEnv() { return livingEnv; }
    public void setLivingEnv(FishLivEnv livingEnv) { this.livingEnv = livingEnv; }
}

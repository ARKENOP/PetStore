package epsi.psupiot.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "label")
    private String label;

    @Column(name = "price")
    private double price;

    @Enumerated(EnumType.STRING)
    private ProdType type;

    @ManyToMany
    @JoinTable(
            name = "petstore_product",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "petstore_id")
    )
    private List<PetStore> petStores;

    public Product() {}

    public Product(String code, String label, double price, ProdType type) {
        this.code = code;
        this.label = label;
        this.price = price;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProdType getType() {
        return type;
    }

    public void setType(ProdType type) {
        this.type = type;
    }

    public List<PetStore> getPetStores() {
        return petStores;
    }

    public void setPetStores(List<PetStore> petStores) {
        this.petStores = petStores;
    }
}

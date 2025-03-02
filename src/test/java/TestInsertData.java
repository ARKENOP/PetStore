import epsi.psupiot.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Date;
import java.util.List;

public class TestInsertData {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("petstore");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // Création des Adresses
        Address address1 = new Address("10", "Rue des Poissons", "75000", "Paris");
        Address address2 = new Address("42", "Avenue des Chiens", "69000", "Lyon");
        Address address3 = new Address("5", "Boulevard des Chats", "44000", "Nantes");

        em.persist(address1);
        em.persist(address2);
        em.persist(address3);

        // Création des Animaleries
        PetStore store1 = new PetStore("Animalia", "Alice");
        store1.setAddress(address1);
        PetStore store2 = new PetStore("ZooLand", "Bob");
        store2.setAddress(address2);
        PetStore store3 = new PetStore("HappyPets", "Charlie");
        store3.setAddress(address3);

        em.persist(store1);
        em.persist(store2);
        em.persist(store3);

        // Création des Produits
        Product prod1 = new Product("F001", "Croquettes", 10.99, ProdType.FOOD);
        Product prod2 = new Product("A001", "Collier", 5.99, ProdType.ACCESSORY);
        Product prod3 = new Product("C001", "Shampooing", 7.49, ProdType.CLEANING);

        em.persist(prod1);
        em.persist(prod2);
        em.persist(prod3);

        store1.setProducts(List.of(prod1, prod2));
        store2.setProducts(List.of(prod2, prod3));
        store3.setProducts(List.of(prod1, prod3));

        // Création des Animaux
        Animal animal1 = new Cat(new Date(), "Noir", store1, "CHIP123");
        Animal animal2 = new Fish(new Date(), "Rouge", store2, FishLivEnv.FRESH_WATER);
        Animal animal3 = new Fish(new Date(), "Bleu", store3, FishLivEnv.SEA_WATER);

        em.persist(animal1);
        em.persist(animal2);
        em.persist(animal3);

        store1.setAnimals(List.of(animal1));
        store2.setAnimals(List.of(animal2));
        store3.setAnimals(List.of(animal3));

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}

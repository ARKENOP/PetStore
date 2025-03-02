import epsi.psupiot.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class TestExtractAnimals {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("petstore");
        EntityManager em = emf.createEntityManager();

        // ID de l'animalerie à rechercher
        Long petStoreId = 1L;

        // Requête pour récupérer tous les animaux d'un PetStore
        List<Animal> animals = em.createQuery("SELECT a FROM Animal a WHERE a.petStore.id = :storeId", Animal.class)
                .setParameter("storeId", petStoreId)
                .getResultList();

        // Affichage des résultats
        System.out.println("Animaux de l'animalerie ID " + petStoreId + ":");
        for (Animal animal : animals) {
            System.out.println(" - " + animal.getClass().getSimpleName() + " de couleur " + animal.getColor());
        }

        em.close();
        emf.close();
    }
}

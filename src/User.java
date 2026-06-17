import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<Pet> pets;

    public User(String name) {
        this.name = name;
        this.pets = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void addPet(Pet pet) {
        this.pets.add(pet);
    }

    public void removePet(Pet pet) {
        this.pets.remove(pet);
    }

    public boolean hasPet(Pet pet) {
        return this.pets.contains(pet);
    }

    public void listPets() {
        if (pets.isEmpty()) {
            System.out.println(name + " has no pets.");
        } else {
            System.out.println(name + "'s pets:");
            for (Pet pet : pets) {
                System.out.println("- " + pet.getName() + " (" + pet.getClass().getSimpleName() + ")");
            }
        }
    }
}
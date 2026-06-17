import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VirtualPetGame {
    public static List<Pet> allPets = initializePets();
    public static List<User> allUsers = initializeUsers(); 
    public static User currentUser = null;
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\nCurrent user: " + (currentUser == null ? "None" : currentUser.getName()));
            System.out.println("0. Change the user");
            System.out.println("1. Register new user");
            System.out.println("2. Add Pet");
            System.out.println("3. Show Pets");
            System.out.println("4. Interact with Pet");
            System.out.println("5. Remove Pet");
            System.out.println("6. Remove User");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0 -> switchUser();
                case 1 -> registerUser();
                case 2 -> addPet();
                case 3 -> showPets();
                case 4 -> interactPets();
                case 5 -> removePets();
                case 6 -> removeUser();
                case 7 -> {
                    System.out.println("Bye");
                    return;
                }
                default -> System.out.println("Invalid input");
            }
        }
    }

    public static void registerUser() {
        System.out.print("Type a Username: ");
        String userName = scanner.nextLine();
        User newUser = new User(userName);
        allUsers.add(newUser);
        currentUser = newUser;
        System.out.println("User " + userName + " registered and logged in.");
    }

    public static void switchUser() {
        if (allUsers.isEmpty()) {
            System.out.println("No registered User.");
            return;
        }

        System.out.println("Users available:");
        for (int i = 0; i < allUsers.size(); i++) {
            System.out.println((i + 1) + ". " + allUsers.get(i).getName());
        }

        System.out.print("Choose the User number ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index < 0 || index >= allUsers.size()) {
            System.out.println("Invalid User.");
        } else {
            currentUser = allUsers.get(index);
            System.out.println("Now logged in with: " + currentUser.getName());
        }
    }

    public static void removeUser() {
        if (allUsers.isEmpty()) {
            System.out.println("No User to be removed.");
            return;
        }

        System.out.println("Registered Users:");
        for (int i = 0; i < allUsers.size(); i++) {
            System.out.println((i + 1) + ". " + allUsers.get(i).getName());
        }

        System.out.print("Choose an User to remove: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index < 0 || index >= allUsers.size()) {
            System.out.println("Invalid Input.");
            return;
        }

        User removedUser = allUsers.remove(index);
        System.out.println("User" + removedUser.getName() + " removed.");

        if (currentUser == removedUser) {
            currentUser = null;
            System.out.println("You have removed the logged in user. Please log in again.");
        }
    }

    public static void addPet() {
        System.out.println("Enter the Pet's name:");
        String name = scanner.nextLine();

        System.out.println("Choose the Pet's type:");
        System.out.println("1. Dog\n2. Cat\n3. Fish\n4. Horse");
        int type = scanner.nextInt();
        scanner.nextLine();

        switch (type) {
            case 1 -> {
                System.out.print("Dog size (Small/Medium/Large): ");
                String size = scanner.nextLine();
                Pet newDog = new Dog(name, size);
                allPets.add(newDog);
                if (currentUser != null) {
                    currentUser.addPet(newDog);
                }
            }
            case 2 -> {
                System.out.print("Fur length (Short/Medium/Long): ");
                String fur = scanner.nextLine();
                Pet newCat = new Cat(name, fur);
                allPets.add(newCat);
                if (currentUser != null) {
                    currentUser.addPet(newCat);
                }
            }
            case 3 -> {
                System.out.print("Fish species (ex: Goldfish, Betta): ");
                String species = scanner.nextLine();
                Pet newFish = new Fish(name, species);
                allPets.add(newFish);
                if (currentUser != null) {
                    currentUser.addPet(newFish);
                }
            }
            case 4 -> {
                System.out.print("Horse breed (ex: Mustang, Arabian): ");
                String breed = scanner.nextLine();
                Pet newHorse = new Horse(name, breed);
                allPets.add(newHorse);
                if (currentUser != null) {
                    currentUser.addPet(newHorse);
                }
            }
            default -> System.out.println("Invalid input.");
        }
    }

    public static void showPets() {
        if (allPets.isEmpty()) {
            System.out.println("No pets registered.");
            return;
        }
        System.out.println("All pets:");
        for (int i = 0; i < allPets.size(); i++) {
            System.out.println((i + 1) + ". " + allPets.get(i).getName() + " (" + allPets.get(i).getClass().getSimpleName() + ")");
        }
        if (currentUser != null) {
            currentUser.listPets();
        }
    }

    public static void interactPets() {

        if (allPets.isEmpty()) {
            System.out.println("No pets to interact with.");
            return;
        }

        showPets();
        System.out.print("Choose a pet by number: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index < 0 || index >= allPets.size()) {
            System.out.println("Invalid input.");
            return;
        }

        Pet petSelecionado = allPets.get(index);

        System.out.println("\n1. To feed");
        System.out.println("2. To play");
        System.out.println("3. To rest");
        System.out.println("4. Show status");
        System.out.print("Choose an option: ");
        int acao = scanner.nextInt();
        scanner.nextLine();

        switch (acao) {
            case 1 -> petSelecionado.feed();
            case 2 -> petSelecionado.play();
            case 3 -> petSelecionado.rest();
            case 4 -> petSelecionado.status();
            default -> System.out.println("Invalid input.");
        }

        checkPetHealth(petSelecionado); // Check health after interaction
    }
    

    private static void removePets() {
        if (allPets.isEmpty()) {
            System.out.println("No pets to be removed.");
            return;
        }

        showPets();
        System.out.print("Choose a pet to remove by number: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index < 0 || index >= allPets.size()) {
            System.out.println("Invalid input.");
            return;
        }

        Pet petToRemove = allPets.remove(index);
        System.out.println(petToRemove.getName() + " has been removed.");

        if (currentUser != null && currentUser.hasPet(petToRemove)) {
            currentUser.removePet(petToRemove);
        }

        if (petToRemove.getHealth() <= 0) {
            if (currentUser != null) {
                currentUser.removePet(petToRemove);
            }
            allPets.add(petToRemove); 
            System.out.println(petToRemove.getName() + " has died.");
        }
    }

    public static List<Pet> initializePets() {
        List<Pet> pets = new ArrayList<>();
        pets.add(new Dog("Buddy", "Large"));
        pets.add(new Dog("Max", "Medium"));
        pets.add(new Dog("Rocky", "Small"));
        pets.add(new Dog("Cleytin", "Small"));
        pets.add(new Dog("Daisy", "Medium"));

        pets.add(new Cat("Whiskers", "Short"));
        pets.add(new Cat("Luna", "Long"));
        pets.add(new Cat("Mittens", "Medium"));
        pets.add(new Cat("Shadow", "Long"));
        pets.add(new Cat("Smokey", "Short"));

        pets.add(new Fish("Nemo", "Goldfish"));
        pets.add(new Fish("Bubbles", "Betta"));
        pets.add(new Fish("Coral", "Angelfish"));
        pets.add(new Fish("Pearl", "Guppy"));
        pets.add(new Fish("Splash", "Koi"));

        pets.add(new Horse("Spirit", "Mustang"));
        pets.add(new Horse("Thunder", "Clydesdale"));
        pets.add(new Horse("Star", "Arabian"));
        pets.add(new Horse("Blaze", "Friesian"));
        pets.add(new Horse("Comet", "Appaloosa"));

        return pets;
    }

    public static List<User> initializeUsers() {
        List<User> users = new ArrayList<>();
        User user1 = new User("Alice");
        user1.addPet(findPetByName("Buddy"));
        user1.addPet(findPetByName("Max"));
        users.add(user1);

        User user2 = new User("Bob");
        user2.addPet(findPetByName("Spirit"));
        user2.addPet(findPetByName("Mittens"));
        users.add(user2);

        User user3 = new User("Charlie");
        user3.addPet(findPetByName("Nemo"));
        user3.addPet(findPetByName("Daisy"));
        users.add(user3);

        User user4 = new User("David");
        user4.addPet(findPetByName("Thunder"));
        user4.addPet(findPetByName("Smokey"));
        users.add(user4);

        User user5 = new User("Eve");
        user5.addPet(findPetByName("Max"));
        user5.addPet(findPetByName("Splash"));
        users.add(user5);

        return users;
    }

    public static Pet findPetByName(String petName) {
        for (Pet pet : allPets) {
            if (pet.getName().equals(petName)) {
                return pet;
            }
        }
        return null;
    }

    public static void checkPetHealth(Pet pet) {
        if (pet.getHealth() <= 0) {
            System.out.println(pet.getName() + " got sick and has been removed.");
            allPets.remove(pet);
            for (User user : allUsers) {
                if (user.hasPet(pet)) {
                    user.removePet(pet);
                }
            }
        }
    }}
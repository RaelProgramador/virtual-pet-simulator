public class Horse extends Pet {

    private String breed;

    public Horse(String name, String breed) {
        super(name);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public void action() {
        if (isSick()) {
            System.out.println(getName() + " is too sick to gallop. It stands weakly.");
            return;
        }
        System.out.println("Neigh! The horse is galloping.");
        setHealth(getHealth() - 3); // Galloping slightly decreases health
    }

    public void gallop() {
        if (isSick()) {
            System.out.println(getName() + " is too sick to gallop. It stumbles and can't run.");
            return;
        }
        if (getEnergy() < 25) {
            System.out.println("The horse is too tired to gallop.");
        } else {
            setEnergy(getEnergy() - 15);
            setHappiness(getHappiness() + 10);
            setHungry(getHungry() + 10);
            setHealth(getHealth() - 10); // Galloping heavily decreases health
            System.out.println("Galloping across the field with joy!");
        }
    }

    @Override
    public void status() {
        super.status();
        System.out.println("Breed: " + breed);
    }
}
public class Fish extends Pet {

    private String species;

    public Fish(String name, String species) {
        super(name);
        this.species = species;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public void action() {
        if (isSick()) {
            System.out.println(getName() + " is too sick to swim actively. It floats listlessly.");
            return;
        }
        System.out.println("Blub blub... Swimming around peacefully.");
        setHealth(getHealth() - 1); // Just existing slightly decreases health
    }

    public void swimFast() {
        if (isSick()) {
            System.out.println(getName() + " is too sick to swim fast. It barely moves.");
            return;
        }
        if (getEnergy() < 10) {
            System.out.println("Too tired to swim fast...");
        } else {
            setEnergy(getEnergy() - 5);
            setHappiness(getHappiness() + 5);
            setHealth(getHealth() - 3); // Fast swimming decreases health more
            System.out.println("Fish is swimming fast and looks excited!");
        }
    }

    @Override
    public void status() {
        super.status();
        System.out.println("Species: " + species);
    }
}
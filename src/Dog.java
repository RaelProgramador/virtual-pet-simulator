public class Dog extends Pet {

    private String size;

    public Dog(String name, String size) {
        super(name);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public void action() {
        if (isSick()) {
            System.out.println(getName() + " is too sick to bark. It whimpers softly.");
            return;
        }
        System.out.println("Whof Whof");
        setHealth(getHealth() - 1); // Barking slightly decreases health
    }

    public void walk() {
        if (isSick()) {
            System.out.println(getName() + " is too sick to go for a walk. It lies down sadly.");
            return;
        }
        if (getEnergy() < 20) {
            setAngry(getAngry() + 10);
            System.out.println("I don't want to walk");
        } else {
            setHappiness(getHappiness() + 10);
            setHungry(getHungry() + 5);
            setEnergy(getEnergy() - 10);
            setHealth(getHealth() - 5); // Walking decreases health
            System.out.println("I loved walking in this sunny day");
        }
    }

    @Override
    public void status() {
        super.status();
        System.out.println("Size: " + size);
    }
}
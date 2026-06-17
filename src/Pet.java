abstract class Pet {

    private String name;
    private int happiness, energy, angry, hungry;
    private int health; 
    private boolean isSick; 

    public Pet(String name) {
        this.name = name;
        this.happiness = 50;
        this.energy = 50;
        this.angry = 50;
        this.hungry = 50;
        this.health = 100; 
        this.isSick = false;

    }

    public String getName() {
        return name;
    }

    public int getHappiness() {
        return happiness;
    }

    public int getEnergy() {
        return energy;
    }

    public int getAngry() {
        return angry;
    }

    public int getHungry() {
        return hungry;
    }

    public int getHealth() {
        return health;
    }

    public boolean isSick() {
        return isSick;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void setAngry(int angry) {
        this.angry = angry;
    }

    public void setHungry(int hungry) {
        this.hungry = hungry;
    }

    public void setHealth(int health) {
        this.health = health;
        if (health < 20) {
            isSick = true;
        } else {
            isSick = false;
        }
        if (health < 0) {
            health = 0; 
        }
    }

    public void setSick(boolean sick) {
        isSick = sick;
    }

    public void play() {
        if (hungry <= 25) {
            angry += 5;
            System.out.println("I don't want to play. I am hungry");

        } else if (energy <= 15) {
            angry += 5;
            System.out.println("I don't want to play. I am tired");

        } else if (isSick()) {
            System.out.println(name + " is too sick to play.");
        }

        else {
            happiness = Math.min(happiness + 10, 100);
            energy -= 10;
            hungry += 10;
            angry -= 10;
            health = Math.max(0, health - 15);
            System.out.println("Thank you for playing with me, now I am happier");
        }
    }

    public void feed() {
        if (hungry < 10) {
            System.out.println("I don't want to eat anymore. I am full");

        } else {
            happiness = Math.min(happiness + 5, 100);
            energy += 5;
            hungry -= 10;
            angry -= 10;
            health = Math.min(100, health + 10);
            System.out.println("Thank you for giving me food, now I am can play more");
        }
    }

    public void rest() {
        if (energy > 80) {
            System.out.println("I don't want to rest. I am energetic");

        } else {
            happiness = Math.min(happiness + 10, 100);
            energy += 10;
            hungry += 10;
            angry -= 10;
            health = Math.min(100, health + 5);
            System.out.println("Thank you for letting me rest");
        }

    }

    public abstract void action();

    public void status() {
        System.out.println("My name is: " + name);
        System.out.println("happiness: " + happiness);
        System.out.println("energy: " + energy);
        System.out.println("angry: " + angry);
        System.out.println("hungry: " + hungry);
        System.out.println("health: " + health);
        System.out.println("isSick: " + isSick);
    }
}

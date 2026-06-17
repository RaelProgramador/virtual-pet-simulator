public class Cat extends Pet {
    private String furLength; 

    public Cat(String name, String furLength) {
        super(name);
        this.furLength = furLength;
    }

    public String getFurLength() {
        return furLength;
    }

    public void setFurLength(String furLength) {
        this.furLength = furLength;
    }

    @Override
    public void feed() {
        setHungry(getHungry() - 3);
        setEnergy(getEnergy() + 1);
        setHappiness(getHappiness() + 1);
        System.out.println(getName() + " is eating fish. Yum!");
    }

    @Override
    public void play() {
        setHappiness(getHappiness() + 3);
        setEnergy(getEnergy() - 2);
        setHungry(getHungry() + 1);
        System.out.println(getName() + " is playing with a ball of yarn!");
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Meow!");
    }
}

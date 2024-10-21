public class Enemies extends Character{
    private boolean fly;

    public Enemies(int hp, int attack, int defense, int speed, boolean fly) {
        super(hp, attack, defense, speed);
        this.fly = fly;
    }
}

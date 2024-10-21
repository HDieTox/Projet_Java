public abstract class Character {
    protected int hp;
    protected int attack;
    protected int defense;
    protected int speed;
    protected Position position;


    public Character(int hp, int attack, int defense, int speed) {
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
    }

}

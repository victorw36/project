public class Fighter {
    private String name;
    private int health;
    private int mana;

    public Fighter(String name, int health, int mana) {
        this.name = name;
        this.health = 20;
        this.mana = 10;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getMana() {
        return mana;
    }

    public void incrementMana() {
        this.mana += 1;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    public void manaLoss(int manaCost) {
        mana -= manaCost;
        if (mana < 0)
            mana = 0;{
        }
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void kick(Fighter opponent) {
        opponent.takeDamage(3);
        manaLoss(2);
    }

    public void jab(Fighter opponent) {
        opponent.takeDamage(1);
        manaLoss(1);
    }

    public void powerPunch(Fighter opponent) {
        opponent.takeDamage(7);
        manaLoss(6);
    }

    public void legSweep(Fighter opponent) {
        opponent.takeDamage(6);
        manaLoss(5);
    }

    public static String rules() {
        return "Each fighter stars with 10 mana and 20 health. The goal is to make your oppenent have 0 hp\n" +
                "Each player will gain 1 mana back after their turn ends\n" +
                "player1 is cowman and player2 is pigman\n" +
                "kick: mana Cost = 2, damage = 3\n" +
                "jab: mana Cost = 1, damage = 2\n" +
                "power punch: mana Cost = 6, damage = 10\n" +
                "legsweep: mana Cost = 4, damage = 7";
    }

    public static String moveList() {
        return "1. kick\n2. jab\n3. power punch\n4. leg sweep \n(type in number)";
    }
}

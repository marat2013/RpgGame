package heroes;
import enemies.Enemy;


public abstract class Hero implements Mortal {
    private final String name;
    private float health;
    private float strength;
    private float hitChance;
    private float discipline; // меняется в зависимости от собственного здоровья и здоровья противника
    private float basicDiscipline; // менять её могут только модификаторы дисциплины(в данной программе только призрак накладывает модификатор)

    public Hero(String name, float health, float strength, float hitChance, float discipline) {
        this.name=name;
        this.health=health;
        this.strength=strength;
        this.hitChance=hitChance;
        this.discipline=discipline;
        basicDiscipline=discipline;
    }

    public String getName() {
        return name;
    }

    public float getHealth() {
        return health;
    }

    public float getStrength() {
        return strength;
    }

    public float getHitChance() {
        return hitChance;
    }

    public float getDiscipline() {
        return discipline;
    }

    public float getBasicDiscipline() {
        return basicDiscipline;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public void setStrength(float strength) {
        this.strength = strength;
    }

    public void setHitChance(float hitChance) {
        this.hitChance = hitChance;
    }

    public void setDiscipline(float discipline) {
        this.discipline = discipline;
    }

    public void setBasicDiscipline(float basicDiscipline) {
        this.basicDiscipline = basicDiscipline;
    }

    public abstract void attackEnemy(Enemy enemy);

    public boolean isFighting() { return discipline>0; }

    public boolean isAlive() { return health>0; }
}
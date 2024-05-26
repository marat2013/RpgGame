package enemies;

import heroes.Hero;

public abstract class Enemy implements Mortal {

    private float health;
    private float strength;
    private float hitChance;
    private float discipline;

    public Enemy(float health, float strength, float hitChance, float discipline) {
        this.health=health;
        this.strength=strength;
        this.hitChance=hitChance;
        this.discipline=discipline;
    }

    public Enemy(float health, float strength, float hitChance) {
        this.health=health;
        this.strength=strength;
        this.hitChance=hitChance;
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

    public abstract void takeDamage(float damage, Hero hero);

    public boolean isAlive() { return health>0; }

    public boolean isFighting() {
        return discipline>0;
    }
}

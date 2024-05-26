package heroes;
import enemies.Enemy;

/*
Класс маг - средние здоровье, урон, шанс попасть по врагу, дисциплина
Особенные способности может с 30 % шансом повысить все свои характеристики
кроме здоровья
*/
public class Mage extends Hero {
    private final float fullHealth ;

    private int n = 1;
    public Mage(String name, float health, float strength, float hitChance, int discipline) {
        super(name, health, strength, hitChance, discipline);
        fullHealth = getHealth();
    }


    @Override
    public void attackEnemy(Enemy enemy) {


        if( (n > 0) && itHappens(0.3f) ){
            setHitChance(getHitChance() + 0.2f);
            setStrength(getStrength() + 5f);
            setDiscipline(getDiscipline() + 5f);
            System.out.println("Маг улучшил свои характеристики ");
            n-=1;
        }
        setDiscipline(getBasicDiscipline() + getHealth() * 0.4f - enemy.getHealth() * 0.6f);
        System.out.println("дисциплиана героя " + getDiscipline());

        if (isFighting()) enemy.takeDamage(getStrength(), this);
        else System.out.println("герой отступил");

    }

}
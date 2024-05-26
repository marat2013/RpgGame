package heroes;
import enemies.Enemy;

/*
Класс лучник - очень высокий урон, малое здоровье, средний шанс попасть по врагу, средняя дисциплина
Особенные способности может с 50 % шансом сконцентрироваться и повысить шанс попасть до 100 %
*/

public class Archer extends Hero {
    private final float fullHealth ;



    private int n = 1;
    public Archer(String name, float health, float strength, float hitChance, int discipline) {
        super(name, health, strength, hitChance, discipline);
        fullHealth = getHealth();
    }

    @Override
    public void attackEnemy(Enemy enemy) {

        if( (n > 0) && itHappens(0.5f) ){
            setHitChance(1f);
            System.out.println("Герой сконцентрировался и теперь не промахивается");
            n-=1;
        }

        setDiscipline(getBasicDiscipline() + getHealth() * 0.4f - enemy.getHealth() * 0.6f);
        System.out.println("дисциплиана героя " + getDiscipline());

        if (isFighting()) enemy.takeDamage(getStrength(), this);
        else System.out.println("герой отступил");

    }

}
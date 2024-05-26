package heroes;
import java.lang.*;
import enemies.Enemy;

/*
Класс воин - очень высокое здоровье, высокие дисциплина, шанс попасть по врагу, большой урон
Особенная способность при малом количестве здоровья с шансом 50 % может дважды за бой
воодушевляться повышая свою дисциплину
*/
public class Warrior extends Hero {
    private final float fullHealth ;

    private int n = 2;
    public Warrior(String name, float health, float strength, float hitChance, int discipline) {
        super(name, health, strength, hitChance, discipline);
        fullHealth=health;
    }

    @Override
   public void attackEnemy(Enemy enemy) {

        if(  (n > 0) && itHappens(0.5f)  && (getHealth() < 0.3f * fullHealth)  ){
            setDiscipline(getDiscipline()+10f);
            n-=1;
            System.out.println("Герой воодушевился получив 10 очков дисциплины");
        }

        setDiscipline(getBasicDiscipline() + getHealth() * 0.4f - enemy.getHealth() * 0.6f);
        System.out.println("дисциплиана героя " + getDiscipline());

        if (isFighting()) enemy.takeDamage(getStrength(), this);
        else System.out.println("герой отступил");




    }

}

package enemies;

import heroes.Hero;
import heroes.Mage;
/*
Противник призрак - очень малое здоровье, средний урон, высокий шанс попадания
дисциплины у него нет так как призрак не покидает поле боя
Особенные способности может 3 раза за бой с шансом 50 %
Особенные способности снижает дисциплину героя на 10 и имеет 75 % сопротивление
немагическому урону
*/
public class Ghost extends Enemy{
    int n = 1;
    private final float fullHealth ;


    public Ghost(float health, float strength, float hitChance) {
        super(health, strength, hitChance);
        fullHealth = getHealth();
    }


    public void takeDamage(float damage, Hero hero) {
        if (n > 0) {
            hero.setBasicDiscipline( hero.getBasicDiscipline()-10f );//Призрак снижает дисциплину рага
            float tmp;
            tmp = hero.getDiscipline()-10f;
            System.out.println("Герой напуган его дисциплина " + tmp );
            n-=1;
        }
        if( hero.itHappens(hero.getHitChance()) ){
            if(hero instanceof Mage) setHealth(getHealth()-damage);
            else setHealth(getHealth() - damage / 4.0f);// блокирует 75 % немагического урона
            if(getHealth() <= 0f ) {
                System.out.println("Призрак умер, герой перестал быть напуганым");
                hero.setBasicDiscipline( hero.getBasicDiscipline() + 10f );//призрак умер дисциплина вернулась
                return;
            }

            System.out.println("Призрак понес урон теперь его здоровье " + getHealth());
        }
        else System.out.println("Урон по призраку не прошел");

        if( itHappens(getHitChance()) ){
            hero.setHealth( hero.getHealth() - getStrength() );
            if(hero.getHealth() <= 0f ) {
                System.out.println("Герой получил урон и умер");
                return;
            }
            System.out.println("Герой понес урон теперь его здоровье " + hero.getHealth());
        }
        else System.out.println("Урон по герою не прошел");

    }
}

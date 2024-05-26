package enemies;

import heroes.Hero;
/*
Противник зомби - высокое здоровье, малый урон и малый шанс попасть, дисциплины у него нет
так как зомби не покидает поле боя
Особенные способности может 3 раза за бой с шансом 50 %
при малом количестве здоровья полностью исцелиться или умереть
*/
public class Zombie extends Enemy{
    private final float fullHealth ;
    int n = 3;


    public Zombie(float health, float strength, float hitChance) {
        super(health, strength, hitChance);
        fullHealth = getHealth();
    }


    public void takeDamage(float damage, Hero hero) {

        if( hero.itHappens(hero.getHitChance()) ){
            setHealth(getHealth() - damage);
            if(getHealth() <= 0f ) {
                System.out.println("Зомби умер");
                return;
            }

            System.out.println("Зомби понес урон теперь его здоровье " + getHealth());
        }
        else System.out.println("Урон по зомби не прошел");

        if( itHappens(getHitChance()) ){
            hero.setHealth( hero.getHealth() - getStrength() );
            if(hero.getHealth() <= 0f ) {
                System.out.println("Герой получил урон и умер");
                return;
            }
            System.out.println("Герой понес урон теперь его здоровье " + hero.getHealth());
        }
        else System.out.println("Урон по герою не прошел");

        if ( (n > 0 ) && (getHealth() < fullHealth * 0.4f) ) {
            if( itHappens(0.5f) ){
                setHealth(fullHealth);
                n-=1;
                System.out.println("Зомби воскрес теперь его здоровье " + getHealth());
            }
            else {
                setHealth(0f);;
                System.out.println("Зомби попытался воскреснуть и умер");
            }

        }



    }
}

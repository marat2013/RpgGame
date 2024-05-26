package enemies;

import heroes.Hero;
/*
Противник некромант - низкий шанс попасть, низкая дисциплина, высокое здоровье, средний урон
Особенные способности каждый ход крадет 10 % здоровья у героя забирая его себе
*/
public class Necromancer extends Enemy{
    private final float fullHealth ;
    private final float basicDiscipline;


    public Necromancer(float health, float strength, float hitChance, float discipline) {
        super(health, strength, hitChance, discipline);
        fullHealth = getHealth();
        basicDiscipline=discipline;
    }


    public void takeDamage(float damage, Hero hero) {

        if( hero.itHappens(hero.getHitChance()) ){
            setHealth(getHealth()-damage);;
            if(getHealth() <= 0f ) {
                System.out.println("Некромант умер");
                return;
            }
            System.out.println("Некромант понес урон теперь его здоровье " + getHealth());
        }
        else System.out.println("Урон по некроманту не прошел");

        setHealth(getHealth() + hero.getHealth() * 0.1f);//некромант похищает 10 % от текущего количества очков здоровья героя
        hero.setHealth( hero.getHealth() - hero.getHealth() * 0.1f );
        System.out.println("Некромант похищает здоровье героя теперь здоровье героя " + hero.getHealth() + " а некроманта " + getHealth());

        if( itHappens(getHitChance()) ) {
            hero.setHealth( hero.getHealth() - getStrength() );
            if(hero.getHealth() <= 0f ) {
                System.out.println("Герой получил урон и умер");
                return;
            }
            System.out.println("Герой понес урон теперь его здоровье " + hero.getHealth());
        }
        else System.out.println("Урон по герою не прошел");

        setDiscipline(basicDiscipline + getHealth() * 0.4f - hero.getHealth() * 0.6f);
        System.out.println("дисциплиана некроманта " + getDiscipline());

        if (!isFighting()) System.out.println("некромант отступил");

    }
}

import heroes.*;
import enemies.*;

import java.io.IOException;

public class BattleGround {
    public static void main(String[] args) {
        int n=1;
        Hero hero;

        Hero warrior = new Warrior("Boromir",100f,15f,0.7f,25);
        Hero mage = new Mage("Gandalf",60f,10f,0.5f,20);
        Hero archer = new Archer("Legolas",40f,20f,0.6f,20);

        Enemy necromancer = new Necromancer(50f,10f,0.4f,15);
        Enemy ghost = new Ghost(30f,10f,0.6f);
        Enemy zombie = new Zombie(50f,5f,0.3f);

        hero=archer;

        System.out.println("Герой сражается с зомби");
        while (hero.isAlive() && hero.isFighting() && zombie.isAlive()) {
            System.out.println("round " + n);
            hero.attackEnemy(zombie);
            n += 1;
        }

        n=1;
        if (hero.isFighting() && hero.isAlive() ) System.out.println("Герой сражается с призраком");
        while (hero.isAlive() && hero.isFighting() && ghost.isAlive()) {
            System.out.println("round " + n);
            hero.attackEnemy(ghost);
            n += 1;
        }

        n=1;
        if (hero.isFighting() && hero.isAlive() ) System.out.println("Герой сражается с некроматом");
        while (hero.isAlive() && hero.isFighting() && necromancer.isAlive() && necromancer.isFighting() ) {
            System.out.println("round " + n);
            hero.attackEnemy(necromancer);
            n += 1;
        }
        if (hero.isFighting() && hero.isAlive() ) System.out.println(hero.getName() + " победил");



    }
}

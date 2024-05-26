package enemies;

public interface Mortal {

   boolean isAlive();

   default public boolean itHappens(float eventProbability) {
      return Math.random() <= eventProbability;
   }
}

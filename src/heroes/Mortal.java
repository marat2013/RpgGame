package heroes;

public interface Mortal {
   boolean isAlive();

   // itHappens отвечает за то произойдет ли случайное событие или нет
   default public boolean itHappens(float eventProbability) {
      return Math.random() <= eventProbability;
   }
}

public class Kata {

    public static void main(String[] args) {
        System.out.println(
                Kata.declareWinner(new Fighter("Lew", 10, 2),new Fighter("Harry", 5, 4), "Lew"));

        System.out.println(Kata.declareWinner(new Fighter("Lew", 10, 2),new Fighter("Harry", 5, 4), "Harry"));

        System.out.println(Kata.declareWinner(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harry"));


        System.out.println( Kata.declareWinner(
                new Fighter("Jerry", 30, 3),
                new Fighter("Harald", 20, 5), "Jerry"));
    }

    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {

        int moves1 = (int) Math.ceil( (double)fighter2.health / fighter1.damagePerAttack);
        int moves2 = (int) Math.ceil( (double)fighter1.health / fighter2.damagePerAttack);
        if (moves1 > moves2) {
            return fighter2.name;
        } else if (moves1 < moves2) {
            return fighter1.name;
        } else {
            return firstAttacker;
        }


//        if(firstAttacker.equals(fighter1.name)){
//            return fight(fighter1, fighter2);
//        } else {
//            return fight(fighter2, fighter1);
//        }
    }

    private static String fight(Fighter fighter1, Fighter fighter2) {
        boolean firstAlive;
        boolean secondAlive;
        do {
            firstAlive = attackAndCheckIfLive(fighter1, fighter2);
            secondAlive = attackAndCheckIfLive(fighter2, fighter1);
        } while (firstAlive && secondAlive);

        if(!firstAlive)
            return fighter1.name;
        return fighter2.name;
    }


    public static boolean attackAndCheckIfLive(Fighter attacker, Fighter attacked) {
        return (attacked.health -= attacker.damagePerAttack) > 0;
    }


    public static class Fighter {
        public String name;
        public int health, damagePerAttack;
        public Fighter(String name, int health, int damagePerAttack) {
            this.name = name;
            this.health = health;
            this.damagePerAttack = damagePerAttack;
        }
    }
}
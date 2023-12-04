import java.util.Scanner;

public class Fight {
    private Fighter fighter1;
    private Fighter fighter2;
    private boolean moveAvailability;

    public Fight() {
        this.fighter1 = new Fighter("Cowman", 20, 10 );
        this.fighter2 = new Fighter("Pigman", 20, 10);
        moveAvailability = false;
    }

    public void startFight() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to see the rules? y/n");
        String answer = scanner.nextLine();

        if (answer.equals("y")) {
            System.out.println(Fighter.rules());
            System.out.println();
        }

        while (fighter1.isAlive() && fighter2.isAlive()) {
            System.out.println(fighter1.getName() + ", choose an attack");
            System.out.println(Fighter.moveList());

            // loops the decision to choose an attack if you don't meet mana requirements for player1
            while(!moveAvailability) {
                int attack = scanner.nextInt();
                if (attack == 1 && (fighter1.getMana() >= 2)) {
                    fighter1.kick(fighter2);
                    System.out.println(fighter1.getName() + " kicked " + fighter2.getName() + "!");
                    moveAvailability = true;
                }
                else if (attack == 2 && (fighter1.getMana() >= 1 )) {
                    fighter1.jab(fighter2);
                    System.out.println(fighter1.getName() + " jabbed " + fighter2.getName() + "!");
                    moveAvailability = true;
                }
                else if (attack == 3 && (fighter1.getMana() >= 6 )) {
                    fighter1.powerPunch(fighter2);
                    System.out.println(fighter1.getName() + " punched " + fighter2.getName() + " powerfully!");
                    moveAvailability = true;
                }
                else if (attack == 4 && (fighter1.getMana() >= 4 )) {
                    fighter1.legSweep(fighter2);
                    System.out.println(fighter1.getName() + " leg swept " + fighter2.getName() + "!");
                        moveAvailability = true;
                }
                else {
                    System.out.println("You do not have enough mana, choose another attack");
                }
            }
            moveAvailability = false;
            if(!fighter2.isAlive()) {
                break;
            }

            fighter1.incrementMana();
            System.out.println(fighter1.getName() + " has " + fighter1.getMana() + " mana left, " + fighter1.getName() + " has " + fighter1.getHealth() + " health left");
            System.out.println(fighter2.getName() + " has " + fighter2.getMana() + " mana left, " + fighter2.getName() + " has " + fighter2.getHealth() + " health left");
            System.out.println();


            System.out.println(fighter2.getName() + ", choose an attack");
            System.out.println(Fighter.moveList());

// loops the decision to choose an attack if you don't meet mana requirements for player2
            while(!moveAvailability) {
                int attack = scanner.nextInt();
                if (attack == 1 && (fighter2.getMana() >= 2)) {
                    fighter2.kick(fighter1);
                    System.out.println(fighter2.getName() + " kicked" + fighter1.getName() + "!");
                    moveAvailability = true;
                }
                else if (attack == 2 && (fighter2.getMana() >= 1 )) {
                    fighter2.jab(fighter1);
                    System.out.println(fighter2.getName() + " jabbed" + fighter1.getName() + "!");
                    moveAvailability = true;
                }
                else if (attack == 3 && (fighter2.getMana() >= 6 )) {
                    fighter2.powerPunch(fighter1);
                    System.out.println(fighter2.getName() + " punched" + fighter1.getName() + " powerfully!");
                    moveAvailability = true;
                }
                else if (attack == 4 && (fighter2.getMana() >= 4 )) {
                    fighter2.legSweep(fighter1);
                    System.out.println(fighter2.getName() + " kicked" + fighter1.getName() + "!");
                    moveAvailability = true;
                }
                else {
                    System.out.println("You do not have enough mana, choose another attack");
                }
            }
            moveAvailability = false;
            fighter2.incrementMana();

            System.out.println(fighter1.getName() + " has " + fighter1.getMana() + " mana left, " + fighter1.getName() + " has " + fighter1.getHealth() + " health left");
            System.out.println(fighter2.getName() + " has " + fighter2.getMana() + " mana left, " + fighter2.getName() + " has " + fighter2.getHealth() + " health left");
            System.out.println();
        }

        if (fighter1.getHealth() == 0) {
            System.out.println(fighter2.getName() +  " wins!");
        } else {
            System.out.println(fighter1.getName() + " wins!");
        }
    }
}





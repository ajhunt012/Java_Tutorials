import java.util.Scanner;
import java.util.Random;

public class TextBasedGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Initialize player variables
        int health = 100;
        int gold = 0;
        int room = 0;
        boolean hasExit = false;
        boolean hasMonster = false;

        while (true) {
            // Check if player has found the exit
            if (hasExit) {
                System.out.println("You found the exit! Congratulations, you have won the game!");
                return;
            }

            // Check if there is a monster in the room
            hasMonster = random.nextInt(2) == 1;
            if (hasMonster) {
                System.out.println("There is a monster in this room!");
            }

            // Display options
            System.out.println("What would you like to do?");
            System.out.println("1. Go left");
            System.out.println("2. Go right");
            System.out.println("3. Go forward");
            System.out.println("4. Go back");
            System.out.println("5. View inventory");
            if (hasMonster) {
                System.out.println("6. Fight monster");
            }
            System.out.println("7. Quit game");

            // Read user input
            int choice = scanner.nextInt();

            // Take action based on choice
            switch (choice) {
                case 1:
                    System.out.println("You go left.");
                    room--;
                    break;
                case 2:
                    System.out.println("You go right.");
                    room++;
                    break;
                case 3:
                    System.out.println("You go forward.");
                    room += 10;
                    break;
                case 4:
                    System.out.println("You go back.");
                    room -= 10;
                    break;
                case 5:
                    EquipmentTable.printInventory();
                    break;
                case 6:
                    if (hasMonster) {
                        Monster monster = MonsterTable.getMonster(random);
                        health = fightMonster(monster, health, random);
                    } else {
                        System.out.println("There is no monster in the room");


                                // Read user input
            int choice = scanner.nextInt();

            // Take action based on choice
            switch (choice) {
                case 1:
                    System.out.println("You go left.");
                    room--;
                    break;
                case 2:
                    System.out.println("You go right.");
                    room++;
                    break;
                case 3:
                    System.out.println("You go forward.");
                    room += 10;
                    break;
                case 4:
                    System.out.println("You go back.");
                    room -= 10;
                    break;
                case 5:
                    if (hasMonster) {
                        health = fightMonster(health, random);
                    } else {
                        System.out.println("There is no monster in this room.");
                    }
                    break;
                case 6:
                    System.out.println("Thanks for playing!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            // Check if player has found the exit
            if (room == 99) {
                hasExit = true;
            }
        }
    }
    class Monster {
        private final String name;
        private final int health;
        private final int strength;
        private final int agility;
        private final int defense;
        private final int encounterChance;

        public Monster(String name, int health, int strength, int agility, int defense, int encounterChance) {
            this.name = name;
            this.health = health;
            this.strength = strength;
            this.agility = agility;
            this.defense = defense;
            this.encounterChance = encounterChance;
        }

        public String getName() {
            return name;
        }

        public int getHealth() {
            return health;
        }

        public int getAttack() {
            return strength;
        }

        public int getAgility() {
            return agility;
        }

        public int getDefense() {
            return defense;
        }

        public int getEncounterChance() {
            return encounterChance;
        }
    }

//    private static final Map<String, Monster> MONSTERS;
//    static {
//        MONSTERS = new HashMap<>();
//        MONSTERS.put("goblin", new Monster("Goblin", 10, 5, 3, 2, 1));
//        MONSTERS.put("kobold", new Monster("Kobold", 8, 3, 2, 1, 2));
//        MONSTERS.put("wolf", new Monster("Wolf", 12, 7, 5, 4, 3));
//        MONSTERS.put("grave robber", new Monster("Grave Robber", 15, 10, 7, 5, 4));
//        MONSTERS.put("orc", new Monster("Orc", 20, 15, 10, 7, 5));
//        MONSTERS.put("gnoll", new Monster("Gnoll", 25, 20, 15, 10, 6));
//        MONSTERS.put("troll", new Monster("Troll", 30, 25, 20, 15, 7));
//        MONSTERS.put("minotaur", new Monster("Minotaur", 35, 30, 25, 20, 8));
//        MONSTERS.put("beholder", new Monster("Beholder", 40, 35, 30, 25, 9));
//    }

    public static int fightMonster(Monster monster, int health, int attack, int defense, int agility) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Initialize monster variables
        int monsterHealth = monster.getHealth();
        int monsterAttack = monster.getAttack();
        int monsterDefense = monster.getDefense();
        int monsterAgility = monster.getAgility();

        while (true) {
            // Display options
            System.out.println("What would you like to do?");
            System.out.println("1. Attack");
            System.out.println("2. Use item");
            System.out.println("3. Escape");

            // Read user input
            int choice = scanner.nextInt();

            // Take action based on choice
            switch (choice) {
                case 1:
                    // Calculate damage
                    int damage = attack - monsterDefense;
                    if (damage > 0) {
                        monsterHealth -= damage;
                        System.out.println("You attack the monster for " + damage + " damage!");
                    } else {
                        System.out.println("Your attack does no damage!");
                    }
                    break;
                case 2:
                    // Use item (not implemented)
                    break;
                case 3:
                    // Calculate chance of escaping
                    int escapeChance = agility - monsterAgility;
                    if (escapeChance > 0) {
                        System.out.println("You successfully escaped the monster!");
                        return health;
                    } else {
                        System.out.println("You failed to escape the monster!");
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            // Check if monster is defeated
            if (monsterHealth <= 0) {
                System.out.println("You defeated the monster!");
                return health;
            }

            // Monster attacks
            int monsterDamage = monsterAttack - defense;
            if (monsterDamage > 0) {
                health -= monsterDamage;
                System.out.println("The monster attacks you for " + monsterDamage + " damage!");
            } else {
                System.out.println("The monster's attack does no damage!");
            }

            // Check if player is defeated
            if (health <= 0) {
                System.out.println("You were defeated by the monster!");
                return 0;
            }
        }
    }


}

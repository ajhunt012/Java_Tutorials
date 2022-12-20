public class EquipmentTable {
        private static final Map<String, Equipment> EQUIPMENT;
        static {
            EQUIPMENT = new HashMap<>();
            EQUIPMENT.put("helmet", new Equipment("Helmet", 5, 0, 0, 0));
            EQUIPMENT.put("greaves", new Equipment("Greaves", 0, 5, 0, 0));
            EQUIPMENT.put("boots", new Equipment("Boots", 0, 0, 5, 0));
            EQUIPMENT.put("weapon", new Equipment("Weapon", 0, 10, 0, 0));
            EQUIPMENT.put("shield", new Equipment("Shield", 0, 0, 0, 5));
            EQUIPMENT.put("cloak", new Equipment("Cloak", 0, 0, 0, 10));
        }

        private static final Map<String, Equipment> INVENTORY;
        static {
            INVENTORY = new HashMap<>();
        }

        public static void addToInventory(Equipment equipment) {
            INVENTORY.put(equipment.getName().toLowerCase(), equipment);
        }

        public static void printInventory() {
            System.out.println("Inventory:");
            for (String key : INVENTORY.keySet()) {
                Equipment equipment = INVENTORY.get(key);
                System.out.println(equipment.getName() + ": " + equipment.getHealth() + " health, " + equipment.getStrength()
                        + " strength, " + equipment.getAgility() + " agility, " + equipment.getDefense() + " defense");
            }
        }

        public static void equip(String name) {
            Equipment equipment = INVENTORY.get(name.toLowerCase());
            if (equipment == null) {
                System.out.println("You do not have that item in your inventory.");
                return;
            }

            // Update player stats
            Player.setHealth(Player.getHealth() + equipment.getHealth());
            Player.setStrength(Player.getStrength() + equipment.getStrength());
            Player.setAgility(Player.getAgility() + equipment.getAgility());
            Player.setDefense(Player.getDefense() + equipment.getDefense());

            // Remove item from inventory
            INVENTORY.remove(name.toLowerCase());
        }

    }

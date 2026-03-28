package punic;
//список антипаттернов: god class, magic numbers, duplicated code, spaghetti code, hard coding, boat anchor, poltergeist
//golden hamer, anemic domain model, lava flow, big ball of mud, swiss army knife

public class Main {

    public static void main(String[] args) {
        System.out.println("Пунические войны");

        new BattlePoltergeist();
        Warrior[] romanArmy = new Warrior[5];
        romanArmy[0] = new Infantryman();
        romanArmy[1] = new Horseman();
        romanArmy[2] = new Archer();
        romanArmy[3] = new Infantryman();
        romanArmy[4] = new Horseman();

        Warrior[] carthageArmy = new Warrior[5];
        carthageArmy[0] = new Archer();
        carthageArmy[1] = new Archer();
        carthageArmy[2] = new Infantryman();
        carthageArmy[3] = new Horseman();
        carthageArmy[4] = new Archer();

        int[] romanHealth = new int[5];
        for (int i = 0; i < 5; i++) romanHealth[i] = 100;

        int[] carthageHealth = new int[5];
        for (int i = 0; i < 5; i++) carthageHealth[i] = 100;

        simulateBattle(romanArmy, carthageArmy, romanHealth, carthageHealth);

        doEverything(42, 100, "Рим победил", true, romanArmy[0], 50, carthageHealth[0], "Карфаген");
    }

    private static void simulateBattle(Warrior[] rome, Warrior[] cart, int[] romeHp, int[] cartHp) {
        for (int round = 1; round <= 10; round++) {
            System.out.println("\n=== Раунд " + round + " ===");

            for (int i = 0; i < 5; i++) {
                if (rome[i] instanceof Archer) {
                    for (int j = 0; j < 5; j++) {
                        if (cartHp[j] > 0) {
                            cartHp[j] -= 30;
                            if (cartHp[j] <= 0) {
                                System.out.println("Карфагенский лучник погиб");
                                cartHp[j] = 0;
                            }
                        }
                    }
                } else if (rome[i] instanceof Infantryman) {
                    for (int j = 0; j < 5; j++) {
                        if (cartHp[j] > 0) {
                            cartHp[j] -= 25;
                            if (cartHp[j] <= 0) {
                                System.out.println("Карфагенская пехота погибла");
                                cartHp[j] = 0;
                            }
                        }
                    }
                } else if (rome[i] instanceof Horseman) {
                    for (int j = 0; j < 5; j++) {
                        if (cartHp[j] > 0) {
                            cartHp[j] -= 40;
                            if (cartHp[j] <= 0) {
                                System.out.println("Карфагенская конница погибла");
                                cartHp[j] = 0;
                            }
                        }
                    }
                }
                rome[i].info();
            }

            for (int i = 0; i < 5; i++) {
                if (cart[i] instanceof Archer) {
                    for (int j = 0; j < 5; j++) {
                        if (romeHp[j] > 0) {
                            romeHp[j] -= 30;
                            if (romeHp[j] <= 0) {
                                System.out.println("Римский лучник погиб");
                                romeHp[j] = 0;
                            }
                        }
                    }
                } else if (cart[i] instanceof Infantryman) {
                    for (int j = 0; j < 5; j++) {
                        if (romeHp[j] > 0) {
                            romeHp[j] -= 25;
                            if (romeHp[j] <= 0) {
                                System.out.println("Римская пехота погибла");
                                romeHp[j] = 0;
                            }
                        }
                    }
                } else if (cart[i] instanceof Horseman) {
                    for (int j = 0; j < 5; j++) {
                        if (romeHp[j] > 0) {
                            romeHp[j] -= 40;
                            if (romeHp[j] <= 0) {
                                System.out.println("Римская конница погибла");
                                romeHp[j] = 0;
                            }
                        }
                    }
                }
                cart[i].info();
            }

            if (round == 5) {
                System.out.println("Середина битвы, все устали");
            }
        }
    }

    private static void doEverything(int roundNumber, int totalHealth, String winnerMessage,
                                     boolean isRomeWin, Warrior someWarrior, int damageBonus,
                                     int lastHp, String enemyName) {
        someWarrior.info();
        System.out.println(winnerMessage + " (бонус урона: " + damageBonus + ")");
        if (isRomeWin && lastHp < 10) {
            System.out.println("Рим победил Карфаген навсегда");
        }
    }

    private static class WarElephant {
        public void trample(Warrior[] army) {
            System.out.println("Боевой слон топчет всех врагов");
        }

        public void addToCarthage() {
        }
    }
    private static class BattlePoltergeist {
        public BattlePoltergeist() {
            System.out.println("Битва внезапно началась");
        }
    }
}
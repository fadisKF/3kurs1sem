package punic;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArmyFactory factory;

        System.out.println("Выберите сторону (1 - Рим, 2 - Карфаген): ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            factory = new RomanFactory();
        } else if (choice == 2) {
            factory = new CarthaginianFactory();
        } else {
            System.out.println("Неверный выбор!");
            return;
        }

        Warrior archer = factory.createArcher();
        Warrior infantry = factory.createInfantryman();
        Warrior horseman = factory.createHorseman();
        Warrior mercenary = factory.createMercenary();

        System.out.println("\nСоздана армия:");
        archer.info();
        infantry.info();
        horseman.info();
        mercenary.info();

        WarriorHandler archerHandler = new ArcherHandler();
        WarriorHandler infantryHandler = new InfantryHandler();
        WarriorHandler horsemanHandler = new HorsemanHandler();
        WarriorHandler mercenaryHandler = new MercenaryHandler();

        archerHandler.setNext(infantryHandler);
        infantryHandler.setNext(horsemanHandler);
        horsemanHandler.setNext(mercenaryHandler);

        System.out.println("\nВведите тип атаки (Лучник / Пехотинец / Всадник / Наемник): ");
        String request = scanner.next();

        archerHandler.handle(request);
    }
}
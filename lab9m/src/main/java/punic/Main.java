package punic;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите сторону (1 - Рим, 2 - Карфаген): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        AbstractArmyFactoryAspect factoryAspect;

        if (choice == 1) {
            factoryAspect = RomanArmyFactoryAspect.aspectOf();
        } else if (choice == 2) {
            factoryAspect = CarthaginianArmyFactoryAspect.aspectOf();
        } else {
            System.out.println("Неверный выбор!");
            scanner.close();
            return;
        }

        Warrior archer     = factoryAspect.createArcher();
        Warrior infantry   = factoryAspect.createInfantryman();
        Warrior horseman   = factoryAspect.createHorseman();
        Warrior mercenary  = factoryAspect.createMercenary();

        System.out.println("\nСоздана армия:");
        archer.info();
        infantry.info();
        horseman.info();
        mercenary.info();

        System.out.println("\nВведите тип атаки (Лучник / Пехотинец / Всадник / Наемник): ");
        String request = scanner.nextLine().trim();

        new WarriorHandler().handle(request);

        scanner.close();
    }
}
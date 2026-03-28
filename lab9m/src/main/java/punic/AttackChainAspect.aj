package punic;

public aspect AttackChainAspect {

    void around(String request) :
    execution(* punic.WarriorHandler.handle(String)) && args(request) {

        if (request == null || request.trim().isEmpty()) {
            System.out.println("Ввод пустой");
            return;
        }

        String input = request.trim();
        String lower = input.toLowerCase();

        if (lower.contains("луч") || lower.startsWith("л")) {
            System.out.println("Лучник выполняет атаку из лука");
            return;
        }
        if (lower.contains("пех") || lower.startsWith("п")) {
            System.out.println("Пехотинец вступает в ближний бой");
            return;
        }
        if (lower.contains("всад") || lower.startsWith("в")) {
            System.out.println("Кавалерия выполняет конную атаку");
            return;
        }
        if (lower.contains("наем") || lower.contains("наём") || lower.startsWith("н")) {
            System.out.println("Наемник выполняет особую миссию");
            return;
        }

        System.out.println("Неизвестный тип атаки: " + input);
        proceed(request);
    }
}
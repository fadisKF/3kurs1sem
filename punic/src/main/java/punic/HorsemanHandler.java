package punic;

public class HorsemanHandler extends WarriorHandler {

    public void handle(String request) {
        if (request.equalsIgnoreCase("Всадник")) {
            System.out.println("Кавалерия выполняет конную атаку");
        } else {
            super.handle(request);
        }
    }
}
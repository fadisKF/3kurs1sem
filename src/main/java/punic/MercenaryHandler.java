package punic;

public class MercenaryHandler extends WarriorHandler {

    public void handle(String request) {
        if (request.equalsIgnoreCase("Наемник")) {
            System.out.println("Наемник выполняет особую миссию");
        } else {
            System.out.println("Никто не смог обработать запрос!");
        }
    }
}
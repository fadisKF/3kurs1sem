package punic;

public class ArcherHandler extends WarriorHandler {

    public void handle(String request) {
        if (request.equalsIgnoreCase("Лучник")) {
            System.out.println("Лучник выполняет атаку из лука");
        } else {
            super.handle(request);
        }
    }
}
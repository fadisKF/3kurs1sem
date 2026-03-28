package punic;

public class InfantryHandler extends WarriorHandler {

    public void handle(String request) {
        if (request.equalsIgnoreCase("Пехотинец")) {
            System.out.println("Пехотинец вступает в ближний бой");
        } else {
            super.handle(request);
        }
    }
}
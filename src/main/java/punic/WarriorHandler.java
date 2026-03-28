package punic;

public abstract class WarriorHandler {

    protected WarriorHandler next;

    public void setNext(WarriorHandler next) {
        this.next = next;
    }

    public void handle(String request) {
        if (next != null) {
            next.handle(request);
        }
    }
}
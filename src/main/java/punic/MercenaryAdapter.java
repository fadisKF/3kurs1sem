package punic;

public class MercenaryAdapter implements Warrior {

    private Mercenary mercenary;

    public MercenaryAdapter(Mercenary mercenary) {
        this.mercenary = mercenary;
    }

    public void info() {
        mercenary.showUnit();   // адаптация вызова
    }
}
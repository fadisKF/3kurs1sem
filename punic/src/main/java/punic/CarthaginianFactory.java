package punic;

public class CarthaginianFactory implements ArmyFactory {

    public Warrior createArcher() {
        return new CarthaginianArcher();
    }

    public Warrior createInfantryman() {
        return new CarthaginianInfantryman();
    }

    public Warrior createHorseman() {
        return new CarthaginianHorseman();
    }

    public Warrior createMercenary() {
        return new MercenaryAdapter(new Mercenary());
    }
}
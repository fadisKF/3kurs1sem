package punic;

public class RomanFactory implements ArmyFactory {

    public Warrior createArcher() {
        return new RomanArcher();
    }

    public Warrior createInfantryman() {
        return new RomanInfantryman();
    }

    public Warrior createHorseman() {
        return new RomanHorseman();
    }

    public Warrior createMercenary() {
        return new MercenaryAdapter(new Mercenary());
    }
}
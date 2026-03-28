package punic;

import punic.Warrior;
import punic.RomanArcher;
import punic.RomanInfantryman;
import punic.RomanHorseman;
import punic.Mercenary;

public aspect RomanArmyFactoryAspect extends AbstractArmyFactoryAspect {

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
        return new Mercenary();
    }
}
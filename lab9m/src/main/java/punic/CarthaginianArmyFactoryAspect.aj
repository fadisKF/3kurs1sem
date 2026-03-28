package punic;

import punic.Warrior;
import punic.CarthaginianArcher;
import punic.CarthaginianInfantryman;
import punic.CarthaginianHorseman;
import punic.Mercenary;

public aspect CarthaginianArmyFactoryAspect extends AbstractArmyFactoryAspect {

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
        return new Mercenary();
    }
}
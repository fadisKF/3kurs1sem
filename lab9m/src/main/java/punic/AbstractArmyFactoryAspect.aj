package punic;

import punic.Warrior;

public abstract aspect AbstractArmyFactoryAspect {

public abstract Warrior createArcher();
public abstract Warrior createInfantryman();
public abstract Warrior createHorseman();
public abstract Warrior createMercenary();
}
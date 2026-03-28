package punic;

public interface ArmyFactory {
    Warrior createArcher();
    Warrior createInfantryman();
    Warrior createHorseman();
    Warrior createMercenary();
}
package punic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArmyFactoryTest {

    private ArmyFactory romanFactory;
    private ArmyFactory carthaginianFactory;

    @BeforeEach
    void setUp() {
        romanFactory = new RomanFactory();
        carthaginianFactory = new CarthaginianFactory();
    }

    @Test
    void testRomanFactoryCreatesAllUnits() {
        Warrior archer = romanFactory.createArcher();
        Warrior infantry = romanFactory.createInfantryman();
        Warrior horseman = romanFactory.createHorseman();
        Warrior mercenary = romanFactory.createMercenary();

        assertNotNull(archer);
        assertNotNull(infantry);
        assertNotNull(horseman);
        assertNotNull(mercenary);

        archer.info();
        infantry.info();
        horseman.info();
        mercenary.info();
    }

    @Test
    void testCarthaginianFactoryCreatesAllUnits() {
        Warrior archer = carthaginianFactory.createArcher();
        Warrior infantry = carthaginianFactory.createInfantryman();
        Warrior horseman = carthaginianFactory.createHorseman();
        Warrior mercenary = carthaginianFactory.createMercenary();

        assertNotNull(archer);
        assertNotNull(infantry);
        assertNotNull(horseman);
        assertNotNull(mercenary);

        archer.info();
        infantry.info();
        horseman.info();
        mercenary.info();
    }

    @Test
    void testMercenaryAdapter() {
        Mercenary mercenary = new Mercenary();
        MercenaryAdapter adapter = new MercenaryAdapter(mercenary);

        adapter.info();

        assertTrue(adapter instanceof Warrior);
    }
}
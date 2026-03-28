package punic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class WarriorHandlerTest {

    private WarriorHandler archerHandler;
    private WarriorHandler infantryHandler;
    private WarriorHandler horsemanHandler;
    private WarriorHandler mercenaryHandler;

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        archerHandler = new ArcherHandler();
        infantryHandler = new InfantryHandler();
        horsemanHandler = new HorsemanHandler();
        mercenaryHandler = new MercenaryHandler();

        // Собираем цепочку
        archerHandler.setNext(infantryHandler);
        infantryHandler.setNext(horsemanHandler);
        horsemanHandler.setNext(mercenaryHandler);

        System.setOut(new PrintStream(outputStream));
    }

    private void resetOutput() {
        outputStream.reset();
    }

    @Test
    void testArcherHandler() {
        resetOutput();
        archerHandler.handle("Лучник");
        assertTrue(outputStream.toString().contains("Лучник выполняет атаку из лука"));
    }

    @Test
    void testInfantryHandler() {
        resetOutput();
        archerHandler.handle("Пехотинец");
        assertTrue(outputStream.toString().contains("Пехотинец вступает в ближний бой"));
    }

    @Test
    void testHorsemanHandler() {
        resetOutput();
        archerHandler.handle("Всадник");
        assertTrue(outputStream.toString().contains("Кавалерия выполняет конную атаку"));
    }

    @Test
    void testMercenaryHandler() {
        resetOutput();
        archerHandler.handle("Наемник");
        assertTrue(outputStream.toString().contains("Наемник выполняет особую миссию"));
    }

    @Test
    void testUnknownRequest() {
        resetOutput();
        archerHandler.handle("НеизвестныйТип");
        assertTrue(outputStream.toString().contains("Никто не смог обработать запрос!"));
    }

    @Test
    void testCaseInsensitive() {
        resetOutput();
        archerHandler.handle("лучник");
        assertTrue(outputStream.toString().contains("Лучник выполняет атаку из лука"));

        resetOutput();
        archerHandler.handle("вСаДнИк");
        assertTrue(outputStream.toString().contains("Кавалерия выполняет конную атаку"));
    }

    @Test
    void testBaseHandlerWithNoNext() {
        resetOutput();
        WarriorHandler baseHandler = new WarriorHandler() {}; // анонимный класс
        baseHandler.handle("Что-то");
        assertEquals("", outputStream.toString().trim());
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }
}
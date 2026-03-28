package punic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @BeforeEach
    void setUp() {
        outputStream.reset();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    private void provideInput(String data) {
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }

    @Test
    void testRomanArmy() {
        provideInput("1\nЛучник\n");

        Main.main(new String[0]);

        String output = outputStream.toString();

        assertTrue(output.contains("Римский лучник"));
        assertTrue(output.contains("Лучник выполняет атаку из лука"));
    }

    @Test
    void testCarthaginianArmy() {
        provideInput("2\nВсадник\n");

        Main.main(new String[0]);

        String output = outputStream.toString();

        assertTrue(output.contains("Карфагенский всадник"));
        assertTrue(output.contains("Кавалерия выполняет конную атаку"));
    }

    @Test
    void testInvalidNumberChoice() {
        provideInput("5\n");
        Main.main(new String[0]);

        String output = outputStream.toString();
        assertTrue(output.contains("Неверный выбор!"));
        assertFalse(output.contains("Создана армия:"));
    }

    @Test
    void testNonNumericInput() {
        provideInput("abc\n");
        Main.main(new String[0]);

        String output = outputStream.toString();
        assertTrue(output.contains("Неверный выбор!"));
        assertFalse(output.contains("Создана армия:"));
    }

    @Test
    void testNoAttackInput() {
        provideInput("1\n");

        Main.main(new String[0]);

        String output = outputStream.toString();

        assertTrue(output.contains("Никто не смог обработать запрос!"));
    }

    @Test
    void testUnknownRequest() {
        provideInput("1\nXXX\n");

        Main.main(new String[0]);

        String output = outputStream.toString();

        assertTrue(output.contains("Никто не смог обработать запрос!"));
    }

    @Test
    void testCaseInsensitiveInput() {
        provideInput("1\nлУчНиК\n");

        Main.main(new String[0]);

        String output = outputStream.toString();

        assertTrue(output.contains("Лучник выполняет атаку из лука"));
    }
}
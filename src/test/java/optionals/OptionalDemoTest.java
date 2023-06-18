package optionals;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OptionalDemoTest {

    @Test
    public void testProcessOptionalValueWithValue() {
        OptionalDemo optionalDemo = new OptionalDemo();

        // Redireciona a saída padrão para verificar a impressão
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Optional<String> optionalValue = Optional.of("Hello, World!");
        optionalDemo.processOptionalValue(optionalValue);

        String expectedOutput = "Valor presente: Hello, World!\r\n" +
                "Valor presente: Hello, World!\r\n" +
                "Valor obtido com orElse(): Hello, World!\r\n" +
                "Valor obtido com orElseGet(): Hello, World!\r\n" +
                "Valor obtido com orElseThrow(): Hello, World!\r\n";

        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testProcessOptionalValueWithoutValue() {
        OptionalDemo optionalDemo = new OptionalDemo();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Optional<String> optionalEmpty = Optional.empty();
        optionalDemo.processOptionalValue(optionalEmpty);

        String expectedOutput = "Valor ausente\r\n" +
                "Valor obtido com orElse(): Valor padrão\r\n" +
                "Valor obtido com orElseGet(): Valor padrão obtido por uma função\r\n" +
                "Exceção lançada: Valor ausente\r\n";

        assertEquals(expectedOutput, outputStream.toString());
    }
}

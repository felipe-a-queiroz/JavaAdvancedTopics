package optionals;

import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args) {
        OptionalDemo optionalDemo = new OptionalDemo();

        // Exemplo de uso do Optional com um valor presente
        Optional<String> optionalValue = Optional.of("Hello, World!");
        optionalDemo.processOptionalValue(optionalValue);

        // Exemplo de uso do Optional com um valor ausente
        Optional<String> optionalEmpty = Optional.empty();
        optionalDemo.processOptionalValue(optionalEmpty);
    }

    public void processOptionalValue(Optional<String> optional) {
        // Verifica se o valor está presente usando o método isPresent()
        if (optional.isPresent()) {
            String value = optional.get();
            System.out.println("Valor presente: " + value);
        } else {
            System.out.println("Valor ausente");
        }

        // Utilizando o método ifPresent()
        optional.ifPresent(val -> System.out.println("Valor presente: " + val));

        // Obtendo um valor padrão com orElse()
        String defaultValue = optional.orElse("Valor padrão");
        System.out.println("Valor obtido com orElse(): " + defaultValue);

        // Obtendo um valor por meio de uma função com orElseGet()
        String valueFromSupplier = optional.orElseGet(() -> getDefaultValue());
        System.out.println("Valor obtido com orElseGet(): " + valueFromSupplier);

        // Lançando uma exceção com orElseThrow()
        try {
            String valueOrThrow = optional.orElseThrow(() -> new IllegalStateException("Valor ausente"));
            System.out.println("Valor obtido com orElseThrow(): " + valueOrThrow);
        } catch (IllegalStateException e) {
            System.out.println("Exceção lançada: " + e.getMessage());
        }
    }

    public String getDefaultValue() {
        return "Valor padrão obtido por uma função";
    }
}

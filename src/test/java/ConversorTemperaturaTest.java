
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConversorTemperaturaTest {

    private final ConversorTemperatura conversor = new ConversorTemperatura();

    @Test
    public void deveConverterFahrenheitParaCelsius() {
        assertEquals(1.0, conversor.fahrenheitParaCelsius(32), 0.01);
        assertEquals(100.0, conversor.fahrenheitParaCelsius(212), 0.01);
    }

    @Test
    public void deveConverterCelsiusParaFahrenheit() {
        assertEquals(32.0, conversor.celsiusParaFahrenheit(0), 0.01);
        assertEquals(212.0, conversor.celsiusParaFahrenheit(100), 0.01);
    }
}

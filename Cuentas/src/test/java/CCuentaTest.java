import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CCuentaTest {

    @Test
    @DisplayName("Test ingreso correcto")
    public void testIngresoCorrecto() {

        CCuenta cuenta = new CCuenta("Cuenta", "12435", 25);
        String respuesta = cuenta.ingresar(10);

        assertEquals("El ingreso ha sido correcto", respuesta);
        assertEquals(35, cuenta.saldo());
    }

    @Test
    @DisplayName("Test ingreso incorrecto")
    public void testIngresoIncorrecto() {

        CCuenta cuenta = new CCuenta("Cuenta", "12435", 25);
        String respuesta = cuenta.ingresar(-5);

        assertEquals("No se puede ingresar una cantidad negativa", respuesta);
        assertEquals(25, cuenta.saldo());
    }

    @Test
    @DisplayName("Test retirada correcto")
    public void testRetiradaCorrecto() {

        CCuenta cuenta = new CCuenta("Cuenta", "12435", 25);
        String respuesta = cuenta.retirar(10);

        assertEquals("Dinero retirado satisfactoriamente", respuesta);
        assertEquals(15, cuenta.saldo());
    }

    @Test
    @DisplayName("Test retirada incorrecto: negativo")
    public void testRetiradaNegativo() {

        CCuenta cuenta = new CCuenta("Cuenta", "12435", 25);
        String respuesta = cuenta.retirar(-5);

        assertEquals("No se puede retirar una cantidad negativa", respuesta);
        assertEquals(25, cuenta.saldo());
    }

    @Test
    @DisplayName("Test retirada incorrecto: insuficiente")
    public void testRetiradaInsuficiente() {

        CCuenta cuenta = new CCuenta("Cuenta", "12435", 5);
        String respuesta = cuenta.retirar(10);

        assertEquals("No hay suficiente saldo", respuesta);
        assertEquals(25, cuenta.saldo());
    }

}

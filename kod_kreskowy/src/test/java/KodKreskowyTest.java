import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class KodKreskowyTest {
    private KodKreskowy kodKreskowy;

    @Before
    public void setUp() {
        kodKreskowy = new KodKreskowy();
    }

    @Test
    public void sprawdzPoprawnoscDlugosciKodu() {
        assertEquals("12345678", kodKreskowy.sprawdzDlugoscKodu("12345678", 1));
        assertEquals("96385074", kodKreskowy.sprawdzDlugoscKodu("96385074", 1));
        assertEquals("1234567890", kodKreskowy.sprawdzDlugoscKodu("1234567890", 1));
        assertEquals("1234567890123", kodKreskowy.sprawdzDlugoscKodu("1234567890123", 1));

        assertEquals("5901234123457", kodKreskowy.sprawdzDlugoscKodu("5901234123457", 2));
        assertEquals("123456789012345", kodKreskowy.sprawdzDlugoscKodu("123456789012345", 2));
        assertEquals("123456789012345678", kodKreskowy.sprawdzDlugoscKodu("123456789012345678", 2));
    }

    @Test
    public void sprawdzCzyUcieloZero() {
        assertTrue(kodKreskowy.sprawdzUciecieZera("075678164125"));
        assertTrue(kodKreskowy.sprawdzUciecieZera("007567816412"));
        assertTrue(kodKreskowy.sprawdzUciecieZera("000678164125"));
        assertTrue(kodKreskowy.sprawdzUciecieZera("0123456"));
        assertTrue(kodKreskowy.sprawdzUciecieZera("0000000"));
    }

    @Test
    public void sprawdzPoprawnoscKodu() {
        assertEquals("12345678", kodKreskowy.zwrocPoprawnyKod("12345678", 1));
        assertEquals("12345678", kodKreskowy.zwrocPoprawnyKod("1234567893", 1));
        assertEquals("11111111", kodKreskowy.zwrocPoprawnyKod("1111111189345", 1));

        assertEquals("1234567890123", kodKreskowy.zwrocPoprawnyKod("1234567890123", 2));
        assertEquals("1234567890123", kodKreskowy.zwrocPoprawnyKod("123456789012399", 2));
        assertEquals("1234567890123", kodKreskowy.zwrocPoprawnyKod("123456789012399999", 2));

        assertEquals("0075678164125", kodKreskowy.zwrocPoprawnyKod("075678164125", 2));
        assertEquals("00123456", kodKreskowy.zwrocPoprawnyKod("0123456", 1));
    }
}
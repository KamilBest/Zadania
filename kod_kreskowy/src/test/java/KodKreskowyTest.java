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
    public void sprawdzPoprawnoscDlugosciKodu()
    {
        assertTrue(kodKreskowy.sprawdzDlugoscKodu("12345678", 1));

    }
}
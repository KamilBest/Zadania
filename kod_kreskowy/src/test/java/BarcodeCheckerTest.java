import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class BarcodeCheckerTest {
    private BarcodeChecker barcodeChecker;

    @Before
    public void setUp() {
        barcodeChecker = new BarcodeChecker();
    }

    @Test
    public void checkCorrectnessBarcodeLength() {
        assertEquals("12345678", barcodeChecker.checkBarcodeLength("12345678", 1));
        assertEquals("96385074", barcodeChecker.checkBarcodeLength("96385074", 1));
        assertEquals("1234567890", barcodeChecker.checkBarcodeLength("1234567890", 1));
        assertEquals("1234567890123", barcodeChecker.checkBarcodeLength("1234567890123", 1));

        assertEquals("5901234123457", barcodeChecker.checkBarcodeLength("5901234123457", 2));
        assertEquals("123456789012345", barcodeChecker.checkBarcodeLength("123456789012345", 2));
        assertEquals("123456789012345678", barcodeChecker.checkBarcodeLength("123456789012345678", 2));
    }
    @Test
    public void sprawdzCzyUcieloZero() {
        assertTrue(barcodeChecker.checkZeroTruncation("075678164125"));
        assertTrue(barcodeChecker.checkZeroTruncation("007567816412"));
        assertTrue(barcodeChecker.checkZeroTruncation("000678164125"));
        assertTrue(barcodeChecker.checkZeroTruncation("0123456"));
        assertTrue(barcodeChecker.checkZeroTruncation("0000000"));

    }
}

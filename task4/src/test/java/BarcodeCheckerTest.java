import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;



public class BarcodeCheckerTest {
    private BarcodeChecker barcodeChecker;

    @Before
    public void setUp() {
        barcodeChecker = new BarcodeChecker();
    }

    /**
     * Checking whether given barcode has correct length for each type.
     * type 1 - EAN-8, length: 8, 10, 13
     * type 2 - EAN-13, length: 13, 15, 18
     */
    @Test
    public void checkCorrectnessBarcodeLength() {
        assertEquals(8, barcodeChecker.checkBarcodeLength("12345678", 1));
        assertEquals(8, barcodeChecker.checkBarcodeLength("96385074", 1));
        assertEquals(10, barcodeChecker.checkBarcodeLength("1234567890", 1));
        assertEquals(13, barcodeChecker.checkBarcodeLength("1234567890123", 1));

        assertEquals(13, barcodeChecker.checkBarcodeLength("5901234123457", 2));
        assertEquals(15, barcodeChecker.checkBarcodeLength("123456789012345", 2));
        assertEquals(18, barcodeChecker.checkBarcodeLength("123456789012345678", 2));
    }

    /**
     * Checking whether the leading zero in barcode had been cut off
     */
    @Test
    public void checkLeadingZeroTruncation() {
        assertTrue(barcodeChecker.checkZeroTruncation("075678164125"));
        assertTrue(barcodeChecker.checkZeroTruncation("007567816412"));
        assertTrue(barcodeChecker.checkZeroTruncation("000678164125"));
        assertTrue(barcodeChecker.checkZeroTruncation("0123456"));
        assertTrue(barcodeChecker.checkZeroTruncation("0000000"));

        assertFalse(barcodeChecker.checkZeroTruncation("123456"));
        assertFalse(barcodeChecker.checkZeroTruncation("1000000"));

    }
}

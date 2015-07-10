import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BarcodeCheckerTest {
    private BarcodeChecker barcodeChecker;

    @Before
    public void setUp() {
        barcodeChecker = new BarcodeChecker();
    }

    @Test
    public void checkIsNumericMethod() {
        assertTrue(barcodeChecker.isNumeric("65833254"));
        assertTrue(barcodeChecker.isNumeric("3738507483"));

        assertTrue(barcodeChecker.isNumeric("5048706683695"));

        boolean thrown = false;
        try {
            barcodeChecker.isNumeric("asffbfddsf");
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        assertTrue(thrown);

        thrown = false;
        try {
            barcodeChecker.isNumeric("asvasb");
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    /**
     * Checking whether given barcode has correct length for each type.
     * type 1 - EAN-8, length: 8, 10, 13
     * type 2 - EAN-13, length: 13, 15, 18
     * <p/>
     * If length isn't correct method checkBarcodeLength throws IllegalArgumentException
     */
    @Test
    public void checkCorrectnessBarcodeLength() {
        /*
        EAN-8
         */
        assertTrue(barcodeChecker.checkBarcodeLength("65833254", BarcodeChecker.EAN8_TYPE));
        assertTrue(barcodeChecker.checkBarcodeLength("3738507483", BarcodeChecker.EAN8_TYPE));
        assertTrue(barcodeChecker.checkBarcodeLength("5048706683695", BarcodeChecker.EAN8_TYPE));

        boolean thrown = false;
        try {
            barcodeChecker.checkBarcodeLength("33254", BarcodeChecker.EAN8_TYPE);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        assertTrue(thrown);

        thrown = false;
        try {
            barcodeChecker.checkBarcodeLength("37385074831", BarcodeChecker.EAN8_TYPE);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        assertTrue(thrown);

         /*
        EAN-13
         */
        assertTrue(barcodeChecker.checkBarcodeLength("9470583666078", BarcodeChecker.EAN13_TYPE));
        assertTrue(barcodeChecker.checkBarcodeLength("175235835048870", BarcodeChecker.EAN13_TYPE));
        assertTrue(barcodeChecker.checkBarcodeLength("380006571113546495", BarcodeChecker.EAN13_TYPE));

        thrown = false;
        try {
            barcodeChecker.checkBarcodeLength("52358350", BarcodeChecker.EAN13_TYPE);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        assertTrue(thrown);

        thrown = false;
        try {
            barcodeChecker.checkBarcodeLength("8000657111354649", BarcodeChecker.EAN13_TYPE);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    /**
     * Checking whether the leading zero in barcode had been cut off.
     * If leading zero had been cut off method should throw CodeMissingLeadingZeroException,
     * so test checking whether exception had been thrown.
     */
    @Test
    public void checkLeadingZeroTruncation() {
        boolean thrown = false;
        try {
            barcodeChecker.checkZeroTruncation("0658332");
        } catch (CodeMissingLeadingZeroException e) {
            thrown = true;
        }
        assertTrue(thrown);

        thrown = false;
        try {
            barcodeChecker.checkZeroTruncation("094705836660");
        } catch (CodeMissingLeadingZeroException e) {
            thrown = true;
        }
        assertTrue(thrown);

        thrown = false;
        try {
            barcodeChecker.checkZeroTruncation("5048706683695");
        } catch (CodeMissingLeadingZeroException e) {
            thrown = true;
        }
        assertFalse(thrown);
    }
}

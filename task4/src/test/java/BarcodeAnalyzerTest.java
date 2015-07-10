import org.junit.Test;
import static org.junit.Assert.*;

public class BarcodeAnalyzerTest {
    private BarcodeAnalyzer barcodeAnalyzer;
    private TestBarcodeInput inputTest;
    BarcodeChecker checker;

    /**
     * Method testing barcode analyzer.
     * If length isn't correct method analyzeBarcode will return false.
     * EAN-8 - correct lengths: 8,10,13
     * EAN-13 - correct lengths:13,15,18
     */
    @Test
    public void checkAnalyzingBarcode() {
        checker = new BarcodeChecker();

        /*
        EAN-8
         */
        inputTest = new TestBarcodeInput("65833254", BarcodeChecker.EAN8_TYPE);
        barcodeAnalyzer = new BarcodeAnalyzer(inputTest, checker);
        assertTrue(barcodeAnalyzer.analyzeBarcode(inputTest));

        inputTest = new TestBarcodeInput("038507483", BarcodeChecker.EAN8_TYPE);
        barcodeAnalyzer = new BarcodeAnalyzer(inputTest, checker);
        assertTrue(barcodeAnalyzer.analyzeBarcode(inputTest));

        inputTest = new TestBarcodeInput("5048706683695", BarcodeChecker.EAN8_TYPE);
        barcodeAnalyzer = new BarcodeAnalyzer(inputTest, checker);
        assertTrue(barcodeAnalyzer.analyzeBarcode(inputTest));

        inputTest = new TestBarcodeInput("83695", BarcodeChecker.EAN8_TYPE);
        barcodeAnalyzer = new BarcodeAnalyzer(inputTest, checker);
        assertFalse(barcodeAnalyzer.analyzeBarcode(inputTest));

        inputTest = new TestBarcodeInput("28870668369", BarcodeChecker.EAN8_TYPE);
        barcodeAnalyzer = new BarcodeAnalyzer(inputTest, checker);
        assertFalse(barcodeAnalyzer.analyzeBarcode(inputTest));

        /*
        EAN-13
         */
        inputTest = new TestBarcodeInput("9470583666078", BarcodeChecker.EAN13_TYPE);
        barcodeAnalyzer = new BarcodeAnalyzer(inputTest, checker);
        assertTrue(barcodeAnalyzer.analyzeBarcode(inputTest));

        inputTest = new TestBarcodeInput("05235835048870", BarcodeChecker.EAN13_TYPE);
        barcodeAnalyzer = new BarcodeAnalyzer(inputTest, checker);
        assertTrue(barcodeAnalyzer.analyzeBarcode(inputTest));

        inputTest = new TestBarcodeInput("380006571113546495", BarcodeChecker.EAN13_TYPE);
        barcodeAnalyzer = new BarcodeAnalyzer(inputTest, checker);
        assertTrue(barcodeAnalyzer.analyzeBarcode(inputTest));

        inputTest = new TestBarcodeInput("48870", BarcodeChecker.EAN13_TYPE);
        barcodeAnalyzer = new BarcodeAnalyzer(inputTest, checker);
        assertFalse(barcodeAnalyzer.analyzeBarcode(inputTest));

        inputTest = new TestBarcodeInput("5835048870135464", BarcodeChecker.EAN13_TYPE);
        barcodeAnalyzer = new BarcodeAnalyzer(inputTest, checker);
        assertFalse(barcodeAnalyzer.analyzeBarcode(inputTest));
    }

    /**
     * Checking whether method returning correct barcode - without addon.
     * EAN-8 - correct lengths: 8,10,13
     * without addon always 8
     *
     * EAN-13 - correct lengths:13,15,18
     * without addon always 13
     * Method with barcode which contains addon should return this barcode without addon.
     */
    @Test
    public void checkReturningCorrectBarcode() {
        /*
        EAN-8
         */
        inputTest = new TestBarcodeInput("65833254", BarcodeChecker.EAN8_TYPE);
        barcodeAnalyzer = new BarcodeAnalyzer(inputTest, checker);
        assertEquals("65833254", barcodeAnalyzer.returnCorrectBarcode(inputTest.getBarcode(), inputTest.getBarcodeType()));

        inputTest = new TestBarcodeInput("9638507483", BarcodeChecker.EAN8_TYPE);
        barcodeAnalyzer = new BarcodeAnalyzer(inputTest, checker);
        assertEquals("96385074", barcodeAnalyzer.returnCorrectBarcode(inputTest.getBarcode(),inputTest.getBarcodeType()));

        inputTest = new TestBarcodeInput("5048706683695", BarcodeChecker.EAN8_TYPE);
        barcodeAnalyzer = new BarcodeAnalyzer(inputTest, checker);
        assertEquals("50487066", barcodeAnalyzer.returnCorrectBarcode(inputTest.getBarcode(),inputTest.getBarcodeType()));

        inputTest = new TestBarcodeInput("6583325434", BarcodeChecker.EAN8_TYPE);
        barcodeAnalyzer = new BarcodeAnalyzer(inputTest, checker);
        assertNotEquals("6583325434", barcodeAnalyzer.returnCorrectBarcode(inputTest.getBarcode(),inputTest.getBarcodeType()));

        inputTest = new TestBarcodeInput("2887066836", BarcodeChecker.EAN8_TYPE);
        barcodeAnalyzer = new BarcodeAnalyzer(inputTest, checker);
        assertNotEquals("2887066836", barcodeAnalyzer.returnCorrectBarcode(inputTest.getBarcode(),inputTest.getBarcodeType()));

        /*
        EAN-13
         */
        inputTest = new TestBarcodeInput("9470583666078", BarcodeChecker.EAN13_TYPE);
        barcodeAnalyzer = new BarcodeAnalyzer(inputTest, checker);
        assertEquals("9470583666078",barcodeAnalyzer.returnCorrectBarcode(inputTest.getBarcode(),inputTest.getBarcodeType()));

        inputTest = new TestBarcodeInput("645235835048870", BarcodeChecker.EAN13_TYPE);
        barcodeAnalyzer = new BarcodeAnalyzer(inputTest, checker);
        assertEquals("6452358350488", barcodeAnalyzer.returnCorrectBarcode(inputTest.getBarcode(),inputTest.getBarcodeType()));

        inputTest = new TestBarcodeInput("380006571113546495", BarcodeChecker.EAN13_TYPE);
        barcodeAnalyzer = new BarcodeAnalyzer(inputTest, checker);
        assertEquals("3800065711135", barcodeAnalyzer.returnCorrectBarcode(inputTest.getBarcode(),inputTest.getBarcodeType()));

        inputTest = new TestBarcodeInput("645235835048870", BarcodeChecker.EAN13_TYPE);
        barcodeAnalyzer = new BarcodeAnalyzer(inputTest, checker);
        assertNotEquals("645235835048870",barcodeAnalyzer.returnCorrectBarcode(inputTest.getBarcode(),inputTest.getBarcodeType()));

        inputTest = new TestBarcodeInput("380006571113546495", BarcodeChecker.EAN13_TYPE);
        barcodeAnalyzer = new BarcodeAnalyzer(inputTest, checker);
        assertNotEquals("380006571113546495",barcodeAnalyzer.returnCorrectBarcode(inputTest.getBarcode(),inputTest.getBarcodeType()));
    }
}


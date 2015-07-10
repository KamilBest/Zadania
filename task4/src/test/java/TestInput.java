import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestInput {
    private TestBarcodeInput inputTest;

    /**
     * checking scannerInput data correctness
     */
    @Test
    public void checkInput() {
        inputTest = new TestBarcodeInput("96385074", BarcodeChecker.EAN8_TYPE);
        assertEquals("96385074", inputTest.getBarcode());
        assertEquals(1, inputTest.getBarcodeType());

        inputTest = new TestBarcodeInput("5904277189152", BarcodeChecker.EAN13_TYPE);
        assertEquals("5904277189152", inputTest.getBarcode());
        assertEquals(2, inputTest.getBarcodeType());

        inputTest = new TestBarcodeInput("590427718915210", BarcodeChecker.EAN8_TYPE);
        assertEquals("590427718915210", inputTest.getBarcode());
        assertEquals(1, inputTest.getBarcodeType());

        inputTest = new TestBarcodeInput("9638507412", BarcodeChecker.EAN8_TYPE);
        assertEquals("9638507412", inputTest.getBarcode());
        assertEquals(1, inputTest.getBarcodeType());
    }
}


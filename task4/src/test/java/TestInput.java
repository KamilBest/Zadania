/**
 * Created by kamilbest on 04.07.15.
 */

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestInput {
    private TakeInputTest inputTest;

    /**
     * checking input data correctness
     */
    @Test
    public void checkInput() {
        inputTest = new TakeInputTest("12345678", 1);
        assertEquals("12345678", inputTest.getBarcode());
        assertEquals(1, inputTest.getBarcodeType());

        inputTest = new TakeInputTest("1234567890987", 2);
        assertEquals("1234567890987", inputTest.getBarcode());
        assertEquals(2, inputTest.getBarcodeType());

        inputTest = new TakeInputTest("111", 1);
        assertEquals("111", inputTest.getBarcode());
        assertEquals(1, inputTest.getBarcodeType());

        inputTest = new TakeInputTest("000111000", 1);
        assertEquals("000111000", inputTest.getBarcode());
        assertEquals(1, inputTest.getBarcodeType());

    }
}

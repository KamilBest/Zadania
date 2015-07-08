/**
 * Class for testing input
 */
class TestBarcodeInput implements BarcodeInputInterface {
    private String barcode;
    private int barcodeType;

    /**
     * constructor, setting variables
     *
     * @param String givenBarcode
     * @param int    givenBarcodeType
     */
    public TestBarcodeInput(String givenBarcode, int givenBarcodeType) {
        barcode = givenBarcode;
        barcodeType = givenBarcodeType;
    }

    /**
     * returns barcode
     *
     * @return String
     */
    public String getBarcode() {
        return barcode;
    }

    /**
     * returns barcode type
     *
     * @return int
     */
    public int getBarcodeType() {
        return barcodeType;
    }
}
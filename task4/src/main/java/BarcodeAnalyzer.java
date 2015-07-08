/**
 * Class of analyzing barcodes EAN-13 and EAN-8.
 * Input barcode: text parameter,
 * Barcode type - numeric parameter: 1 of EAN-8, EAN-2 to 13.
 * The program is note that: some barcode scanners can cut in a bar code
 * first leading zero (eg. Instead of the code 0075678164125 send 075678164125 ).
 * Some products (eg. Newspapers) have additional codes (ie. Add-on'y), the scanner appends them directly to the appropriate barcode
 * (Read add-on "12" and the appropriate code "6920702707721" is sent as "692070270772112").
 * Add-on'y may occur for both EAN-8 and EAN I-13.
 * Any errors are signaled with exceptions.
 * For information on barcodes: http://pl.wikipedia.org/wiki/EAN
 *
 * @author KamilBest
 */
class BarcodeAnalyzer {
    protected BarcodeInputInterface input;
    protected String barcode;
    protected int barcodeType;
    private char[] barcodeToAnalyze;
    private BarcodeChecker checker;

    /**
     * Constructor
     *
     * @param BarcodeScannerInput input, BarcodeChecker checker
     */
    public BarcodeAnalyzer(BarcodeInputInterface input, BarcodeChecker checker) {
        this.checker = checker;
        this.input = input;
    }

    /**
     * Main method of the class. Combines all classes together.
     * 1. Taking input from user.
     * 2. Checking whether leading zero had been cut off, if yes, adding leading zero to barcode
     * and then checking correctness of barcode and type length.
     * If hadn't been cut of checking lengths withoud adding zero.
     * 3.Showing correct barcode.
     * 4.Returning tre or false.
     *
     * @return boolean
     */
    public boolean analyzeBarcode() {
        barcode = this.input.getBarcode();
        barcodeType = this.input.getBarcodeType();
        try {
            this.checker.checkZeroTruncation(barcode);
        } catch (CodeMissingLeadingZeroException e) {
            barcode = '0' + barcode;
        }
        try {
            if(this.checker.checkBarcodeLength(barcode, barcodeType))
                return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
        return false;
    }

    /**
     * The method returns correct barcode - without addons.
     *
     * @param String givenBarcode, int givenBarcodeType
     * @return String - correct barcode
     */
    public String returnCorrectBarcode() {
        barcodeToAnalyze = barcode.toCharArray();
        int givenBarcodeLength = barcode.length();
        char[] entireBarcode = new char[givenBarcodeLength];
        String correctBarcode = "";
        if (barcodeType == 1)
            for (int i = 0; i < 8; i++) {
                entireBarcode[i] = barcodeToAnalyze[i];
                correctBarcode += entireBarcode[i];
            }
        else if (barcodeType == 2)
            for (int i = 0; i < 13; i++) {
                entireBarcode[i] = barcodeToAnalyze[i];
                correctBarcode += entireBarcode[i];
            }
        return correctBarcode;
    }
}
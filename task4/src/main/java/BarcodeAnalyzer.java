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
    protected BarcodeScannerInput input;
    protected String barcode;
    protected int barcodeType;
    private char[] barcodeToAnalyze;

    /**
     * Constructor for taking input from user
     *
     * @param BarcodeScannerInput input
     */
    public BarcodeAnalyzer(BarcodeScannerInput input){
        this.input=input;
        this.barcode=input.getBarcode();
        this.barcodeType=input.getBarcodeType();
    }

    /**
     * The method adds leading 0 if it had been cut off.
     *
     * @param String givenBarcode
     * @return String
     */
    public String addLeadingZero(String givenBarcode) {
        givenBarcode = "0" + givenBarcode;
        barcodeToAnalyze = givenBarcode.toCharArray();
        return givenBarcode;
    }

    /**
     * The method returns correct barcode - without addons.
     *
     * @param BarcodeChecker barcodeCheckerObj, String givenBarcode, int givenBarcodeType
     * @return char[] - correct barcode
     */
    public String returnCorrectBarcode(BarcodeChecker barcodeCheckerObj,String givenBarcode, int givenBarcodeType) {
        if (barcodeCheckerObj.checkZeroTruncation(givenBarcode) == true)
            givenBarcode = addLeadingZero(givenBarcode);
        else
            barcodeToAnalyze = givenBarcode.toCharArray();
        int barcodeLength=barcodeCheckerObj.checkBarcodeLength(givenBarcode, givenBarcodeType);
        char[] entireBarcode = new char[barcodeLength];
        String correctBarcode = "";
        System.out.println("Barcode type and barcode are correct.");
        System.out.println("Correct barcode without addon:");
        if (givenBarcodeType == 1)
            for (int i = 0; i < 8; i++) {
                entireBarcode[i] = barcodeToAnalyze[i];
                correctBarcode += entireBarcode[i];
            }
        else if (givenBarcodeType == 2)
            for (int i = 0; i < 13; i++) {
                entireBarcode[i] = barcodeToAnalyze[i];
                correctBarcode += entireBarcode[i];
            }

        return correctBarcode;
    }

    /**
     * The methods runs checking barcode.
     */
    public void run() {
        BarcodeChecker checker=new BarcodeChecker();
        System.out.println(returnCorrectBarcode(checker,barcode, barcodeType));
    }
}
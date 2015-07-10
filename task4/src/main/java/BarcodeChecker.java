/**
 * Class checking correctness (correct length) of given barcode and type.
 * Checking whether leading zero in barcode had been cut off or not.
 */
class BarcodeChecker {
    public static final int EAN8_TYPE = 1;
    public static final int EAN13_TYPE = 2;
    public static final int EAN8_LENGTH = 8;
    public static final int EAN13_LENGTH = 13;
    private final int EAN8_ADDON2_LENGTH = 10;
    private final int EAN8_ADDON5_LENGTH = 13;
    private final int EAN13_ADDON2_LENGTH = 15;
    private final int EAN13_ADDON5_LENGTH = 18;
    private int barcodeLength;

    /**
     * The method checking correctness of barcode length
     *
     * @param String givenBarcode, int givenBarcodeType
     * @return boolean, true if lenghts are ok
     * @throws IllegalArgumentException
     */
    public boolean checkBarcodeLength(String givenBarcode, int givenBarcodeType) throws IllegalArgumentException/**/ {
        barcodeLength = givenBarcode.length();

         /*
         Checking whether barcode length is correct (8 or 13 and with possible addon 2 or 5 digits)
        Correct length:
        Barcode type = 1, 8, 10 or 13
        Barcode type = 2, 13, 15 lub 18
         */
        if ((givenBarcodeType != EAN8_TYPE) && (givenBarcodeType != EAN13_TYPE))
            throw new IllegalArgumentException("Incorrect barrcode type! Required type 1 or 2.");
        else if ((givenBarcodeType == EAN8_TYPE) && (barcodeLength < EAN8_LENGTH))
            throw new IllegalArgumentException("Incorrect barrcode length for type 1(EAN-8)!");
        else if ((givenBarcodeType == EAN13_TYPE) && (barcodeLength < EAN13_LENGTH))
            throw new IllegalArgumentException("Incorrect barrcode length for type 2(EAN-13)!");
        else if ((givenBarcodeType == EAN8_TYPE) && ((barcodeLength != EAN8_LENGTH) && (barcodeLength != EAN8_ADDON2_LENGTH) && (barcodeLength != EAN8_ADDON5_LENGTH)))
            throw new IllegalArgumentException("Incorrect barcode length for type 1(EAN-8)!");
        else if ((givenBarcodeType == EAN13_TYPE)
                && ((barcodeLength != EAN13_LENGTH) && (barcodeLength != EAN13_ADDON2_LENGTH) && (barcodeLength != EAN13_ADDON5_LENGTH)))
            throw new IllegalArgumentException("Incorrect barrcode length for type 2(EAN-13)!");
        else
            return true;
    }

    /**
     * The method checking leading zero truncation.
     * Possible lengths when zero could be cut off: 7,9,12,14,17
     *
     * @param String givenBarcode
     * @return boolean
     */
    public boolean checkZeroTruncation(String givenBarcode) throws CodeMissingLeadingZeroException {
        final int CHECKED_LENGTHS = 5;
        barcodeLength = givenBarcode.length();
        char firstCharacter = givenBarcode.charAt(0);
        int[] truncationLengths = {7, 9, 12, 14, 17};
        for (int i = 0; i < CHECKED_LENGTHS; i++) {
            if ((firstCharacter == '0') && (barcodeLength == truncationLengths[i])) {
                throw new CodeMissingLeadingZeroException("Scanner cut off leading zero in barcode.");
            }
        }
        return false;
    }
}

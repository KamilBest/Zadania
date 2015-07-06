/**
 * Created by kamilbest on 01.07.15.
 */
class BarcodeChecker {

    private int barcodeLength;

    /**
     * The method checking correctness of barcode length
     *
     * @param String givenBarcode, int givenBarcodeType
     * @return boolean, true if lenghts are ok
     * @throws IllegalArgumentException
     */
    public boolean checkBarcodeLength(String givenBarcode, int givenBarcodeType) {
        barcodeLength = givenBarcode.length();

         /*
         Checking whether barcode length is correct (8 or 13 and with possible addon 2 or 5 digits)
        Correct length:
        Barcode type = 1, 8, 10 or 13
        Barcode type = 2, 13, 15 lub 18
         */
        if ((givenBarcodeType != 1) && (givenBarcodeType != 2))
            throw new IllegalArgumentException("Incorrect barrcode type! Required type 1 or 2.");
        else if ((givenBarcodeType == 1) && (barcodeLength < 8))
            throw new IllegalArgumentException("Incorrect barrcode length for type 1(EAN-8)!");
        else if ((givenBarcodeType == 2) && (barcodeLength < 13))
            throw new IllegalArgumentException("Incorrect barrcode length for type 2(EAN-13)!");
        else if ((givenBarcodeType == 1) && ((barcodeLength != 8) && (barcodeLength != 10) && (barcodeLength != 13)))
            throw new IllegalArgumentException("Incorrect barcode length for type 1(EAN-8)!");
        else if ((givenBarcodeType == 2)
                && ((barcodeLength != 13) && (barcodeLength != 15) && (barcodeLength != 18)))
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
    public boolean checkZeroTruncation(String givenBarcode) {
        final int CHECKED_LENGTHS = 5;
        barcodeLength = givenBarcode.length();
        char firstCharacter = givenBarcode.charAt(0);
        int[] truncationLengths = {7, 9, 12, 14, 17};
        for (int i = 0; i < CHECKED_LENGTHS; i++) {
            if (firstCharacter == '0') {
                if (barcodeLength == truncationLengths[i]) {
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * Created by kamilbest on 01.07.15.
 */
class BarcodeChecker {

    private int barcodeLength;

    /**
     * The method checking correctness of barcode length
     *
     * @param String givenBarcode, int givenBarcodeType
     * @return String
     * @throws IllegalArgumentException
     */
    public String checkBarcodeLength(String givenBarcode, int givenBarcodeType) {
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
            return givenBarcode;
    }

    /**
     * The method checking leading zero truncation.
     *
     * @param String
     * @return boolean
     */
    public boolean checkZeroTruncation(String givenBarcode) {
        barcodeLength = givenBarcode.length();
        char firstCharacter = givenBarcode.charAt(0);

        if ((barcodeLength == 7 && firstCharacter == '0') || (barcodeLength == 12 && firstCharacter == '0')) {
            return true;
        }
        return false;
    }
}

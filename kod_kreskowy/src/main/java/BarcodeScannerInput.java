import java.util.Scanner;

/**
 * strategy interface for input
 */
public interface BarcodeScannerInput {
    public String getBarcode();

    public int getBarcodeType();
}

/**
 * taking input from user (barcode and type)
 */
class TakeInput implements BarcodeScannerInput {
    private String barcode;
    private int barcodeType;

    /**
     * taking barcode
     *
     * @return String
     */
    public String getBarcode() {
        System.out.println("Enter barcode: ");
        Scanner code = new Scanner(System.in);
        barcode = code.nextLine();
        return barcode;
    }

    /**
     * taking type of barcode
     *
     * @return int
     */
    public int getBarcodeType() {
        System.out.println("Enter type of barcode (1-2):");
        Scanner type = new Scanner(System.in);
        barcodeType = type.nextInt();
        return barcodeType;
    }
}

/**
 * Class for testing input
 */
class TakeInputTest implements BarcodeScannerInput {
    private String barcode;
    private int barcodeType;

    /**
     * constructor, setting variables
     *
     * @param String givenBarcode
     * @param int    givenBarcodeType
     */
    public TakeInputTest(String givenBarcode, int givenBarcodeType) {
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
import java.util.Scanner;

/**
 * taking input from user (barcode and type)
 */
class UserBarcodeInput implements BarcodeInputInterface {
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
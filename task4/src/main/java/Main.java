public class Main {

    public static void main(String[] args) {
        System.out.println("Barcode analyzer.");
        BarcodeAnalyzer barcode;
        barcode = new BarcodeAnalyzer(new UserBarcodeInput(), new BarcodeChecker());
        if (barcode.analyzeBarcode(new UserBarcodeInput())) {
            System.out.print(barcode.returnCorrectBarcode(barcode.barcode, barcode.barcodeType));
            System.out.print(" - correct barcode without addon.");
        } else {
            System.out.println("Wrong barcode or type.");
        }
    }
}


public class Main {

    public static void main(String[] args) {
        BarcodeAnalyzer barcode;
        barcode = new BarcodeAnalyzer(new UserBarcodeInput(), new BarcodeChecker());
        barcode.analyzeBarcode();
    }
}


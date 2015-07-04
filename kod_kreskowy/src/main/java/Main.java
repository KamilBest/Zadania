/**
 * Created by kamilbest on 09.06.15.
 */
public class Main {

    public static void main(String[] args) {
        BarcodeAnalyzer barcode=new BarcodeAnalyzer(new TakeInput());
        barcode.run();
    }
}


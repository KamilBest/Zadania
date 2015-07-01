import java.util.Scanner;

/**
 * Klasa analizująca kody kreskowe EAN-13 lub EAN-8.
 * Wejściowy kod kreskowy: parametr tekstowy,
 * rodzaj kodu kreskowego - parametr numeryczny: 1 dla EAN-8, 2 dla EAN-13.
 * Program ma na uwadze, że: niektóre skanery kodów kreskowych mogą wycinać z kodu kreskowego
 * pierwsze wiodące zero (np. zamiast kodu 0075678164125 przesyłają 075678164125).
 * Niektóre towary (np. czasopisma) mają dodatkowe kody (tzw. add-on'y) skaner dokleja je bezpośrednio do właściwego kodu kreskowego
 * (odczytany add-on "12" oraz właściwy kod "6920702707721" przesyłany jest jako "692070270772112").
 * Add-on'y mogą występować zarówno dla kodów EAN-8 jaki i EAN-13.
 * Ewentualne błędy są sygnalizowane wyjątkami.
 * Informacje na temat kodów kreskowych: http://pl.wikipedia.org/wiki/EAN
 *
 * @author KamilBest
 */
class Barcode {
    private String barcode;
    private int barcodeType;
   // private int barcodeLength;
    private char[] barcodeToAnalyze;

    /**
     * Metoda pobierajaca kod kreskowy od uzytkownika.
     */
    private void takeBarcode() {
        System.out.println("Podaj kod kreskowy: ");
        Scanner code = new Scanner(System.in);
        barcode = code.nextLine();
    }

    /**
     * Metoda pobierajaca rodzaj kodu kreskowego od uzytkownika.
     */
    private void takeBarcodeType() {
        System.out.println("Podaj rodzaj kodu: (1-2):");
        Scanner type = new Scanner(System.in);
        barcodeType = type.nextInt();
    }



    /**
     * Dodaje wiodace zero jezeli nastapilo uciecie.
     *
     * @param String podanyKod
     * @return String
     */
    private String addLeadingZero(String givenBarcode) {
        givenBarcode = "0" + givenBarcode;
        barcodeToAnalyze = givenBarcode.toCharArray();
        return givenBarcode;
    }

    /**
     * Metoda analizujaca kod kreskowy.
     * Jezeli dane sa prawidlowe, kod zapisywany jest bez addonu do tablicy 8 lub 13 znakowej.
     *
     * @param String podanyKod, int podanyRodzajKodu
     * @return String zwraca prawidlowy kod kreskowy bez addonu
     */
    private char[] returnCorrectBarcode(BarcodeChecker barcodeCheckerObj,String givenBarcode, int givenBarcodeType) {
        if (barcodeCheckerObj.checkZeroTruncation(givenBarcode) == true)
            givenBarcode = addLeadingZero(givenBarcode);
        else
            barcodeToAnalyze = givenBarcode.toCharArray();
        barcodeCheckerObj.checkBarcodeLength(givenBarcode, givenBarcodeType);
        char[] correctBarcode = new char[13];
        System.out.println("Rodzaj kodu i kod_kreskowy są poprawne. ");
        System.out.println("Prawidlowy kod kreskowy bez addonu:");
        if (givenBarcodeType == 1)
            for (int i = 0; i < 8; i++) {
                correctBarcode[i] = barcodeToAnalyze[i];
            }
        else if (givenBarcodeType == 2)
            for (int i = 0; i < 13; i++) {
                correctBarcode[i] = barcodeToAnalyze[i];
            }

        return correctBarcode;
    }

    /**
     * Metoda uruchamiajaca sprawdzenie poprawnosci danych wejsciowych i analize kodu kreskowego.
     */
    public void run() {
        takeBarcode();
        takeBarcodeType();
        BarcodeChecker checker=new BarcodeChecker();
        System.out.println(returnCorrectBarcode(checker,barcode, barcodeType));
    }
}
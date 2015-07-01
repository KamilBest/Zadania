/**
 * Created by kamilbest on 01.07.15.
 */
class BarcodeChecker {

    private int barcodeLength;
    /**
     * Metoda sprawdzajaca dlugosc podanego kodu kreskowego.
     *
     * @param String podanyKod, int podanyRodzajKodu
     * @return String, true jezeli dlugosc jest poprawna, w przeciwnym wypadku false.
     * @throws IllegalArgumentException, wyrzucenie wyjatku w przypadkach: nieprawidlowy rodzaj lub dlugosc kodu.
     */
    public String checkBarcodeLength(String givenBarcode, int givenBarcodeType) {
        barcodeLength = givenBarcode.length();

         /*
        Sprawdzenie, czy dlugosc kodu jest poprawna ( 8 lub 13, oraz z ewentualnym addonem - 2 lub 5cyfrowym dodatkiem)
        prawidlowe dlugosci:
        rodzaj kodu=1, 8, 10 lub 13
        rodzaj kodu=2, 13, 15 lub 18
         */
        if ((givenBarcodeType != 1) && (givenBarcodeType != 2))
            throw new IllegalArgumentException("Nieprawidlowy rodzaj kodu! Wymagany rodzaj 1 lub 2.");
        else if ((givenBarcodeType == 1) && (barcodeLength < 8))
            throw new IllegalArgumentException("Nieprawidlowa dlugosc kodu dla rodzaju 1 (EAN-8)!");
        else if ((givenBarcodeType == 2) && (barcodeLength < 13))
            throw new IllegalArgumentException("Nieprawidlowa dlugosc kodu dla rodzaju 2 (EAN-13)!");
        else if ((givenBarcodeType == 1) && ((barcodeLength != 8) && (barcodeLength != 10) && (barcodeLength != 13)))
            throw new IllegalArgumentException("Nieprawidlowa dlugosc kodu dla rodzaju 1 (EAN-8)!");
        else if ((givenBarcodeType == 2)
                && ((barcodeLength != 13) && (barcodeLength != 15) && (barcodeLength != 18)))
            throw new IllegalArgumentException("Nieprawidlowa dlugosc kodu dla rodzaju 2 (EAN-13)!");
        else
            return givenBarcode;
    }

    /**
     * Metoda sprawdzajaca dane wejsciowe.
     * Obsluga przypadku uciecia wiodacego zera przez skaner.
     *
     * @param String
     * @return boolean true jezeli dane poprawne, false jezeli nie
     */
    public boolean checkZeroTruncation(String givenBarcode) {
        barcodeLength = givenBarcode.length();

           /*
        Sprawdzenie, czy skaner nie wycial z podanego kodu kreskowego wiodacego zera.
         */
        char pierwszyZnak = givenBarcode.charAt(0);

        if ((barcodeLength == 7 && pierwszyZnak == '0') || (barcodeLength == 12 && pierwszyZnak == '0')) {
            return true;
        }
        return false;
    }
}

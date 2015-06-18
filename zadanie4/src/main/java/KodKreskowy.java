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
class KodKreskowy {
    private String podanyKod;
    private int rodzajKodu;
    private int dlugoscKodu;
    private char[] kodDoAnalizy;

    /**
     * Metoda pobierajaca dane od uzytkownika.
     */
    private void pobierz_dane() {
        System.out.println("Podaj rodzaj kodu: (1-2):");
        Scanner rodzaj = new Scanner(System.in);
        rodzajKodu = rodzaj.nextInt();
        System.out.println("Podaj kod kreskowy do sprawdzenia jego poprawnosci: ");
        Scanner kod = new Scanner(System.in);
        podanyKod = kod.nextLine();
    }

    /**
     * Metoda sprawdzajaca dlugosc podanego kodu kreskowego.
     *
     * @return boolean, true jezeli dlugosc jest poprawna, w przeciwnym wypadku false.
     */
    private boolean sprawdzDlugoscKodu() {
         /*
        Sprawdzenie, czy dlugosc kodu jest poprawna ( 8 lub 13, oraz z ewentualnym addonem - 2 lub 5cyfrowym dodatkiem)
        prawidlowe dlugosci:
        rodzaj kodu=1, 8, 10 lub 13
        rodzaj kodu=2, 13, 15 lub 18
         */
        if ((rodzajKodu < 1) || (rodzajKodu > 2))
            return false;
        else if ((rodzajKodu == 1) && (dlugoscKodu < 8))
            return false;
        else if ((rodzajKodu == 2) && (dlugoscKodu < 13))
            return false;
        else if ((rodzajKodu == 1)
                && ((dlugoscKodu == 8) || (dlugoscKodu == 10) || (dlugoscKodu == 13)))
            return true;
        else if ((rodzajKodu == 2)
                && ((dlugoscKodu == 13) || (dlugoscKodu == 15) || (dlugoscKodu == 18)))
            return true;
        else
            return false;
    }

    /**
     * Metoda sprawdzajaca dane wejsciowe, sprawdzenie, czy kod sklada sie z samych cyfr,
     *
     * @return boolean true jezeli dane poprawne, false jezeli nie
     */
    private boolean sprawdzDaneWejsciowe() {
        dlugoscKodu = podanyKod.length();
           /*
        Sprawdzenie, czy skaner nie wycial z podanego kodu kreskowego wiodacego zera.
         */
        char pierwszyZnak = podanyKod.charAt(0);

        if ((dlugoscKodu == 7 && pierwszyZnak == '0') || (dlugoscKodu == 12 && pierwszyZnak == '0')) {
            podanyKod = "0" + podanyKod;
            kodDoAnalizy = podanyKod.toCharArray();

        /*
        Sprawdzenie, czy kazdy znak podanego kodu jest cyfra.
         */
            for (int i = 0; i < dlugoscKodu; i++) {
                if (!Character.isDigit(kodDoAnalizy[i])) {
                    System.out.println("Kazdy znak w kodzie musi byc cyfra.");
                    return false;
                }
            }
            return true;
        } else if (sprawdzDlugoscKodu())
            return true;

        return false;
    }

    /**
     * Metoda analizujaca kod kreskowy.
     * Jezeli dane sa prawidlowe, kod zapisywany jest bez addonu do tablicy 8 lub 13 znakowej.
     *
     * @return String zwraca prawidlowy kod kreskowy bez addonu
     */
    private String analizujKod() {
        char[] poprawnyKodKreskowy = new char[13];
        String poprawnyKod = "";
        if (sprawdzDaneWejsciowe()) {
            System.out.println("Rodzaj kodu i kod_kreskowy są poprawne. ");
            System.out.println("Prawidlowy kod kreskowy bez addonu:");
            if (rodzajKodu == 1)
                for (int i = 0; i < 8; i++) {
                    poprawnyKodKreskowy[i] = kodDoAnalizy[i];
                    poprawnyKod += poprawnyKodKreskowy[i];
                }
            else if (rodzajKodu == 2)
                for (int i = 0; i < 13; i++) {
                    poprawnyKodKreskowy[i] = kodDoAnalizy[i];
                    poprawnyKod += poprawnyKodKreskowy[i];
                }
        } else {
            System.out.println("Zly rodzaj kodu lub kod kreskowy. ");
        }
        return poprawnyKod;
    }

    /**
     * Metoda uruchamiajaca sprawdzenie poprawnosci danych wejsciowych i analize kodu kreskowego.
     */
    public void uruchom() {
        pobierz_dane();
        if (sprawdzDaneWejsciowe() == false)
            System.out.println("Niepoprawne dane!");
        System.out.println(analizujKod());
    }
}

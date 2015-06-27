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
    private String kodKreskowy;
    private int rodzajKodu;
    private int dlugoscKodu;
    private char[] kodDoAnalizy;

    /**
     * Metoda pobierajaca kod kreskowy od uzytkownika.
     */
    private void pobierzKod() {
        System.out.println("Podaj kod kreskowy: ");
        Scanner kod = new Scanner(System.in);
        kodKreskowy = kod.nextLine();
    }

    /**
     * Metoda pobierajaca rodzaj kodu kreskowego od uzytkownika.
     */
    private void pobierzRodzajKodu() {
        System.out.println("Podaj rodzaj kodu: (1-2):");
        Scanner rodzaj = new Scanner(System.in);
        rodzajKodu = rodzaj.nextInt();
    }

    /**
     * Metoda sprawdzajaca dlugosc podanego kodu kreskowego.
     *
     * @param String podanyKod, int podanyRodzajKodu
     * @return String, true jezeli dlugosc jest poprawna, w przeciwnym wypadku false.
     * @throws IllegalArgumentException, wyrzucenie wyjatku w przypadkach: nieprawidlowy rodzaj lub dlugosc kodu.
     */
    public String sprawdzDlugoscKodu(String podanyKod, int podanyRodzajKodu) {
        dlugoscKodu = podanyKod.length();

         /*
        Sprawdzenie, czy dlugosc kodu jest poprawna ( 8 lub 13, oraz z ewentualnym addonem - 2 lub 5cyfrowym dodatkiem)
        prawidlowe dlugosci:
        rodzaj kodu=1, 8, 10 lub 13
        rodzaj kodu=2, 13, 15 lub 18
         */
        if ((podanyRodzajKodu != 1) && (podanyRodzajKodu != 2))
            throw new IllegalArgumentException("Nieprawidlowy rodzaj kodu! Wymagany rodzaj 1 lub 2.");
        else if ((podanyRodzajKodu == 1) && (dlugoscKodu < 8))
            throw new IllegalArgumentException("Nieprawidlowa dlugosc kodu dla rodzaju 1 (EAN-8)!");
        else if ((podanyRodzajKodu == 2) && (dlugoscKodu < 13))
            throw new IllegalArgumentException("Nieprawidlowa dlugosc kodu dla rodzaju 2 (EAN-13)!");
        else if ((podanyRodzajKodu == 1) && ((dlugoscKodu != 8) && (dlugoscKodu != 10) && (dlugoscKodu != 13)))
            throw new IllegalArgumentException("Nieprawidlowa dlugosc kodu dla rodzaju 1 (EAN-8)!");
        else if ((podanyRodzajKodu == 2)
                && ((dlugoscKodu != 13) && (dlugoscKodu != 15) && (dlugoscKodu != 18)))
            throw new IllegalArgumentException("Nieprawidlowa dlugosc kodu dla rodzaju 2 (EAN-13)!");
        else
            return podanyKod;
    }

    /**
     * Metoda sprawdzajaca dane wejsciowe.
     * Obsluga przypadku uciecia wiodacego zera przez skaner.
     *
     * @param String
     * @return boolean true jezeli dane poprawne, false jezeli nie
     */
    public boolean sprawdzUciecieZera(String podanyKod) {
        dlugoscKodu = podanyKod.length();

           /*
        Sprawdzenie, czy skaner nie wycial z podanego kodu kreskowego wiodacego zera.
         */
        char pierwszyZnak = podanyKod.charAt(0);

        if ((dlugoscKodu == 7 && pierwszyZnak == '0') || (dlugoscKodu == 12 && pierwszyZnak == '0')) {
            return true;
        }
        return false;
    }

    /**
     * Dodaje wiodace zero jezeli nastapilo uciecie.
     *
     * @param String podanyKod
     * @return String
     */
    private String dodajWiodaceZero(String podanyKod) {
        podanyKod = "0" + podanyKod;
        kodDoAnalizy = podanyKod.toCharArray();
        return podanyKod;
    }

    /**
     * Metoda analizujaca kod kreskowy.
     * Jezeli dane sa prawidlowe, kod zapisywany jest bez addonu do tablicy 8 lub 13 znakowej.
     *
     * @param String podanyKod, int podanyRodzajKodu
     * @return String zwraca prawidlowy kod kreskowy bez addonu
     */
    public String zwrocPoprawnyKod(String podanyKod, int podanyRodzajKodu) {
        if (sprawdzUciecieZera(podanyKod) == true)
            podanyKod = dodajWiodaceZero(podanyKod);
        else
            kodDoAnalizy = podanyKod.toCharArray();
        sprawdzDlugoscKodu(podanyKod, podanyRodzajKodu);
        char[] poprawnyKodKreskowy = new char[13];
        String poprawnyKod = "";
        System.out.println("Rodzaj kodu i kod_kreskowy są poprawne. ");
        System.out.println("Prawidlowy kod kreskowy bez addonu:");
        if (podanyRodzajKodu == 1)
            for (int i = 0; i < 8; i++) {
                poprawnyKodKreskowy[i] = kodDoAnalizy[i];
                poprawnyKod += poprawnyKodKreskowy[i];
            }
        else if (podanyRodzajKodu == 2)
            for (int i = 0; i < 13; i++) {
                poprawnyKodKreskowy[i] = kodDoAnalizy[i];
                poprawnyKod += poprawnyKodKreskowy[i];
            }
        System.out.println(poprawnyKod);
        return poprawnyKod;
    }

    /**
     * Metoda uruchamiajaca sprawdzenie poprawnosci danych wejsciowych i analize kodu kreskowego.
     */
    public void uruchom() {
        pobierzKod();
        pobierzRodzajKodu();
        System.out.println(zwrocPoprawnyKod(kodKreskowy, rodzajKodu));
    }
}
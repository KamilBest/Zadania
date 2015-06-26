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
    private String pobierzKod() {
        System.out.println("Podaj kod kreskowy: ");
        Scanner kod = new Scanner(System.in);
        kodKreskowy = kod.nextLine();
        return kodKreskowy;
    }

    /**
     * Metoda pobierajaca rodzaj kodu kreskowego od uzytkownika.
     */
    private int pobierzRodzajKodu()
    {
        System.out.println("Podaj rodzaj kodu: (1-2):");
        Scanner rodzaj = new Scanner(System.in);
        rodzajKodu = rodzaj.nextInt();
        return rodzajKodu;
    }

    /**
     * Metoda sprawdzajaca dlugosc podanego kodu kreskowego.
     *
     * @return boolean, true jezeli dlugosc jest poprawna, w przeciwnym wypadku false.
     * @throws IllegalArgumentException, wyrzucenie wyjatku w przypadkach: nieprawidlowy rodzaj lub dlugosc kodu.
     */
    public boolean sprawdzDlugoscKodu(String podanyKod, int podanyRodzajKodu){
        dlugoscKodu = podanyKod.length();

         /*
        Sprawdzenie, czy dlugosc kodu jest poprawna ( 8 lub 13, oraz z ewentualnym addonem - 2 lub 5cyfrowym dodatkiem)
        prawidlowe dlugosci:
        rodzaj kodu=1, 8, 10 lub 13
        rodzaj kodu=2, 13, 15 lub 18
         */
        if (( podanyRodzajKodu < 1) || ( podanyRodzajKodu > 2))
            throw new IllegalArgumentException("Nieprawidlowy rodzaj kodu! Wymagany rodzaj 1 lub 2.");
        else if (( podanyRodzajKodu == 1) && (dlugoscKodu < 8))
            throw new IllegalArgumentException("Nieprawidlowa dlugosc kodu dla rodzaju 1 (EAN-8)!");
        else if (( podanyRodzajKodu == 2) && (dlugoscKodu < 13))
            throw new IllegalArgumentException("Nieprawidlowa dlugosc kodu dla rodzaju 2 (EAN-13)!");
        else if (( podanyRodzajKodu == 1) && ((dlugoscKodu == 8) || (dlugoscKodu == 10) || (dlugoscKodu == 13)))
            return true;
        else if (( podanyRodzajKodu == 2)
                && ((dlugoscKodu == 13) || (dlugoscKodu == 15) || (dlugoscKodu == 18)))
            return true;
        else
            return false;
    }

    /**
     * Metoda sprawdzajaca dane wejsciowe.
     * Obsluga przypadku uciecia wiodacego zera przez skaner.
     *
     * @return boolean true jezeli dane poprawne, false jezeli nie
     */
    private boolean sprawdzDaneWejsciowe(){
        kodDoAnalizy = kodKreskowy.toCharArray();

           /*
        Sprawdzenie, czy skaner nie wycial z podanego kodu kreskowego wiodacego zera.
         */
        char pierwszyZnak = kodKreskowy.charAt(0);

        if ((dlugoscKodu == 7 && pierwszyZnak == '0') || (dlugoscKodu == 12 && pierwszyZnak == '0')) {
            kodKreskowy = "0" + kodKreskowy;
            kodDoAnalizy = kodKreskowy.toCharArray();
            return true;
        } else if(sprawdzDlugoscKodu(kodKreskowy,rodzajKodu))
            return true;
        return false;
    }

    /**
     * Metoda analizujaca kod kreskowy.
     * Jezeli dane sa prawidlowe, kod zapisywany jest bez addonu do tablicy 8 lub 13 znakowej.
     *
     * @return String zwraca prawidlowy kod kreskowy bez addonu
     */
    private String analizujKod(){
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
        }
        return poprawnyKod;
    }

    /**
     * Metoda uruchamiajaca sprawdzenie poprawnosci danych wejsciowych i analize kodu kreskowego.
     */
    public void uruchom() {
        if (sprawdzDaneWejsciowe() == false)
            System.out.println("Niepoprawne dane!");
        System.out.println(analizujKod());
    }
}
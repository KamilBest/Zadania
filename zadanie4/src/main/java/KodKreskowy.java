import java.util.Scanner;

/**
 * Klasa analizująca kody kreskowe EAN-13 lub EAN-8.
 * Wejściowy kod kreskowy: parametr tekstowy,
 * rodzaj kodu kreskowego - parametr numeryczny: 1 dla EAN-8, 2 dla EAN-13.
 *
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
    private String kodDoAnalizy;
    private int rodzajKodu;
    private  char[] kodDoAnalizyCharTablica;

    /**
     * Metoda pobierajaca dane od uzytkownika.
     *
     */
    private void pobierz_dane() {
        System.out.println("Podaj rodzaj kodu: (1-2):");
        Scanner rodzaj = new Scanner(System.in);
        rodzajKodu = rodzaj.nextInt();
        System.out.println("Podaj kod kreskowy do sprawdzenia jego poprawnosci: ");
        Scanner kod = new Scanner(System.in);
        kodDoAnalizy = kod.nextLine();
    }
    /**
     * Metoda sprawdzajaca dane wejsciowe, sprawdzenie, czy kod sklada sie z samych cyfr,
     * czy rodzaj kodu jest rowny 1 lub 2, oraz czy kod posiada prawidlowa ilosc znakow.
     *
     *@return boolean true jezeli dane poprawne, false jezeli nie
     */
    private boolean sprawdzDaneWejsciowe(){
        int dlugoscKodu = kodDoAnalizy.length();
        kodDoAnalizyCharTablica=kodDoAnalizy.toCharArray();
        for (int i = 0; i < dlugoscKodu; i++) {
            if (Character.isDigit(kodDoAnalizyCharTablica[i]))
                return true;
            else {
                System.out.println("Kazdy znak w kodzie musi byc cyfra.");
                return false;
            }
        }
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
     * Metoda analizujaca kod kreskowy.
     * Jezeli dane sa prawidlowe, kod zapisywany jest bez addonu do tablicy 8 lub 13 znakowej.
     *
     * @return String zwraca prawidlowy kod kreskowy bez addonu
     */
    private String analizujKod() {
        char[] poprawnyKodKreskowy=new char[13];
        String poprawnyKod=null;

        if (sprawdzDaneWejsciowe()) {
            System.out.println("Rodzaj kodu i kod_kreskowy są poprawne. ");
            if (rodzajKodu == 1)
                for (int i = 0; i < 8; i++) {
                    poprawnyKodKreskowy[i] = kodDoAnalizyCharTablica[i];
                    poprawnyKod+=poprawnyKodKreskowy[i];
                }

            else if (rodzajKodu == 2)
                for (int i = 0; i < 13; i++) {
                    poprawnyKodKreskowy[i] = kodDoAnalizyCharTablica[i];
                    poprawnyKod+=poprawnyKodKreskowy[i];

                }

        } else {
            System.out.println("Zly rodzaj kodu lub kod kreskowy. ");
        }
        return poprawnyKod;
    }

    /**
     * Metoda uruchamia sprawdzenie poprawnosci i analize kodu kreskowego.
     */
    public void uruchom()
    {
        pobierz_dane();
        if(sprawdzDaneWejsciowe()==false)
            System.out.println("Niepoprawne dane!");
        System.out.println(analizujKod());
    }
}

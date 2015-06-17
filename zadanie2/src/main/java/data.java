import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Scanner;

/**
 * Program sprawdza poprawnosc daty podanej przez uzytkownika.
 * Daty spoza przedzialu <2001-2099> sa uznawane za niepoprawne.
 *
 * @author Kamil Best
 */
class Data {
    final String DATE_FORMAT = "dd-MM-yyyy";
    private String data;
    private String rok;
    private int rokLiczba;

    /**
     * Metoda pobierająca date od uzytkownika (data w formacie dd-mm-rrrr )
     * zmienna rok przechowuje 4 koncowe znaki typu char odpowiedzialne za rok, w zmiennej rokLiczba znaki zostaja zamienione na liczby
     */
    private void pobierzDate() {
        System.out.println("Podaj date do sprawdzenia, prawidlowy format: dd-mm-rrrr -> (dzien-miesiac-rok):");
        System.out.println("Daty spoza okresu (2001-2099) sa niepoprawne:");
        Scanner d = new Scanner(System.in);
        data = d.nextLine();
        rok = data.substring(6, 10);
        rokLiczba = Integer.parseInt(rok);

    }

    /**
     * Metoda sprawdza czy rok nalezy do przedzialu <2001,2099>
     *
     * @return boolean ( true jezeli nalezy, false jezeli nie nalezy)
     */
    private boolean czyPoprawnyRok() {
        if (rokLiczba < 2001 || rokLiczba > 2099)
            return false;
        return true;
    }

    /**
     * Metoda sprawdzajaca prawidlowosc daty
     *
     * @return boolean (true jezeli prawidlowa, false jezeli nieprawidlowa)
     * @throws jezeli dane nieprawidlowe
     */
    private boolean czyPrawidlowaData() {
        try {
            if (!czyPoprawnyRok()) {
                System.out.println(data + " jest niepoprawna!");
                return false;
            }
            DateFormat formatDaty = new SimpleDateFormat(DATE_FORMAT);
            formatDaty.setLenient(false);
            formatDaty.parse(data);
            System.out.println("Data: " + data + " jest prawidlowa.");
            return true;
        } catch (ParseException e) {
            System.out.println("Data: " + data + " jest niepoprawna!");
            return false;
        }
    }

    /**
     * uruchom sprawdzenie daty
     */
    public void sprawdzDate() {
        pobierzDate();
        czyPrawidlowaData();
    }
}
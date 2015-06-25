import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Scanner;

public class Zadanie2 {
    public static void main(String[] args) {
        Data data = new Data();
        data.uruchomSprawdzanie();
    }
}

/**
 * Program sprawdza poprawnosc daty podanej przez uzytkownika.
 * Daty spoza przedzialu <2001-2099> sa uznawane za niepoprawne.
 *
 * @author Kamil Best
 */
class Data {
    final String FORMAT_DATY = "dd-MM-yyyy";
    private String data;
    private String rok;
    private int rokLiczba;

    /**
     * Metoda pobierająca date od uzytkownika (data w formacie dd-mm-rrrr )
     * zmienna rok przechowuje 4 koncowe znaki typu char odpowiedzialne za rok, w zmiennej rokLiczba znaki zostaja zamienione na liczby
     */
    private void pobierzDate() {
        System.out.println("Podaj date do sprawdzenia, prawidlowy format: dd-mm-rrrr -> (dzien-miesiac-rok):");
        System.out.println("Daty spoza lat (2001-2099) sa niepoprawne:");
        Scanner d = new Scanner(System.in);
        data = d.nextLine();
    }

    /**
     * Metoda sprawdzajaca format daty oraz czy rok w dacie nalezy do przedzialu <2001, 2099>
     *
     * @throws IllegalArgumentException
     * @throws ParseException
     */
    private void sprawdzDate() {
        try {
            DateFormat formatDaty = new SimpleDateFormat(FORMAT_DATY);
            formatDaty.setLenient(false);
            formatDaty.parse(data);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Zly format daty");
        }
        rok = data.substring(6, 10);
        rokLiczba = Integer.parseInt(rok);
        if (rokLiczba < 2001 || rokLiczba > 2099) {
            throw new IllegalArgumentException("zly rok");
        }
        System.out.println("Data: " + data + " jest prawidlowa.");
    }

    /**
     * Metoda analizujaca prawidlowosc daty, prosi o podanie daty az bedzie prawidlowa.
     *
     * @throws IllegalArgumentException
     */
    private void analizujDate() {
        while (true) {
            pobierzDate();
            try {
                sprawdzDate();
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println("Nieprawidlowa data, podaj jeszcze raz.");
            }
        }
    }

    /**
     * uruchomienie sprawdzania
     */
    public void uruchomSprawdzanie() {
        analizujDate();
    }
}
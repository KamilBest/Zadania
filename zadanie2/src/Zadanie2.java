import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Scanner;

public class Zadanie2 {
    public static void main(String[] args) {
        Data data = new Data();
        data.sprawdzDate();
    }
}

/**
 * @author Kamil Best
 * @since 08.06.2015
 * <p/>
 * Program sprawdza poprawnosc daty podanej przez uzytkownika.
 * Daty spoza przedzialu <2001-2099> sa uznawane za niepoprawne.
 */
class Data {
    final String DATE_FORMAT = "dd-MM-yyyy";
    private String data;
    private String rok;
    private int rokLiczba;

    private void pobierzDate() {
        System.out.println("Podaj date do sprawdzenia, prawidlowy format: dd-MM-yyyy -> (dzien-miesiac-rok):");
        System.out.println("Daty spoza okresu (2001-2099) sa niepoprawne:");
        Scanner d = new Scanner(System.in);
        data = d.nextLine();
        rok = data.substring(6, 10);
        rokLiczba = Integer.parseInt(rok);

    }

    private boolean czyPoprawnyRok() {
        if (rokLiczba < 2001 || rokLiczba > 2099)
            return false;
        return true;
    }

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

    public void sprawdzDate() {
        pobierzDate();
        czyPrawidlowaData();
    }
}

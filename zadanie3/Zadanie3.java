/**
 * Created by kamilbest on 08.06.15.
 */

import java.util.Scanner;
import java.lang.Exception;

public class Zadanie3 {

    public static void main(String[] args) {
        graWKosci gra = new graWKosci();
        gra.start();
    }
}

/**
 * W grze w kości bierze udział dwóch graczy o nazwach: pierwszy, drugi. Każdemu graczowi przypada 5
 * tur, w każdej turze, gracz wykonuje maksymalnie 10 rzutów dwoma kośćmi jednocześnie. Tury graczy
 * odbywają się naprzemiennie tzn. grę zaczyna gracz pierwszy, po turze następuje tura gracza
 * drugiego, następna jest tura gracza pierwszego itd. Możliwe wyniki rzutu jedna kością to jedna z
 * następujących cyfr {1, 2, 3, 4, 5, 6}. Grę zawsze rozpoczyna gracz ”pierwszy”. Podczas każdej tury
 * gracz zbiera punkty według zasad opisanych poniżej. Suma punktów każdego gracza przed
 * rozpoczęciem gry wynosi zero. Wygrywa gracz, który zbierze mniejsza ilość punktów.
 *
 * @author Kamil Best
 */
class graWKosci {
    private static final int rzutMin = 1;
    private static final int rzutMax = 6;
    private static final int iloscTur = 5;

    /**
     * Sprawdzenie poprawnosci danych wejsciowych.
     * Wyrzucenie wyjatku w przypadku blednych danych.
     *
     * @param rzut - ilosc oczek wyrzuconych na jednej kostce (1-6)
     * @throws Exception - wyjatek w przypadku podania jako argument liczby spoza zakresu (1-6)
     */

    private void sprawdzPoprawnoscRzutu(int rzut) throws Exception {
        if (rzut < rzutMin || rzut > rzutMax)
            throw new Exception("Bledne dane, mozesz uzyc liczb z przedzialu 1-6");
    }

    /**
     * Obsluga tury aktualnego gracza.
     *
     * @param g - obiekt Klasy Gracz zawierajacy imie gracza
     * @return suma_pkt - zwraca ilosc uzyskanych przez gracza punktow w danej turze
     */
    private int tura(Gracz g) {
        int numer_rzutu = 1;
        int pierwsza_kostka, druga_kostka;
        int suma_oczek = 0, suma_pkt = 0;
        Scanner rzut = new Scanner(System.in);
        while (numer_rzutu <= 10) {
            System.out.println("\nGraczu " + g.zwrocImie() + " podaj ilosc oczek w pierwszej kostce (1-6):");
            pierwsza_kostka = rzut.nextInt();
            System.out.println("\nGraczu " + g.zwrocImie() + " podaj ilosc oczek w drugiej kostce (1-6):");
            druga_kostka = rzut.nextInt();
            try {
                sprawdzPoprawnoscRzutu(pierwsza_kostka);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("\nNieprawidlowy rzut graczu " + g.zwrocImie() + " podaj ilosc oczek w pierwszej kostce jeszcze raz(1-6):");
                pierwsza_kostka = rzut.nextInt();
            }
            try {
                sprawdzPoprawnoscRzutu(druga_kostka);

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("\nNieprawidlowy rzut graczu " + g.zwrocImie() + " podaj ilosc oczek w drugiej kostce jeszcze raz(1-6):");
                druga_kostka = rzut.nextInt();
            }

            suma_oczek = pierwsza_kostka + druga_kostka;
            System.out.println("Gracz " + g.zwrocImie() + " wykonal " + numer_rzutu + " rzut: " + pierwsza_kostka + " " + druga_kostka);
            System.out.println("Suma oczek na obu kostkach w tym rzucie: " + suma_oczek);

            if (((numer_rzutu == 1) && (suma_oczek == 7)) || (suma_oczek == 11)) {
                System.out.println("Gracz " + g.zwrocImie() + "wygral ture.");
                break;
            } else if (((numer_rzutu == 1) && (suma_oczek == 2)) || (suma_oczek == 12)) {
                System.out.println("Gracz " + g.zwrocImie() + " przegral ture.");
                suma_pkt += numer_rzutu;
                break;
            } else if (suma_oczek == 5) {
                System.out.println("Gracz " + g.zwrocImie() + " wygral ture.");
                break;
            } else {
                suma_pkt += suma_oczek / numer_rzutu;
            }
            numer_rzutu++;
        }
        return suma_pkt;
    }

    /**
     * Glowna metoda gry.
     * Odpowiada za przebieg gry.
     */
    public void start() {
        Gracz gracz1 = new Gracz("pierwszy");
        Gracz gracz2 = new Gracz("drugi");
        String aktualny_gracz = gracz1.zwrocImie(); //zaczyna gracz pierwszy
        int suma_pkt_g1 = 0, suma_pkt_g2 = 0;
        int numer_tury = 1;
        while (numer_tury <= iloscTur) {
            System.out.println("\nTura: " + numer_tury);
            suma_pkt_g1 += tura(gracz1);
            suma_pkt_g2 += tura(gracz2);
            System.out.println("\nPODSUMOWANIE - wyniki: ");
            System.out.println("Gracz " + gracz1.zwrocImie() + " ma : " + suma_pkt_g1 + "pkt.");
            System.out.println("Gracz " + gracz2.zwrocImie() + " ma : " + suma_pkt_g2 + "pkt.");
            numer_tury++;
        }

        System.out.println("\nWyniki koncowe: ");
        System.out.println("Suma pkt gracza pierwszego: " + suma_pkt_g1 + ".");
        System.out.println("Suma pkt gracza drugiego: " + suma_pkt_g2 + ".");

        if (suma_pkt_g1 < suma_pkt_g2)
            System.out.println("Gracz pierwszy wygral!");
        else if (suma_pkt_g1 == suma_pkt_g2)
            System.out.println("Remis!");
        else
            System.out.println("Gracz drugi wygral!");
    }
}

/**
 * Klasa gracza przechowujaca imie gracza oraz ilosc punktow
 *
 * @author Kamil Best
 */
class Gracz {
    private String imieGracza;

    Gracz(String imie) {
        imieGracza = imie;
    }

    public String zwrocImie() {
        return imieGracza;
    }
}
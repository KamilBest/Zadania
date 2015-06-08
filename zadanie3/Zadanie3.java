/**
 * Created by kamilbest on 08.06.15.
 */

import java.util.Scanner;

public class Zadanie3 {

    public static void main(String[] args) {
    graWKosci gra=new graWKosci();
        gra.start();
    }
}

class graWKosci {
    private boolean prawidlowy_rzut(int pierwszy) {
        if (pierwszy >= 1 && pierwszy <= 6)
            return true;
        else
            System.out.println("Bledne dane, mozesz uzyc liczb z przedzialu 1-6");
        return false;
    }

    private int gra(String nazwa_gracza) {
        int numer_rzutu = 1;
        int pierwsza_kostka, druga_kostka;
        int suma_oczek = 0, suma_pkt = 0;
        Scanner rzut = new Scanner(System.in);
        while (numer_rzutu <= 10) {
            do {
                System.out.println("\nGraczu " + nazwa_gracza + " podaj ilosc oczek w pierwszej kostce (1-6):");
                pierwsza_kostka = rzut.nextInt();
            } while (!prawidlowy_rzut(pierwsza_kostka));
            do {
                System.out.println("\nGraczu " + nazwa_gracza + " podaj ilosc oczek w drugiej kostce (1-6):");
                druga_kostka = rzut.nextInt();
            } while (!prawidlowy_rzut(druga_kostka));
            suma_oczek = pierwsza_kostka + druga_kostka;
            System.out.println("Gracz " + nazwa_gracza + " wykonal " + numer_rzutu + " rzut");
            System.out.println("Suma oczek na obu kostkach w tym rzucie: " + suma_oczek);

            if (((numer_rzutu == 1) && (suma_oczek == 7)) || (suma_oczek == 11)) {
                System.out.println("Gracz " + nazwa_gracza + "wygral ture.");
                break;
            } else if (((numer_rzutu == 1) && (suma_oczek == 2)) || (suma_oczek == 12)) {
                System.out.println("Gracz " + nazwa_gracza + " przegral ture.");
                suma_pkt += numer_rzutu;
                break;
            } else if (suma_oczek == 5) {
                System.out.println("Gracz " + nazwa_gracza + " wygral ture.");
                break;
            } else {
                suma_pkt += suma_oczek / numer_rzutu;
            }
            numer_rzutu++;
        }
        return suma_pkt;
    }

    public void start() {
        Gracz gracz1=new Gracz("pierwszy");
        Gracz gracz2=new Gracz("drugi");
        String aktualny_gracz = gracz1.zwrocImie(); //zaczyna gracz pierwszy
        int suma_pkt_g1 = 0, suma_pkt_g2 = 0;


        int numer_tury = 1;
        while (numer_tury <= 5) {
            System.out.println("\nTura: " + numer_tury);
            suma_pkt_g1 += gra(gracz1.zwrocImie());
            suma_pkt_g2 += gra(gracz2.zwrocImie());
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

class Gracz{
    private String nazwaGracza;
    Gracz(String nazwa)
    {
        nazwaGracza = nazwa;
    }
    String zwrocImie()
    {
        return nazwaGracza;
    }
}

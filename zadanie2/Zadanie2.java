/**
 * Created by kamilbest on 08.06.15.
 */

import java.util.Scanner;

public class Zadanie2 {
    public static void main(String[] args) {
        poprawnoscDaty data = new poprawnoscDaty();
        data.sprawdzDate();
    }
}

class poprawnoscDaty {
    private int dzien;
    private int miesiac;
    private int rok;

    private void pobierzDate() {
        System.out.println("Podaj date do sprawdzenia (dzien, miesiac, rok):");
        System.out.println("Daty spoza okresu (2001-2099) sa niepoprawne:");
        System.out.println("Podaj dzien:");
        Scanner data = new Scanner(System.in);
        dzien = data.nextInt();
        System.out.println("Podaj miesiac:");
        miesiac = data.nextInt();
        System.out.println("Podaj rok:");
        rok = data.nextInt();
    }

    private boolean czyDataJestPoprawna() {
        boolean czy_przestepny = false;
        /*
        ilosc dni w miesiacach : 31,28-29,31,30,31,30,31,31,30,31,30,31
         */
        if ((rok < 2001) || (rok > 2099))
            return false;
        switch (miesiac) {
            case 1:
                if ((dzien < 1) || (dzien > 31))
                    return false;
                break;
            case 2:
                //sprawdzenie, czy rok jest przestepny
                if (((rok % 4 == 0) && (rok % 100 != 0)) || (rok % 400 == 0))
                    czy_przestepny = true;
                if (czy_przestepny) {
                    if ((dzien < 1) || (dzien > 29))
                        return false;
                } else if (!czy_przestepny) {
                    if ((dzien < 1) || (dzien > 28))
                        return false;
                }
                break;
            case 3:
                if ((dzien < 1) || (dzien > 31))
                    return false;
                break;
            case 4:
                if ((dzien < 1) || (dzien > 30))
                    return false;
                break;
            case 5:
                if ((dzien < 1) || (dzien > 31))
                    return false;
                break;
            case 6:
                if ((dzien < 1) || (dzien > 30))
                    return false;
                break;
            case 7:
                if ((dzien < 1) || (dzien > 31))
                    return false;
                break;
            case 8:
                if ((dzien < 1) || (dzien > 31))
                    return false;
                break;
            case 9:
                if ((dzien < 1) || (dzien > 30))
                    return false;
                break;
            case 10:
                if ((dzien < 1) || (dzien > 31))
                    return false;
                break;
            case 11:
                if ((dzien < 1) || (dzien > 30))
                    return false;
                break;
            case 12:
                if ((dzien < 1) || (dzien > 31))
                    return false;
                break;
            default:
                return false;
        }
        return true;
    }

    public void sprawdzDate() {
        pobierzDate();
        if (czyDataJestPoprawna())
            System.out.println("Data jest poprawna.");
        else
            System.out.println("Data jest niepoprawna.");
    }
}
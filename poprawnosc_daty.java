/**
 * Created by kamilbest on 06.06.15.
 */

import java.util.Scanner;

public class poprawnosc_daty {
    public static boolean czy_data_jest_poprawna(int i_dzien, int i_miesiac, int i_rok) {
        boolean czy_przestepny=false;
//ilosc dni w miesiacach : 31,28-29,31,30,31,30,31,31,30,31,30,31
        if ((i_rok < 2001) || (i_rok > 2099)) {
            return false;
        } else {
            switch (i_miesiac) {
                case 1:
                    if ((i_dzien < 1) || (i_dzien > 31))
                        return false;
                    break;
                case 2:
                    //sprawdzenie, czy i_rok jest przestepny
                    if (((i_rok % 4 == 0) && (i_rok % 100 != 0)) || (i_rok % 400 == 0))
                        czy_przestepny = true;

                    if (czy_przestepny) {
                        if ((i_dzien < 1) || (i_dzien > 29))
                            return false;
                    } else if (!czy_przestepny) {
                        if ((i_dzien < 1) || (i_dzien > 28))
                            return false;
                    }
                    break;
                case 3:
                    if ((i_dzien < 1) || (i_dzien > 31))
                        return false;
                    break;
                case 4:
                    if ((i_dzien < 1) || (i_dzien > 30))
                        return false;
                    break;
                case 5:
                    if ((i_dzien < 1) || (i_dzien > 31))
                        return false;
                    break;
                case 6:
                    if ((i_dzien < 1) || (i_dzien > 30))
                        return false;
                    break;
                case 7:
                    if ((i_dzien < 1) || (i_dzien > 31))
                        return false;
                    break;
                case 8:
                    if ((i_dzien < 1) || (i_dzien > 31))
                        return false;
                    break;
                case 9:
                    if ((i_dzien < 1) || (i_dzien > 30))
                        return false;
                    break;
                case 10:
                    if ((i_dzien < 1) || (i_dzien > 31))
                        return false;
                    break;
                case 11:
                    if ((i_dzien < 1) || (i_dzien > 30))
                        return false;
                    break;
                case 12:
                    if ((i_dzien < 1) || (i_dzien > 31))
                        return false;
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int dzien;
        int miesiac;
        int rok;
        System.out.println("Podaj date do sprawdzenia (dzien, miesiac, rok):");
        System.out.println("Podaj dzien:");
        Scanner data = new Scanner(System.in);
        dzien = data.nextInt();
        System.out.println("Podaj miesiac:");
        miesiac = data.nextInt();
        System.out.println("Podaj rok:");
        rok = data.nextInt();
        if (czy_data_jest_poprawna(dzien, miesiac, rok))
            System.out.println("Data jest poprawna.");
        else
            System.out.println("Data jest niepoprawna.");
    }
}

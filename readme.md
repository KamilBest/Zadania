###Zadanie 1

Napisz program, który wypisuje liczby od 1 do 100. Ale dla wielokrotności trójki wyświetl "Fizz" 
zamiast liczby oraz dla wielokrotności piątki wyświetl "Buzz". Dla liczb będących wielokrotnościami 
trójki oraz piątki wyświetl "FizzBuzz".


###Zadanie 2

Napisz funkcję sprawdzającą poprawność daty w latach 2001-2099 (daty spoza tego okresu uznaj za 
niepoprawne).
Wejście – trzy parametry liczbowe (dzień, miesiąc, rok).
Wyjście – parametr logiczny (true – data poprawna, false – data niepoprawna)

###Zadanie 3

W grze w kości bierze udział dwóch graczy o nazwach: pierwszy, drugi. Każdemu graczowi przypada 5 
tur, w każdej turze, gracz wykonuje maksymalnie 10 rzutów dwoma kośćmi jednocześnie. Tury graczy 
odbywają się naprzemiennie tzn. grę zaczyna gracz pierwszy, po turze następuje tura gracza 
drugiego, następna jest tura gracza pierwszego itd. Możliwe wyniki rzutu jedna kością to jedna z 
następujących cyfr {1, 2, 3, 4, 5, 6}. Grę zawsze rozpoczyna gracz ”pierwszy”. 

Podczas każdej tury 
gracz zbiera punkty według zasad opisanych poniżej: 
Suma punktów każdego gracza przed 
rozpoczęciem gry wynosi zero. Wygrywa gracz, który zbierze mniejsza ilość punktów.
Napisz program symulujący grę w kości. Standardowe wejście programu to dwie cyfry ze zbioru {1, 2, 
3, 4, 5, 6} oznaczające liczbę oczek na poszczególnych kościach w danym rzucie. Pary cyfr podawane 
są kolejno. W każdym rzucie wczytywana jest nowa para cyfr oznaczająca wynik rzutu kośćmi danego 
gracza. 

Standardowe wyjście zależy od sumy oczek z obydwu kości w danym rzucie w następujący 
sposób:

1. Gdy gracz w swojej turze w pierwszym rzucie uzyska sumę oczek z obu kości równa 7 lub 11, 
wygrywa. Na standardowe wyjście powinien zostać wypisany komunikat o wyniku gracza w danej 
turze: "Gracz nazwa_gracza wygrał". Aktualnie wykonywana tura powinna zostać przerwana i 
rozpocząć tura przeciwnika.
2. Gdy gracz w swojej turze w pierwszym rzucie uzyska sumę oczek z obu kości równa 2 lub 12, 
przegrywa. Na standardowe wyjście powinien zostać wypisany komunikat o wyniku gracza w danej
turze: "Gracz nazwa_gracza przegrał". Aktualnie wykonywana tura powinna zostać przerwana i 
rozpocząć tura przeciwnika. Do punktów gracza doliczone są punkty w liczbie równej ilości rzutów w 
danej turze.
3. Gdy gracz w swojej turze uzyska sumę oczek z obu kości równa 5, wygrywa, kończy swoja turę, 
rozpoczyna się tura przeciwnika. Na standardowe wyjście powinien zostać wypisany komunikat o 
wyniku gracza w danej turze: "Gracz nazwa_gracza wygrał".
4. Gdy gracz w swojej turze uzyska sumę oczek z obu kości inna niż opisane powyżej do punktów 
gracza doliczona zostaje suma oczek uzyskanych w danym rzucie podzielona przez numer rzutu w 
danej turze.
Po zakończeniu wszystkich tur obydwu graczy na standardowe wyjście zostaje wypisany komunikat o 
sumie punktów zdobytych przez każdego z graczy oraz który z graczy wygrał.

###Zadanie 4

Celem zadania jest napisanie klasy analizującej kody kreskowe EAN-13 lub EAN-8.
Poza samą klasą proszę o przygotowanie testów jednostkowych sprawdzających jej poprawność.
Na wejściu funkcji analizującej kod kreskowy są dwa parametry:
 - wejściowy kod kreskowy: parametr tekstowy,
 - rodzaj kodu kreskowego: parametr numeryczny: 1 dla EAN-8, 2 dla EAN-13.

Na wyjściu funkcja zwraca:
 - prawidłowy kod kreskowy (o długości 8 lub 13 znaków) bez ewentualnego add-on'u.

Należy mieć na uwadze, że niektóre skanery kodów kreskowych mogą wycinać z kodu kreskowego 
pierwsze wiodące zero (np. zamiast kodu 0075678164125 przesyłają 075678164125).

Niektóre towary (np. czasopisma) mają dodatkowe kody (tzw. add-on'y) - należy mieć na uwadze, że 
skaner dokleja je bezpośrednio do właściwego kodu kreskowego (odczytany add-on "12" oraz 
właściwy kod "6920702707721" przesyłany jest jako "692070270772112"). Add-on'y mogą 
występować zarówno dla kodów EAN-8 jaki i EAN-13.
Ewentualne błędy w danych wejściowych powinny być sygnalizowane wyjątkami.

Informacje na temat kodów kreskowych: http://pl.wikipedia.org/wiki/EAN

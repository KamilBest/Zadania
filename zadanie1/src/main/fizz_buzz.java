/**
 * @author KamilBest
 */
class FizzBuzz {
    /**
     * Program FizzBuzz wypisuje liczby od 1 do 100, ale dla wielokrotności trójki wyświetla "Fizz"
     zamiast liczby oraz dla wielokrotności piątki wyświetla "Buzz". Dla liczb będących wielokrotnościami
     trójki oraz piątki wyświetla "FizzBuzz".
     */
    private void runFizzBuzz() {
        for (int i = 1; i <= 100; i++) {
            if ((i % 3 == 0) && (i % 5 == 0))
                System.out.println("FizzBuzz");
            else if (i % 3 == 0)
                System.out.println("Fizz");
            else if (i % 5 == 0)
                System.out.println("Buzz");
            else
                System.out.println(i);
        }
    }
    /**
     * Metoda uruchamiająca metode runFizzBuzz();
     */
    public void run() {
        runFizzBuzz();
    }
}
public class Zadanie1 {
    public static void main(String[] args) {
        FizzBuzz fb = new FizzBuzz();
        fb.run();
    }
}

/**
 * Program FizzBuzz wypisuje liczby od 1 do 100, ale dla wielokrotności trójki wyświetla "Fizz"
 * zamiast liczby oraz dla wielokrotności piątki wyświetla "Buzz". Dla liczb będących wielokrotnościami
 * trójki oraz piątki wyświetla "FizzBuzz".
 * @author KamilBest
 */
class FizzBuzz {
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

    public void run() {
        runFizzBuzz();
    }
}
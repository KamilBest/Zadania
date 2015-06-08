/**
 * Created by kamilbest on 08.06.15.
 */
public class Zadanie1 {
    public static void main(String[] args) {
        FizzBuzz fb = new FizzBuzz();
        fb.run();
    }
}

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
/**
 * @author KamilBest
 */
class FizzBuzz {
    
    /**
     * FizzBuzz program prints the numbers from 1 to 100, but for multiples of three displays "Fizz"
     * and for multiples of five displays "Buzz" instead of the number.
     * For numbers that are multiples of three and five shows "FizzBuzz".
     */
    private void FizzBuzz() {
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
     * Method runs FizzBuzz();
     */
    public void run() {
        FizzBuzz();
    }
}
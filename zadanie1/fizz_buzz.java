/**
 * Created by kamilbest on 08.06.15.
 */
public class Zadanie1
{
    Zadanie1()
    {
        System.out.println("Zadanie1 - FizzBuzz");
    }

    class FizzBuzz
    {
        FizzBuzz()
        {
            for (int i = 1; i <= 100; i++) {
                if ((i % 3 == 0) && (i % 5 == 0))
                    System.out.println("FizzBuzz");
                else if (i % 3 == 0)
                    System.out.println("Fizz");
                else if (i % 5 == 0)
                    System.out.println("Buzz");
                else
                    System.out.println(i);
            }        }
    }

    public static void main(String[] args)
    {
        Zadanie1 zadanie1 = new Zadanie1();
        FizzBuzz fizzBuzz = zadanie1.new FizzBuzz();
    }
}
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Scanner;

/**
 * Program checks correctness of date given by user.
 * Years outside the range <2001-2099> are invalid.
 *
 * @author Kamil Best
 */
class Date {
    final String DATE_FORMAT = "dd-MM-yyyy";
    private String date;
    private String year;
    private int yearNumber;

    /**
     * The method taking a date from the user, correct format -> (date: dd-mm-yyyy)
     * Variable year holds 4 last characters responsible for the year,
     * in the variable yearNumber characters are changed into numbers.
     */
    private void enterData() {
        System.out.println("Enter date for check. Correct format of date: dd-mm-yyyy (day-month-year). Remember about dashes.");
        System.out.println("Years outside the range <2001-2099> are invalid.");
        Scanner d = new Scanner(System.in);
        date = d.nextLine();
    }

    /**
     * The method checks date format and whether year belongs to range <2001, 2099>.
     *
     * @throws IllegalArgumentException
     * @throws ParseException
     */
    private void checkDate() {
        try {
            DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
            dateFormat.setLenient(false);
            dateFormat.parse(date);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Wrong format of date!");
        }
        year = date.substring(6, 10);
        yearNumber = Integer.parseInt(year);
        if (yearNumber < 2001 || yearNumber > 2099) {
            throw new IllegalArgumentException("Wrong year!");
        }
        System.out.println("Date: " + date + " is correct.");
    }

    /**
     * The method analyzes correctness of date and asking about enter date until it will be correct.
     *
     * @throws IllegalArgumentException
     */
    private void analyzeDate() {
        while (true) {
            enterData();
            try {
                checkDate();
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println("Incorrect date! Enter date again.");
            }
        }
    }

    /**
     * The method run analyzeDate() method.
     */
    public void runChecking() {
        analyzeDate();
    }
}
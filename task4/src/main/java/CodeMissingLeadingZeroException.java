/**
 * Created by kamilbest on 08.07.15.
 */
public class CodeMissingLeadingZeroException extends Exception{
    public CodeMissingLeadingZeroException(String message) {
        super(message);
    }

    public CodeMissingLeadingZeroException(String message, Throwable throwable) {
        super(message, throwable);
    }
}

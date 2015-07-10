/**
 * Exception which is thrown when leading zero in barcode had been cut off.
 */
public class CodeMissingLeadingZeroException extends Exception {
    public CodeMissingLeadingZeroException(String message) {
        super(message);
    }

    public CodeMissingLeadingZeroException(String message, Throwable throwable) {
        super(message, throwable);
    }
}

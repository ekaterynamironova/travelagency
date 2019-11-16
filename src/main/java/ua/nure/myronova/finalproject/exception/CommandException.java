package ua.nure.myronova.finalproject.exception;

public class CommandException extends AppException {

    private static final long serialVersionUID = 1835572875324941932L;

    public CommandException() {
        super();
    }

    public CommandException(String message, Throwable cause) {
        super(message, cause);
    }
}

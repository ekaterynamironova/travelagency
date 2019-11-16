package ua.nure.myronova.finalproject.exception;

public class ServiceException extends AppException {

    private static final long serialVersionUID = -6768314229162656166L;

    public ServiceException() {
        super();
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
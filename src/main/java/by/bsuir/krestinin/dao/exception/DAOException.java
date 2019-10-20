package by.bsuir.krestinin.dao.exception;

public class DAOException extends Exception {
    private static final long serialVersionUID = -9060231904220957560L;

    public DAOException() {
        super();
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOException(Throwable cause) {
        super(cause);
    }
}

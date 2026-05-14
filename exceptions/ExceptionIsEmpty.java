package exceptions;

/*========================================
---------------ACTIVIDAD 4----------------
========================================*/

public class ExceptionIsEmpty extends Exception {

    public ExceptionIsEmpty(String message) {
        super(message);
    }

    public ExceptionIsEmpty() {
        super();
    }

}
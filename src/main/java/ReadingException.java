public class ReadingException extends JermiException {

    ReadingException(String message) {
        super("An error has occurred while loading: " + message);
    }
}

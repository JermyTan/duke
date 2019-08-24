public class WritingException extends JermiException {

    WritingException(String message) {
        super("An error has occurred while saving: " + message);
    }
}

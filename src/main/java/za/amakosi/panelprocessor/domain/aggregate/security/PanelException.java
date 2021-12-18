package za.amakosi.panelprocessor.domain.aggregate.security;

public class PanelException extends RuntimeException {
    public PanelException(String message) {
        super(message);
    }

    public PanelException(final String message, final Exception e) {
        super(message, e);
    }
}

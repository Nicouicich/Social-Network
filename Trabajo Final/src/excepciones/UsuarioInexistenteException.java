package excepciones;

public class UsuarioInexistenteException extends Exception {
    public UsuarioInexistenteException(String string, Throwable throwable, boolean b, boolean b1) {
        super(string, throwable, b, b1);
    }

    public UsuarioInexistenteException(Throwable throwable) {
        super(throwable);
    }

    public UsuarioInexistenteException(String string, Throwable throwable) {
        super(string, throwable);
    }

    public UsuarioInexistenteException(String string) {
        super(string);
    }

    public UsuarioInexistenteException() {
        super();
    }
}

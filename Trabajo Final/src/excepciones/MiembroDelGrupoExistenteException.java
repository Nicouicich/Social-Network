package excepciones;

public class MiembroDelGrupoExistenteException extends Exception {
    public MiembroDelGrupoExistenteException(String string, Throwable throwable, boolean b, boolean b1) {
        super(string, throwable, b, b1);
    }

    public MiembroDelGrupoExistenteException(Throwable throwable) {
        super(throwable);
    }

    public MiembroDelGrupoExistenteException(String string, Throwable throwable) {
        super(string, throwable);
    }

    public MiembroDelGrupoExistenteException(String string) {
        super(string);
    }

    public MiembroDelGrupoExistenteException() {
        super();
    }
}

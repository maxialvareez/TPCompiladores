package Principal;

public class Token {

    private String lexema;
    private int id;

    public Token(String lexema, int id) {
        this.lexema = lexema;
        this.id = id;
    }

    public Token(int id) {
        this.id = id;
        this.lexema = null;
    }

    public String getLexema() {
        return lexema;
    }

    public int getId() {
        return id;
    }
}

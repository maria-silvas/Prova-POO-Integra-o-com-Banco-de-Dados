package model;

public class Generic<S, N extends Number> {

    private S texto;
    private N numero;

    public Generic(S texto, N numero) {
        this.texto = texto;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return texto + "-" + numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Generic<S, N> Generic = (Generic<S, N>) o;
        if (this.numero.equals(Generic.numero) && this.texto.equals(Generic.texto)) {
            return true;
        }
        return false;
    }

}
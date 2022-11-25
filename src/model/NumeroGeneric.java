public class NumeroGeneric<S, N extends Number> {

    private S texto;
    private N numero;

    public NumeroGeneric(S texto, N numero) {
        this.texto = texto;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "letras: " + texto + " números: " + numero + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        NumeroGeneric<S, N> NumeroGeneric = (NumeroGeneric<S, N>) o;
        if (this.numero.equals(NumeroGeneric.numero) && this.texto.equals(NumeroGeneric.texto)) {
            return true;
        }
        return false;
    }

}
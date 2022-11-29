public class Prefixo<S, N extends Number> {

    private S texto;
    private N numero;

    public Prefixo(S texto, N numero) {
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
        Prefixo<S, N> Prefixo = (Prefixo<S, N>) o;
        if (this.numero.equals(Prefixo.numero) && this.texto.equals(Prefixo.texto)) {
            return true;
        }
        return false;
    }

}
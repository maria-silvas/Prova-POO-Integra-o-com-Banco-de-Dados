package model;

public class Prefixo<S, N extends Number> {

    private S letra;
    private N numero;

    public Prefixo(S letra, N numero) {
        this.letra = letra;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "letras: " + letra + " números: " + numero + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Prefixo<S, N> Prefixo = (Prefixo<S, N>) o;
        if (this.numero.equals(Prefixo.numero) && this.letra.equals(Prefixo.letra)) {
            return true;
        }
        return false;
    }

}
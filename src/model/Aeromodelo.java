package model;

public class Aeromodelo {
    // classe inicial
    protected int id;
    private String marca;
    private String modelo;
    

    public Aeromodelo() {

    }

    public Aeromodelo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public Aeromodelo(int id, String marca, String modelo) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Aeromodelo{" + "id=" + id + ", marca=" + marca + ", modelo=" + modelo + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aeromodelo other = (Aeromodelo) obj;
        if (this.id != other.id) {
            return false;
        }
        if ((this.marca == null) ? (other.marca != null) : !this.marca.equals(other.marca)) {
            return false;
        }
        if ((this.modelo == null) ? (other.modelo != null) : !this.modelo.equals(other.modelo)) {
            return false;
        }
        return true;
    }
}
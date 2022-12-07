package model;

import java.util.ArrayList;

import database.DAO;

public abstract class Aeronave {

    protected int id;
    protected String marca;
    protected static String modelo;

    public static ArrayList<Aeronave> aeoronaves = new ArrayList<Aeronave>();
    public static Aeronave[] aeronaves;

    public void Aeronave() {

    }

    public Aeronave(int id, String marca, String modelo) {

        this.id = id;
        this.marca = marca;
        this.modelo = modelo;

        aeoronaves.add(this);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /*
     * public Boolean verificaAeoronave(Prefixo<String, Integer> prefixo){
     * for(Aeoronave aeronave: aeoronaves){
     * if(aeronave.getAeroave().equals(prefixo) == true){
     * return true;
     * }
     * }
     * return false;
     * }
     * 
     */

    private Object getAeronave() {
        return null;
    }

    @Override
    public String toString() {
        return "Id: " + this.id + " | Marca: " + this.marca + " | Modelo: " + this.modelo;
    }

}
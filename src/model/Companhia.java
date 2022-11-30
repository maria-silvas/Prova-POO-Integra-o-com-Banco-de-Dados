package model;

import java.util.ArrayList;

public class Companhia {
    private String nome;
    private String cnpj;
    private int id;

    public static ArrayList<Companhia> companhias = new ArrayList<Companhia>();

    public Companhia(int id, String nome, String cnpj) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;

        companhias.add(this);
    }

    public String getMarca() {
        return nome;
    }

    public void setMarca(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public static Companhia getComapnhiaById(int id) {
        for (Companhia companhia : Companhia.companhias) {
            if (companhia.id == id) {
                return companhia;
            }
        }

        return null;
    }

    public static Companhia deleteComapnhiaById(int id) {
        for (Companhia companhia : Companhia.companhias) {
            if (companhia.id == id) {
                Companhia.companhias.remove(companhia);
                return companhia;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return super.toString() + "Nome: " + this.nome + "| Cnpj:" + this.cnpj;
    }

    public int getId() {
        return 0;
    }

}
package model;

/*========================================
---------------EJERCICIO 5----------------
========================================*/

public class Producto implements Comparable<Producto> {

    private int codigo;
    private String nombre;

    public Producto(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public int compareTo(Producto otro) {
        return Integer.compare(this.codigo, otro.codigo);
    }

    @Override
    public String toString() {
        return codigo + " - " + nombre;
    }
}
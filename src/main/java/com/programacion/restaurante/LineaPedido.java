package com.programacion.restaurante;

public class LineaPedido {

    private int id;
    private Plato plato;
    private String estado;
    private int cantidad;
    private static int contador;

    public LineaPedido(Plato plato, String estado, int cantidad) {
        this.setId();
        this.setPlato(plato);
        this.setEstado(estado);
        this.setCantidad(cantidad);
    }

    LineaPedido() {
        this.setId();
    }

    @Override
    public String toString() {
        return "LineaPedido{" + "id=" + id + ", plato=" + plato + ", estado=" + estado + ", cantidad=" + cantidad + '}' + "\n";
    }
    
    public int getId() {
        return id;
    }

    public void setId() {
        contador++;
        this.id = contador;
    }

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

}

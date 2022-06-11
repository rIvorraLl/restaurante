package com.programacion.restaurante;

import java.util.ArrayList;

public class Pedido {
    private int id;
    private int mesa;
    private ArrayList<LineaPedido> listaLineaPedido;
    private static int contador;

    public Pedido() {
        this.setId();
    }

    public Pedido(int id, int mesa, ArrayList<LineaPedido> listaLineaPedido) {
        this.setId();
        this.mesa = mesa;
        this.listaLineaPedido = listaLineaPedido;
        this.contador = contador;
    }

    @Override
    public String toString() {
        return "Pedido{" + "id=" + id + ", mesa=" + mesa + ", listaLineaPedido=" + listaLineaPedido + '}' + "\n";
    }
    
    public int getId() {
        return id;
    }

    public void setId() {
        contador++;
        this.id = contador;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public ArrayList<LineaPedido> getListaLineaPedido() {
        return listaLineaPedido;
    }

    public void setListaLineaPedido(ArrayList<LineaPedido> listaLineaPedido) {
        this.listaLineaPedido = listaLineaPedido;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    
    
    
}

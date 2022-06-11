package com.programacion.restaurante;

import java.util.ArrayList;

public abstract class Persona {

    // Atributos
    private int id;
    private String nombre;
    private static int contador;

    // Constructores
    public Persona() {
    }

    public Persona(String nombre) {
        this.setId();
        this.setNombre(nombre);
    }

    // Métodos
    // Muestra todas las líneas de pedido con estado pedido, cocina o listo
    public void verPendientes(ArrayList<Pedido> listaPedidos) {
        boolean mostrar = false;
        for (int i = 0; i < listaPedidos.size(); i++) {
            for (int j = 0; j < listaPedidos.get(i).getListaLineaPedido().size(); j++) {
                if (listaPedidos.get(i).getListaLineaPedido().get(j).getEstado().equals("PEDIDO")
                        || listaPedidos.get(i).getListaLineaPedido().get(j).getEstado().equals("COCINA")
                        || listaPedidos.get(i).getListaLineaPedido().get(j).getEstado().equals("LISTO")) {
                    mostrar = true;
                    // System.out.println(listaPedidos.get(i));
                    System.out.println(listaPedidos.get(i).getListaLineaPedido().get(j));
                }
            }
            if (mostrar) {
                System.out.println("PEDIDO:\n" + listaPedidos.get(i));
                mostrar = false;
            }
        }
    }
    
    public abstract void actuar(int id, ArrayList<Pedido> listaPedidos);
    
    public float calcularCaja(ArrayList<Pedido> listaPedidos) {
        float totalCaja = 0;
        for (int i = 0; i < listaPedidos.size(); i++) {
            for (int j = 0; j < listaPedidos.get(i).getListaLineaPedido().size(); j++) {
                totalCaja = totalCaja +
                        listaPedidos.get(i).getListaLineaPedido().get(j).getPlato().getPrecio()
                        * listaPedidos.get(i).getListaLineaPedido().get(j).getCantidad();
            }
        }
        return totalCaja;
    }
    
    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nombre=" + nombre + '}';
    }

    public int getId() {
        return id;
    }

    public void setId() {
        contador++;
        this.id = contador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}

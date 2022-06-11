package com.programacion.restaurante;

import java.util.ArrayList;

public class Cocinero extends Persona {

    public Cocinero() {
        super();
    }

    public Cocinero(String nombre) {
        super(nombre);
    }

    @Override
    public void actuar(int id, ArrayList<Pedido> listaPedidos) {
        for (int i = 0; i < listaPedidos.size(); i++) {
            for (int j = 0; j < listaPedidos.get(i).getListaLineaPedido().size(); j++) {
                if (listaPedidos.get(i).getListaLineaPedido().get(j).getId() == id) {
                    if (listaPedidos.get(i).getListaLineaPedido().get(j).getEstado().equals("PEDIDO")) {
                        listaPedidos.get(i).getListaLineaPedido().get(j).setEstado("COCINA");
                    } else if (listaPedidos.get(i).getListaLineaPedido().get(j).getEstado().equals("COCINA")) {
                        listaPedidos.get(i).getListaLineaPedido().get(j).setEstado("LISTO");
                    }
                }

            }
        }
    }

    public void verPendientes(ArrayList<Pedido> listaPedidos) {
        for (int i = 0; i < listaPedidos.size(); i++) {
            for (int j = 0; j < listaPedidos.get(i).getListaLineaPedido().size(); j++) {
                // System.out.println(listaPedidos.get(i).getListaLineaPedido().get(j).getEstado());
                if (listaPedidos.get(i).getListaLineaPedido().get(j).getEstado().equals("PEDIDO")
                        || listaPedidos.get(i).getListaLineaPedido().get(j).getEstado().equals("COCINA")) {
                    System.out.println(listaPedidos.get(i).getListaLineaPedido().get(j).toString());
                }
            }
        }
    }

}

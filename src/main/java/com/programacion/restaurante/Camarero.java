package com.programacion.restaurante;

import java.util.ArrayList;
import java.util.Scanner;

public class Camarero extends Persona {

    public Camarero() {
        super();
    }

    public Camarero(String nombre) {
        super(nombre);
    }

    public Pedido crearPedido(ArrayList<Plato> listaPlatos) {
        Pedido nuevoPedido = new Pedido();
        ArrayList<LineaPedido> nuevaListaLp = new ArrayList<LineaPedido>();
        Scanner kb = new Scanner(System.in);
        System.out.println("Introduce el número de mesa:");
        int numeroMesa = Integer.parseInt(kb.nextLine());
        nuevoPedido.setMesa(numeroMesa);
        boolean continuar = true;
        while (continuar) {
            LineaPedido nuevaLp = new LineaPedido();
            System.out.println(listaPlatos.toString());
            System.out.println("Introduce el id del plato:");
            int indexPlato = Integer.parseInt(kb.nextLine());
            for (int i = 0; i < listaPlatos.size(); i++) {
                if (listaPlatos.get(i).getId() == indexPlato) {
                    nuevaLp.setPlato(listaPlatos.get(i));
                }
            }
            System.out.println("Introduce la cantidad del plato:");
            int indexCantidad = Integer.parseInt(kb.nextLine());
            nuevaLp.setCantidad(indexCantidad);
            nuevaLp.setEstado("PEDIDO");
            System.out.println("¿Añadir más platos? (s/n)");
            String opcion = kb.nextLine();
            if (opcion.equals("s")) {
                nuevaListaLp.add(nuevaLp);
                nuevoPedido.setListaLineaPedido(nuevaListaLp);
            } else {
                nuevaListaLp.add(nuevaLp);
                nuevoPedido.setListaLineaPedido(nuevaListaLp);
                continuar = false;
            }
        }
        System.out.println(nuevoPedido.toString());
        return nuevoPedido;
    }

    // método editarPedido() Permite añadir una linia de pedido a un pedido
    public Pedido editarPedido(ArrayList<Pedido> listaPedidos, ArrayList<Plato> listaPlatos) {
        LineaPedido nuevaLp = new LineaPedido();
        Pedido nuevoPedido = new Pedido();
        Scanner kb = new Scanner(System.in);
        System.out.println("Introduce el identificador del pedido:");
        boolean continuar = true;
        boolean isNum = false;
        int idPedido = -1;
        while (continuar) {
            try {
                idPedido = Integer.parseInt(kb.nextLine());
                isNum = true;
            } catch (Exception e) {
            }
            if (isNum) {
                continuar = false;
            }
        }
        for (int i = 0; i < listaPedidos.size(); i++) {
            if (listaPedidos.get(i).getId() == idPedido) {
                nuevoPedido = listaPedidos.get(i);
            }
        }
        
        System.out.println(listaPlatos.toString());
        System.out.println("Introduce el id del plato:");
        int indexPlato = Integer.parseInt(kb.nextLine());
        for (int i = 0; i < listaPlatos.size(); i++) {
            if (listaPlatos.get(i).getId() == indexPlato) {
                nuevaLp.setPlato(listaPlatos.get(i));
            }
        }
        System.out.println("Introduce la cantidad del plato:");
        int indexCantidad = Integer.parseInt(kb.nextLine());
        nuevaLp.setCantidad(indexCantidad);
        nuevaLp.setEstado("PEDIDO");
        nuevoPedido.getListaLineaPedido().add(nuevaLp);
        return nuevoPedido;
    }
    
    public void sacarTicket(int idPedido, ArrayList<Pedido> listaPedidos) {
        float total = 0;
        int index = -1;
        for (int i = 0; i < listaPedidos.size(); i++) {
            if (listaPedidos.get(i).getId() == idPedido) {
                index = i;
                i = listaPedidos.size();
            }
        }
        Pedido pedido = listaPedidos.get(index);
        for (int i = 0; i < pedido.getListaLineaPedido().size(); i++) {
            total = total + pedido.getListaLineaPedido().get(i).getCantidad()
                    * pedido.getListaLineaPedido().get(i).getPlato().getPrecio();
        }
        System.out.println(listaPedidos.get(index).toString());
        System.out.println("Total a pagar: " + total + " euros\n");
    }

    @Override
    public void actuar(int id, ArrayList<Pedido> listaPedidos) {
        for (int i = 0; i < listaPedidos.size(); i++) {
            for (int j = 0; j < listaPedidos.get(i).getListaLineaPedido().size(); j++) {
                if (listaPedidos.get(i).getListaLineaPedido().get(j).getId() == id) {
                    if (listaPedidos.get(i).getListaLineaPedido().get(j).getEstado().equals("LISTO")) {
                        listaPedidos.get(i).getListaLineaPedido().get(j).setEstado("SERVIDO");
                    }

                }
            }
        }
    }
}

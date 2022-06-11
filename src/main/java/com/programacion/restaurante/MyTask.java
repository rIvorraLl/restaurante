package com.programacion.restaurante;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MyTask {

    public static void main(String[] args) throws IOException {
        ArrayList<Plato> listaPlatos = new ArrayList<Plato>();
        ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();
        ArrayList<Persona> listaEmpleados = new ArrayList<Persona>();

        Plato np = new Plato();
        np.cargarPlatos(listaPlatos);
        System.out.println(listaPlatos.toString());

        Cocinero cocinero1 = new Cocinero("Pere");
        System.out.println(cocinero1.toString());
        listaEmpleados.add(cocinero1);
        Cocinero cocinero2 = new Cocinero("Joan");
        System.out.println(cocinero2.toString());
        listaEmpleados.add(cocinero2);

        Camarero camarero1 = new Camarero("Miquel");
        System.out.println(camarero1.toString());
        listaEmpleados.add(camarero1);
        Camarero camarero2 = new Camarero("Pep Toni");
        System.out.println(camarero2.toString());
        listaEmpleados.add(camarero2);

        //Pedido nuevoPedido = camarero1.crearPedido(listaPlatos);
        //listaPedidos.add(nuevoPedido);
        //cocinero1.verPendientes(listaPedidos);
        boolean continuar = true;
        boolean idCorrecto = false;
        Persona empleado = null;
        while (continuar) {
            Scanner kb = new Scanner(System.in);
            System.out.println("Introduce tu identificador:");
            int identificador = -1;
            try {
                identificador = Integer.parseInt(kb.nextLine());
            } catch (Exception e) {
                System.out.println("Debe introducir un número");
            }
            while (!idCorrecto) {
                for (int i = 0; i < listaEmpleados.size(); i++) {
                    if (listaEmpleados.get(i).getId() == identificador) {
                        idCorrecto = true;
                        i = listaEmpleados.size();
                    }
                }
                if (!idCorrecto) {
                    System.out.println("Su id no es correcto. Inténtelo de nuevo:");
                    try {
                        identificador = Integer.parseInt(kb.nextLine());
                    } catch (Exception e) {
                        System.out.println("Debe introducir un número");
                    }
                }
            }
            for (int i = 0; i < listaEmpleados.size(); i++) {
                if (listaEmpleados.get(i).getId() == identificador) {
                    empleado = listaEmpleados.get(i);
                    System.out.println("Identificación:\n"
                            + listaEmpleados.get(i).toString());
                }
            }
            if (empleado instanceof Camarero) {

                boolean contCamarero = true;
                int opcion = -1;
                while (contCamarero) {
                    System.out.println("Escoja una opción:\n"
                            + "0. Crear pedido\n"
                            + "1. Ver pedidos pendientes\n"
                            + "2. Editar pedido\n"
                            + "3. Marcar pedido como servido\n"
                            + "4. Sacar ticket\n"
                            + "5. Hacer caja\n"
                            + "9. Salir");
                    try {
                        opcion = Integer.parseInt(kb.nextLine());
                    } catch (Exception e) {
                    }
                    if (opcion == 0 || opcion == 1 || opcion == 2 || opcion == 3
                            || opcion == 4 || opcion == 5 || opcion == 9) {
                        switch (opcion) {
                            case 0:
                                Pedido nuevoPedido = ((Camarero) empleado).crearPedido(listaPlatos);
                                listaPedidos.add(nuevoPedido);
                                break;
                            case 1:
                                empleado.verPendientes(listaPedidos);
                                break;
                            case 2:
                                ((Camarero) empleado).editarPedido(listaPedidos, listaPlatos);
                                break;
                            case 3:
                                System.out.println(listaPedidos.toString());
                                int idLp = -1;
                                System.out.println("Introduzca el identificador de la línea de pedidos:");
                                try {
                                    idLp = Integer.parseInt(kb.nextLine());
                                } catch (Exception e) {
                                    System.out.println("No ha introducido un identificador válido.");
                                    break;
                                }
                                ((Camarero) empleado).actuar(idLp, listaPedidos);
                                break;
                            case 4:
                                int idPedido = -1;
                                System.out.println("Introduzca el identificador del pedido:");
                                try {
                                    idPedido = Integer.parseInt(kb.nextLine());
                                } catch (Exception e) {
                                    System.out.println("No ha introducido un identificador válido");
                                    break;
                                }
                                ((Camarero) empleado).sacarTicket(idPedido, listaPedidos);
                                break;
                            case 5:
                                float caja = empleado.calcularCaja(listaPedidos);
                                System.out.println("La caja de hoy es de: " + caja + " euros.");
                                break;
                            case 9:
                                contCamarero = false;
                                break;
                        }
                    } else {
                        System.out.println("Por favor, introduzca una opción correcta (0-5)");
                        try {
                            opcion = Integer.parseInt(kb.nextLine());
                        } catch (Exception e) {
                            System.out.println("Por favor, introduzca un número");
                        }
                    }
                }
            } else {
                boolean contCocinero = true;
                int opcion = -1;
                while (contCocinero) {
                    System.out.println("Escoja una opción:\n"
                            + "0. Ver pedidos pendientes\n"
                            + "1. Avanzar pedido\n"
                            + "9. Salir");
                    try {
                        opcion = Integer.parseInt(kb.nextLine());
                    } catch (Exception e) {
                    }
                    if (opcion == 0 || opcion == 1 || opcion == 9) {
                        switch (opcion) {
                            case 0:
                                ((Cocinero) empleado).verPendientes(listaPedidos);
                                break;
                            case 1:
                                int idLp = -1;
                                System.out.println("Introduzca el identificador de la línea de pedidos:");
                                try {
                                    idLp = Integer.parseInt(kb.nextLine());
                                } catch (Exception e) {
                                    System.out.println("No ha introducido un identificador.");
                                    break;
                                }
                                ((Cocinero) empleado).actuar(idLp, listaPedidos);
                                break;
                            case 9:
                                contCocinero = false;
                                break;
                        }
                    } else {
                        System.out.println("Por favor, introduzca una opción correcta (0-5)");
                        try {
                            opcion = Integer.parseInt(kb.nextLine());
                        } catch (Exception e) {
                            System.out.println("Por favor, introduzca un número");
                        }
                    }
                }
            }
            System.out.println("Introduzca 9 para salir, o cualquier otra tecla para identificar nuevo usuario");
            String salir = kb.nextLine();
            if (salir.equals("9")) {
                continuar = false;
            }
        }

    }

}

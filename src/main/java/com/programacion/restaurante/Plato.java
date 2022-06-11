package com.programacion.restaurante;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Plato {

    private int id;
    private String nombre;
    private float precio;
    private static int contador;

    public Plato() {
        this.setId();
    }

    public Plato(String nombre, float precio) {
        this.setId();
        this.setNombre(nombre);
        this.setPrecio(precio);
    }

    public void cargarPlatos(ArrayList<Plato> listaPlatos) throws FileNotFoundException, IOException {
        String platos = new String();
        String linea = "";
        boolean eof = false;
        BufferedReader lector = new BufferedReader(new FileReader("/home/alt/platos.txt"));
        while (!eof) {
            linea = lector.readLine();
            if (linea != null) {
                platos += linea + ";";
            } else {
                eof = true;
            }
        }
        lector.close();
        String[] arrayPlatos = platos.split(";");
        System.out.println(Arrays.toString(arrayPlatos));
        int indexNombre = 0;
        int indexPrecio = 1;
        for (int i = 0; i < 7; i++) {
            Plato plato = new Plato();
            plato.setNombre(arrayPlatos[indexNombre]);
            int pvp = Integer.parseInt(arrayPlatos[indexPrecio]);
            plato.setPrecio(pvp);
            boolean control = false;
            for (int j = 0; j < listaPlatos.size(); j++) {
                if (listaPlatos.get(j).getNombre().equals(plato.getNombre())) {
                    control = true;
                    listaPlatos.get(j).setPrecio(plato.getPrecio());
                }
            }
            if (!control) {
             listaPlatos.add(plato);   
            }
            indexNombre = indexNombre + 2;
            indexPrecio = indexPrecio + 2;
        }

    }

    @Override
    public String toString() {
        return "Plato{" + "id=" + id + ", nombre=" + nombre + ", precio=" + precio + '}';
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

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

}

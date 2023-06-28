package com.mycompany.laboratoriografos;

import java.util.ArrayList;
import java.util.List;

public class Grafo {

    public Vertice inicio;
    public Vertice ultimo;
    public int orden;
    public List<Integer> mejorRuta;
    public int minDistancia;

    public Grafo() {
        this.orden = 0;
        this.mejorRuta = new ArrayList<>();
        this.minDistancia = Integer.MAX_VALUE;
    }

    public boolean vacio() {
        if (this.inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    public void insertarVertice(String valor) {
        Vertice nuevo = new Vertice(valor);
        if (this.vacio()) {
            this.inicio = nuevo;
            this.ultimo = nuevo;
            this.orden++;
        } else {
            this.ultimo.siguiente = nuevo;
            this.ultimo = nuevo;
            this.orden++;
        }
    }

    private Vertice encontrarVertice(String valor) {
        Vertice vertice = inicio;
        while (vertice != null) {
            if (vertice.valor.equals(valor)) {
                return vertice;
            }
            vertice = vertice.siguiente;
        }
        return null;
    }

    public void insertarArista(int peso, String origen, String destino, boolean dirigido) {
        Vertice aux1 = this.encontrarVertice(origen);
        Vertice aux2 = this.encontrarVertice(destino);
        Arista aux3;
        Arista nuevo;
        if (this.orden < 2) {
            System.out.println("No se puede insertar arista: No hay suficientes nodos");
        } else {
            if (aux1.adyacente == null) {
                nuevo = new Arista(peso, aux1, aux2);
                aux1.adyacente = nuevo;
            } else {
                aux3 = aux1.adyacente;
                while (aux3.siguiente != null) {
                    aux3 = aux3.siguiente;
                }
                nuevo = new Arista(peso, aux1, aux2);
                aux3.siguiente = nuevo;
            }
        }
        if (!dirigido) {
            this.insertarArista(peso, destino, origen, true);
        }
    }

    public void mostrar() {
        Vertice aux1 = this.inicio;
        Arista aux2;
        String lista = "";
        while (aux1 != null) {
            if (aux1.adyacente == null) {
                lista = "";
            } else {
                aux2 = aux1.adyacente;
                while (aux2 != null) {
                    lista += aux2.peso + " ";
                    aux2 = aux2.siguiente;
                }
            }

            System.out.println(aux1.valor + "->" + lista);
            lista = "";
            aux1 = aux1.siguiente;

        }
    }

    public int[][] obtenerMatrizAdyacencia() {
        int[][] matrizAdyacencia = new int[this.orden][this.orden];
        for (int i = 0; i < orden; i++) {
            for (int j = 0; j < orden; j++) {
                matrizAdyacencia[i][j] = 0;
            }
        }

        Vertice aux1 = this.inicio;
        Arista aux2;
        int origen, destino;
        while (aux1 != null) {
            origen = obtenerIndiceVertice(aux1);
            aux2 = aux1.adyacente;
            while (aux2 != null) {
                destino = obtenerIndiceVertice(aux2.destino);
                matrizAdyacencia[origen][destino] = aux2.peso;
                aux2 = aux2.siguiente;
            }
            aux1 = aux1.siguiente;
        }

        return matrizAdyacencia;
    }

    private int obtenerIndiceVertice(Vertice vertice) {
        Vertice aux = this.inicio;
        int indice = 0;
        while (aux != null) {
            if (aux == vertice) {
                return indice;
            }
            aux = aux.siguiente;
            indice++;
        }
        return -1;
    }

    public Vertice obtenerVerticePorIndice(int indice) {
        Vertice aux = inicio;
        int contador = 0;
        while (aux != null) {
            if (contador == indice) {
                return aux;
            }
            aux = aux.siguiente;
            contador++;
        }
        return null;  
    }

    public void mostrarMatrizAdyacencia() {
        int[][] matriz = obtenerMatrizAdyacencia();
        for (int i = 0; i < this.orden; i++) {
            for (int j = 0; j < this.orden; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public List<Integer> encontrarRutaMasCorta(String origen, String destino) {
        Vertice origenVertice = this.encontrarVertice(origen);
        Vertice destinoVertice = this.encontrarVertice(destino);
        boolean[] visitado = new boolean[this.orden];
        List<Integer> rutaActual = new ArrayList<>();
        visitado[this.obtenerIndiceVertice(origenVertice)] = true;
        rutaActual.add(this.obtenerIndiceVertice(origenVertice));
        backtrack(this.obtenerIndiceVertice(origenVertice), this.obtenerIndiceVertice(destinoVertice), 0, rutaActual, visitado);
        return mejorRuta;
    }

    public void backtrack(int indexActual, int indexDestino, int distanciaActual, List<Integer> rutaActual, boolean[] Visitado) {
        int[][] matrizAdyacencia = this.obtenerMatrizAdyacencia();
        if (indexActual == indexDestino) {
            if (distanciaActual < minDistancia) {
                this.minDistancia = distanciaActual;
                this.mejorRuta = new ArrayList<>(rutaActual);
            }
            return;
        }

        for (int i = 0; i < this.orden; i++) {
            if (matrizAdyacencia[indexActual][i] > 0 && !Visitado[i]) {
                Visitado[i] = true;
                rutaActual.add(i);
                backtrack(i, indexDestino, distanciaActual + matrizAdyacencia[indexActual][i], rutaActual, Visitado);
                rutaActual.remove(rutaActual.size() - 1);
                Visitado[i] = false;
            }
        }
    }

    public void mostrarCamino(String origen, String destino) {
        List<Integer> camino = this.encontrarRutaMasCorta(origen, destino);
        for (int i = 0; i < camino.size(); i++) {
            int indice = camino.get(i);
            System.out.print(this.obtenerVerticePorIndice(indice).valor + " -> ");
        }
        System.out.print("Fin");
    }

}

package com.mycompany.laboratoriografos;

public class LaboratorioGrafos {

    public static void main(String[] args) {
        Grafo g1=new Grafo();
        g1.insertarVertice(1);
        g1.insertarVertice(2);
        g1.insertarVertice(3);
        g1.insertarVertice(4);
        g1.insertarVertice(5);
        g1.insertarArista(3, 1, 2);
        g1.insertarArista(10, 1, 4);
        g1.insertarArista(12, 1, 5);
        g1.insertarArista(4, 2, 3);
        g1.insertarArista(8, 2, 5);
        g1.insertarArista(2, 3, 4);
        g1.insertarArista(5, 5, 4);
        g1.mostrar();
        g1.recorrido();
    }
}

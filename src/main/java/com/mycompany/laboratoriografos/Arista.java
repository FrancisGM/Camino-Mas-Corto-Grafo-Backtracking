package com.mycompany.laboratoriografos;

public class Arista {
    public int peso;
    public Arista siguiente;
    public Vertice origen;
    public Vertice destino;

    public Arista(int peso, Vertice origen, Vertice destino) {
        this.peso = peso;
        this.origen = origen;
        this.destino = destino;
    }
    
   

    
}

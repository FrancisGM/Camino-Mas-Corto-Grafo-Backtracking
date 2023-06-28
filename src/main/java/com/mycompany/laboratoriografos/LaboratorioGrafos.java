package com.mycompany.laboratoriografos;

public class LaboratorioGrafos {

    public static void main(String[] args) {
        Grafo g1=new Grafo();
        g1.insertarVertice("V0");
        g1.insertarVertice("V1.1");
        g1.insertarVertice("V1.2");
        g1.insertarVertice("V1.3");
        g1.insertarVertice("V2.1");
        g1.insertarVertice("V2.2");
        g1.insertarVertice("V2.3");
        g1.insertarVertice("V3");
        g1.insertarArista(1,"V0","V1.1",false);    
        g1.insertarArista(3,"V0","V1.2",false);
        g1.insertarArista(2,"V0","V1.3",false);
        g1.insertarArista(5,"V1.1","V2.1",false);
        g1.insertarArista(3,"V1.2","V2.2",false);
        g1.insertarArista(7,"V1.3","V2.3",false);
        g1.insertarArista(3,"V1.1","V2.3",false);
        g1.insertarArista(4,"V1.2","V2.1",false);
        g1.insertarArista(2,"V1.3","V2.2",false);
        g1.insertarArista(4,"V2.1","V3",false);
        g1.insertarArista(1,"V2.2","V3",false);
        g1.insertarArista(1,"V2.3","V3",false);
        g1.mostrar();
        g1.mostrarMatrizAdyacencia();
        g1.mostrarCamino("V0", "V3");
    }
}

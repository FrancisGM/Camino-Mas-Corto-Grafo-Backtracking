package com.mycompany.laboratoriografos;

public class Grafo {

    public Vertice inicio;
    public Vertice ultimo;
    public int orden;

    public Grafo() {
        this.orden = 0;
    }

    public boolean vacio() {
        if (this.inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    public void insertarVertice(int valor) {
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

    public void insertarArista(int peso, int origen, int destino) {
        Vertice aux1 = this.inicio;
        Vertice aux2 = this.inicio;
        Arista aux3;
        Arista nuevo;
        while (aux2.valor != destino) {
            aux2 = aux2.siguiente;
        }
        while (aux1.valor != origen) {
            aux1 = aux1.siguiente;
        }
        if (this.orden < 2) {
            System.out.println("No se puede insertar arista: No hay suficientes nodos");
        } else {
            if (aux1.adyacente == null) {
                nuevo = new Arista(peso, aux1, aux2);
                aux1.adyacente = nuevo;
            } else {
                aux3 = aux1.adyacente;
                while (aux3.siguiente != null ) {
                    aux3 = aux3.siguiente;
                }
                nuevo = new Arista(peso, aux1, aux2);
                aux3.siguiente = nuevo;
            }
        }
    }

    public void recorrido() {
        Cola listaCola = new Cola();
        Cola listaSalida = new Cola();
        listaCola.insertar(this.inicio);
        this.recorridoAmplitud(listaCola, listaSalida);

    }

    public void recorridoAmplitud(Cola listaCola, Cola listaSalida) {
        if (listaCola.vacio()) {
            listaSalida.imprimirCola();
        } else {
            Vertice aux=listaCola.quitar();
            if (listaSalida.pertenece(aux)) {
                this.recorridoAmplitud(listaCola, listaSalida);
            }else{
                Arista aux2=aux.adyacente;
                while(aux2!=null){
                    listaCola.insertar(aux2.destino);
                    aux2=aux2.siguiente;
                }
                listaSalida.insertar(aux);
                this.recorridoAmplitud(listaCola, listaSalida);
            }
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
}

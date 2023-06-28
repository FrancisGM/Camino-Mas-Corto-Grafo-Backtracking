package com.mycompany.laboratoriografos;

public class Cola {

    public ElementoCola primero;
    public ElementoCola ultimo;
    public int tamanio;

    public Cola() {
        this.tamanio = 0;
    }

    public boolean vacio() {
        if (this.primero == null) {
            return true;
        }
        return false;
    }

    public void insertar(Vertice ver) {
        ElementoCola nuevoElemento = new ElementoCola(ver);
        if (this.vacio()) {
            this.primero = nuevoElemento;
            this.ultimo = nuevoElemento;
            this.tamanio++;
        } else {
            this.ultimo.siguienteCola = nuevoElemento;
            this.ultimo = this.ultimo.siguienteCola;
            this.tamanio++;
        }
    }

    public Vertice quitar() {
        ElementoCola aux = this.primero;
        this.primero = this.primero.siguienteCola;
        this.tamanio--;
        return aux.elemento;
    }

    public boolean pertenece(Vertice ver) {
        ElementoCola aux = this.primero;

        if (this.vacio()) {
            return false;
        } else {
            for (int i = 0; i < this.tamanio; i++) {
                if (aux.elemento == ver) {
                    return true;
                }
                aux = aux.siguienteCola;
            }
        }
        return false;
    }

    public void imprimirCola() {
        ElementoCola aux = this.primero;
        String mensaje = "";
        for (int i = 0; i < this.tamanio; i++) {
            mensaje += aux.elemento.valor + " ";
            aux = aux.siguienteCola;
        }
        System.out.println(mensaje);
    }
}

package com.example.gycsol;

public class ListItem {

    private String comedor;
    private int linea;
    private String descripcionLinea;
    private String urlMandante;

    public ListItem(String comedor, int linea, String descripcionLinea, String urlMandante) {
        this.comedor = comedor;
        this.linea = linea;
        this.descripcionLinea = descripcionLinea;
        this.urlMandante = urlMandante;
    }

    public String getComedor() {
        return comedor;
    }

    public void setComedor(String comedor) {
        this.comedor = comedor;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public String getDescripcionLinea() {
        return descripcionLinea;
    }

    public void setDescripcionLinea(String descripcionLinea) {
        this.descripcionLinea = descripcionLinea;
    }

    public String getUrlMandante() {
        return urlMandante;
    }

    public void setUrlMandante(String urlMandante) {
        this.urlMandante = urlMandante;
    }
}

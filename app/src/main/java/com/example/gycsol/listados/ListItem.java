package com.example.gycsol.listados;

public class ListItem {

    private String comedor;
    private String descripcionLinea;
    private String urlMandante;

    public ListItem(String comedor, String descripcionLinea, String urlMandante) {
        this.comedor = comedor;
        this.descripcionLinea = descripcionLinea;
        this.urlMandante = urlMandante;
    }

    public String getComedor() {
        return comedor;
    }

    public void setComedor(String comedor) {
        this.comedor = comedor;
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

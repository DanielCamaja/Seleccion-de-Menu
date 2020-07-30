package com.example.gycsol.listados;

public class ListItem {

    private String comedor;
    private String descripcionLinea;

    public ListItem(String comedor, String descripcionLinea) {
        this.comedor = comedor;
        this.descripcionLinea = descripcionLinea;
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
}

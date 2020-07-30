package com.example.gycsol.listados;

public class ListComedor {

    private String id;
    private String comedor;
    private String descripcionLinea;
    private String descMenu;
    private String horaConsumo;
    private String nombreEmpresa;

    public ListComedor(String id, String comedor, String descripcionLinea, String descMenu, String horaConsumo, String nombreEmpresa) {
        this.id = id;
        this.comedor = comedor;
        this.descripcionLinea = descripcionLinea;
        this.descMenu = descMenu;
        this.horaConsumo = horaConsumo;
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getDescMenu() {
        return descMenu;
    }

    public void setDescMenu(String descMenu) {
        this.descMenu = descMenu;
    }

    public String getHoraConsumo() {
        return horaConsumo;
    }

    public void setHoraConsumo(String horaConsumo) {
        this.horaConsumo = horaConsumo;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
}

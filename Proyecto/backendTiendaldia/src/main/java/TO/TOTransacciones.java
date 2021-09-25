
package TO;

import java.util.Date;

public class TOTransacciones {
    private int idTransacciones;
    private int idProducto;
    private double totalTransaccion;
    private double cantidadTransaccion;
    private double valorUnitarioCompra;
    private double valorUnitarioVenta;
    private Date fechaTransaccion;
    private double ivaTransaccion;
    private String tipoTransacciones;

    public TOTransacciones() {
    }

    public TOTransacciones(int idTransacciones, int idProducto, double totalTransaccion, double cantidadTransaccion, double valorUnitarioCompra, double valorUnitarioVenta, Date fechaTransaccion, double ivaTransaccion, String tipoTransacciones) {
        this.idTransacciones = idTransacciones;
        this.idProducto = idProducto;
        this.totalTransaccion = totalTransaccion;
        this.cantidadTransaccion = cantidadTransaccion;
        this.valorUnitarioCompra = valorUnitarioCompra;
        this.valorUnitarioVenta = valorUnitarioVenta;
        this.fechaTransaccion = fechaTransaccion;
        this.ivaTransaccion = ivaTransaccion;
        this.tipoTransacciones = tipoTransacciones;
    }

    public int getIdTransacciones() {
        return idTransacciones;
    }

    public void setIdTransacciones(int idTransacciones) {
        this.idTransacciones = idTransacciones;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public double getTotalTransaccion() {
        return totalTransaccion;
    }

    public void setTotalTransaccion(double totalTransaccion) {
        this.totalTransaccion = totalTransaccion;
    }

    public double getCantidadTransaccion() {
        return cantidadTransaccion;
    }

    public void setCantidadTransaccion(double cantidadTransaccion) {
        this.cantidadTransaccion = cantidadTransaccion;
    }

    public double getValorUnitarioCompra() {
        return valorUnitarioCompra;
    }

    public void setValorUnitarioCompra(double valorUnitarioCompra) {
        this.valorUnitarioCompra = valorUnitarioCompra;
    }

    public double getValorUnitarioVenta() {
        return valorUnitarioVenta;
    }

    public void setValorUnitarioVenta(double valorUnitarioVenta) {
        this.valorUnitarioVenta = valorUnitarioVenta;
    }

    public Date getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(Date fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public double getIvaTransaccion() {
        return ivaTransaccion;
    }

    public void setIvaTransaccion(double ivaTransaccion) {
        this.ivaTransaccion = ivaTransaccion;
    }

    public String getTipoTransacciones() {
        return tipoTransacciones;
    }

    public void setTipoTransacciones(String tipoTransacciones) {
        this.tipoTransacciones = tipoTransacciones;
    }    
}
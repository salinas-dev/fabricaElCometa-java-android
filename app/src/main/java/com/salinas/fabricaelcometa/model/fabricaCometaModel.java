package com.salinas.fabricaelcometa.model;


public class fabricaCometaModel {


    public android.widget.Toast Toast;
    //Datos del TDA
    private int clave;
    private double materiaPrima;
    private double manObra;
    private double gastoFabricacion;
    private double costoProduccion;
    private double precioVenta;


    //Seters y Geters


    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public double getMateriaPrima() {
        return materiaPrima;
    }

    public void setMateriaPrima(double materiaPrima) {
        this.materiaPrima = materiaPrima;
    }

    public double getManObra() {
        return manObra;
    }

    public void setManObra(double manObra) {
        this.manObra = manObra;
    }

    public double getGastoFabricacion() {
        return gastoFabricacion;
    }

    public void setGastoFabricacion(double gastoFabricacion) {
        this.gastoFabricacion = gastoFabricacion;
    }

    public double getCostoProduccion() {
        return costoProduccion;
    }

    public void setCostoProduccion(double costoProduccion) {
        this.costoProduccion = costoProduccion;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }




    //Operaciones
    public String calcularPrecioVenta() {

        String resultadoPrecioVenta = "";

        if (clave == 3 || clave == 4) {
            manObra = materiaPrima * 0.75;
        }else {

            if (clave == 1 || clave == 5) {
                manObra = materiaPrima * 0.80;
            } else {
                manObra = materiaPrima*0.85;
            }
        }


        if(clave == 2 || clave == 5){
            gastoFabricacion=materiaPrima*0.30;
        }else{

            if(clave == 3 || clave == 6){
                gastoFabricacion=materiaPrima*0.35;
            }else{
                gastoFabricacion=materiaPrima*0.38;
            }
        }

        costoProduccion=materiaPrima+manObra+gastoFabricacion;
        precioVenta=costoProduccion+(costoProduccion*0.45);



        resultadoPrecioVenta= "Valor de costo de produccion: " + costoProduccion +
                "\nValor de gasto de fabricacion: " + gastoFabricacion+
                "\nValor de mano de obra: " + manObra +
                "\nValor de precio de venta: " + precioVenta;

        return resultadoPrecioVenta;
    }
}

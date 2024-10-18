package model;

import java.time.LocalDate;

// Clase abstracta que representa un servicio
public abstract class Servicio {
    private String codServicio; // Código del servicio, debe tener 6 caracteres
    private double porcentajeDescuento; // Porcentaje de descuento aplicable al servicio
    private boolean enPromocion; // Indica si el servicio está en promoción
    
    // Constructor que inicializa los atributos
    public Servicio(String codServicio, double porcentajeDescuento, boolean enPromocion) {
        //verifico que tenga 6 catacteres
        if (codServicio.length() != 6) {
            throw new IllegalArgumentException("El código de servicio debe tener una longitud de 6.");
        } 
        this.codServicio = codServicio; // Guarda el código del servicio
        this.porcentajeDescuento = porcentajeDescuento; // Guarda el porcentaje de descuento
        this.enPromocion = enPromocion; // Indica si está en promoción
    }
    
    // Método abstracto que debe ser implementado en las subclases
    public abstract double calcularPrecioFinal(LocalDate dia);
    
    // Getters
    public String getCodServicio() {
        return codServicio; // Retorna el código del servicio
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento; // Retorna el porcentaje de descuento
    }

    public boolean isEnPromocion() {
        return enPromocion; // Retorna si el servicio está en promoción
    }
}
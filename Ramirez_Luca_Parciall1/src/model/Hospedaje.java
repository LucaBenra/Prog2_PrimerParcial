package model;

import java.time.LocalDate;

// Clase que representa un hospedaje subclase de Servicio
public class Hospedaje extends Servicio {
    private final String tipoHospedaje; // Tipo de hospedaje ej estándar, deluxe
    private final double precioPorNoche; // Precio por cada noche de hospedaje

    // Constructor que inicializa los atributos
    public Hospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, String tipoHospedaje, double precioPorNoche) {
        super(codServicio, porcentajeDescuento, enPromocion);
        this.tipoHospedaje = tipoHospedaje; // Guarda el tipo de hospedaje
        this.precioPorNoche = precioPorNoche; // Guarda el precio por noche
    }

    // Método para calcular el precio final del hospedaje
    @Override
    public double calcularPrecioFinal(LocalDate dia) {
        // Aplica descuento de lunes a viernes (0=domingo, 6=sábado)
        if (isEnPromocion() && dia.getDayOfWeek().getValue() < 6) {
            return precioPorNoche * (1 - getPorcentajeDescuento() / 100); // Aplica descuento
        }// Si no hay promoción, devuelve el precio normal
        return precioPorNoche;
    }
}
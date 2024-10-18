package model;

import java.time.LocalDate;

// Clase que representa un servicio de gastronomía, subclase de Servicio
public class Gastronomia extends Servicio {
    private final String gastronomia; // Nombre del plato o tipo de gastronomía
    private final double precio; // Precio base del servicio de gastronomía
    private final int diaSemDesc; // Día de la semana en que se aplica un descuento (1=lunes, ..., 7=domingo)
    
    // Constructor que inicializa los atributos
    public Gastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, String gastronomia, double precio, int diaSemDesc) {
        super(codServicio, porcentajeDescuento, enPromocion);
        this.gastronomia = gastronomia; // Guarda el nombre del plato
        this.precio = precio; // Guarda el precio base
        this.diaSemDesc = diaSemDesc; // Guarda el día de descuento
    }
    
    // Método para calcular el precio final del servicio de gastronomía
    @Override
    public double calcularPrecioFinal(LocalDate dia) {
        // Aplica descuento si está en promoción y es el día de descuento
        if (isEnPromocion() && dia.getDayOfWeek().getValue() == diaSemDesc) {
            return precio * (1 - getPorcentajeDescuento() / 100); // Aplica el descuento
        }
        return precio; // Si no hay descuento, devuelve el precio normal
    }
}

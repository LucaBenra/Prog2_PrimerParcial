package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private final List<Servicio> lstServicio; // Lista que almacena los servicios
    
    // Constructor que inicaliza la lista de servicios
    public Sistema() {
        lstServicio = new ArrayList<>(); // Crea una nueva lista vacía
    }
    
    // Método para traer un servicio por su código
    public Servicio traerServicio(String codServicio) {
        for (Servicio servicio : lstServicio) {
            if (servicio.getCodServicio().equals(codServicio)) {
                return servicio; // Devuelve el servicio encontrado
            }
        }
        return null; // No encontrado
    }
    
    // Método para traer servicios según su estado de promocion
    public List<Servicio> traerServicio(boolean enPromocion) {
        List<Servicio> result = new ArrayList<>();
        for (Servicio servicio : lstServicio) {
            if (servicio.isEnPromocion() == enPromocion) {
                result.add(servicio); // Agrega el servcio si coincide con el estado de promocion
            }
        }
        return result; // Devuelve la lista de servicios que cumplen con el filtro
    }
    
    // Método sobrecargado para traer servicios según su estado de promoción y fecha
    public List<Servicio> traerServicio(boolean enPromocion, LocalDate dia) {
        List<Servicio> result = new ArrayList<>();
        for (Servicio servicio : lstServicio) {
            if (servicio.isEnPromocion() == enPromocion) {
                result.add(servicio); // Agrega el serviciio si coincide con el estado de promocin
            }
        }
        return result; // Devuelve la lista de servicios filtrados
    }
    
    // Método para agregar un servicio de gastronomía
    public boolean agregarGastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, String gastronomia, double precio, int diaSemDesc) {
        if (traerServicio(codServicio) != null) {
            return false; // Ya existe
        }
        // Crea un nuevo objeto de tipo Gastronomía y lo agrega a la lista
        Gastronomia gastronomy = new Gastronomia(codServicio, porcentajeDescuento, enPromocion, gastronomia, precio, diaSemDesc);
        lstServicio.add(gastronomy); // Agrega el servicio a la lista
        return true; // Indica que se agrego exitosamente
    }
    
    // Método para agregar un servicio de hospedaje
    public boolean agregarHospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, String hospedaje, double precioPorNoche) {
        if (traerServicio(codServicio) != null) {
            return false; // Ya existe
        }
        // Crea un nuevo objeto de tipo Hospedaje y lo agrega a la lista
        Hospedaje lodging = new Hospedaje(codServicio, porcentajeDescuento, enPromocion, hospedaje, precioPorNoche);
        lstServicio.add(lodging); // Agrega el servicio a la lista
        return true; // Indica que se agreg exitosamente
    }
    
    // Método para obtener la lista de servicios
    public List<Servicio> getServicios() {
        return lstServicio; // Devuelve la lisa de servicios
    }
}
package test;

import model.*;
import java.time.LocalDate;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Sistema sistema = new Sistema(); // Crea una instancia del sistema
        
        // Prueba de creación de un servicio de gastronomía
        System.out.println("1-1");
        try {
            // Intento crear un objeto Gastronomía con un código de servicio válido
            Gastronomia g1 = new Gastronomia("004892", 15.0, true, "Hamburguesa criolla", 180.0, 4);
        } catch (IllegalArgumentException e) {
            // Captura y muestra el error si el código no es válido
            System.out.println("Error: " + e.getMessage());
        }
        
        // Agregar un servicio de gastronomía al sistema
        System.out.println("1-2");
        sistema.agregarGastronomia("489235", 15.0, true, "Hamburguesa criolla", 180.0, 4);
        
        // Prueba de creación de un servicio de hospedaj
        System.out.println("1-3");
        try {
            // Intento de crear un objeto Hospedaje con un código de servicio válido
            Hospedaje h1 = new Hospedaje("002872", 10.0, true, "Cabaña 3 personas", 1500.0);
        } catch (IllegalArgumentException e) {
            // Captura y muestra el error si el código no es válido
            System.out.println("Error: " + e.getMessage());
        }
        
        // Agregar un servicio de hospedaje al sistema
        System.out.println("1-4");
        sistema.agregarHospedaje("287282", 10.0, true, "Cabaña 3 personas", 1500.0);
        
        // Calcular el precio final de un servicio de gastronomía
        System.out.println("2-1");
        double precioFinalGastronomia = sistema.traerServicio("489235").calcularPrecioFinal(LocalDate.of(2020, 10, 28));
        System.out.println("Precio final Gastronomia: " + precioFinalGastronomia);
        
        // Calcular el precio final de un servicio de hospedaje
        System.out.println("2-2");
        double precioFinalHospedaje = sistema.traerServicio("287282").calcularPrecioFinal(LocalDate.of(2020, 10, 27));
        System.out.println("Precio final Hospedaje: " + precioFinalHospedaje);
        
        // Imprimo servicios en promoción
        System.out.println("4-1");
        List<Servicio> serviciosEnPromocion = sistema.traerServicio(true);
        for (Servicio s : serviciosEnPromocion) {
            System.out.println(s.getCodServicio());
        }

        // Imprimo servicios en promoción para el día 2020-10-28
        System.out.println("4-2");
        List<Servicio> serviciosEnPromocionDia = sistema.traerServicio(true, LocalDate.of(2020, 10, 28));
        for (Servicio s : serviciosEnPromocionDia) {
            System.out.println(s.getCodServicio()); // Muestra el código del servicio
        }
    }
}
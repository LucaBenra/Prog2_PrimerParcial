# 🏨 Sistema de Servicios de Hospedaje y Gastronomía

---

## Alumno
**Nombre del alumno**: Luca Ramirez

## 📄 Descripción del Proyecto

Este proyecto es un sistema de gestión diseñado para servicios de hospedaje y gastronomía, implementando conceptos de Programación Orientada a Objetos (POO) en Java. El objetivo es crear una aplicación que permita gestionar estos servicios, calcular precios finales con promociones, y validar atributos mediante excepciones cuando sea necesario.

### Objetivos
- Implementar un modelo orientado a objetos que refleje la gestión de servicios de hospedaje y gastronomía.
- Aplicar promociones y descuentos de forma dinámica.
- Validar la integridad de los datos utilizando excepciones adecuadas.

## 🛠️ Funcionalidades del Sistema

El sistema ofrece las siguientes funcionalidades:

### 1. Gestión de Hospedaje
- **Tipos de Habitaciones**: Administración de habitaciones estándar y deluxe.
- **Servicios Adicionales**: Opción de agregar servicios de limpieza y desayuno.
- **Aplicación de Descuentos**: Descuentos aplicables según la duración de la estadía.

### 2. Gestión de Gastronomía
- **Menús**: Posibilidad de agregar diferentes tipos de menús para los servicios de alimentación.
- **Cálculo de Precios**: Precios ajustables con descuentos según el tipo de comida y el día de la semana.

### 3. Promociones y Descuentos
- Implementación de promociones para estadías prolongadas.
- Penalizaciones por no cumplir con los requisitos establecidos, como el número mínimo de noches.

### 4. Validaciones
- Manejo de excepciones para situaciones como códigos duplicados, valores inválidos, y violaciones de las restricciones de negocio.

### 5. Cálculo de Precio Final
- Método para calcular el precio final del servicio, que incluye todas las promociones y servicios adicionales seleccionados.

## 📦 Estructura del Proyecto

El proyecto está compuesto por las siguientes clases y subclases:

### 1. **Servicio** (Clase Abstracta)
- **Atributos**:
   - `codServicio`: Código del servicio, que debe tener una longitud de 6 caracteres.
   - `porcentajeDescuento`: Porcentaje de descuento aplicable al servicio.
   - `enPromocion`: Indica si el servicio está en promoción.
- **Métodos Abstractos**:
   - `calcularPrecioFinal(LocalDate dia)`: Método que debe ser implementado en las subclases para calcular el precio final del servicio.

### 2. **Hospedaje** (Subclase de Servicio)
- **Atributos Específicos**:
   - `tipoHospedaje`: Tipo de hospedaje ofrecido.
   - `precioPorNoche`: Precio por noche de hospedaje.
- **Métodos**:
   - `calcularPrecioTotal(LocalDate dia)`: Calcula el precio final aplicando descuentos específicos si el servicio está en promoción y si la fecha está dentro del rango de días aplicables.

### 3. **Gastronomía** (Subclase de Servicio)
- **Atributos Específicos**:
   - `gastronomia`: Nombre del plato o tipo de gastronomía.
   - `precio`: Precio base del servicio de gastronomía.
   - `diaSemDesc`: Día de la semana en que se aplica un descuento.
- **Métodos**:
   - `calcularPrecioFinal()`: Calcula el precio final de acuerdo con el precio base y aplica el porcentaje de descuento si el servicio está en promoción y se solicita en el día adecuado.

### 4. **Sistema** (Clase de Gestión)
- **Atributos**:
   - `lstServicio`: Lista de objetos de tipo Servicio que contiene todos los servicios disponibles.
- **Métodos**:
   - `traerServicio(String codServicio)`: Retorna el servicio correspondiente al código proporcionado.
   - `traerServicio(boolean enPromocion)`: Retorna una lista de servicios según su estado de promoción.
   - `traerServicio(boolean enPromocion, LocalDate dia)`: Retorna una lista de servicios según su estado de promoción y fecha específica.
   - `agregarGastronomia(...)`: Agrega un nuevo objeto de tipo Gastronomía al sistema.
   - `agregarHospedaje(...)`: Agrega un nuevo objeto de tipo Hospedaje al sistema.

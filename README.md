# actividadEvaluable4📘 
# 📘 Sistema de Exámenes en Java

##  Descripción

Este proyecto implementa un sistema de exámenes en Java que permite responder preguntas y obtener un puntaje final. Incluye ejecución en consola y una interfaz gráfica básica con Swing.

---

## ▶ Compilación y Ejecución

###  Compilar

Ubícate en la carpeta `src` y ejecuta:

```bash
javac com/exam/presentation/Main.java
```

---

### 🔹 Ejecutar

```bash
java com.exam.presentation.Main
```

Luego selecciona:

* `1` → Consola
* `2` → Interfaz gráfica (Swing)

---

## Organización del Proyecto

El proyecto sigue una arquitectura por capas:

* `application` → lógica de aplicación
* `domain` → modelos y reglas de negocio
* `presentation` → interacción con el usuario
* `dto` → transferencia de datos

Esto facilita la separación de responsabilidades y el mantenimiento del código.

---

## Principios SOLID Aplicados

* **S (Single Responsibility Principle)**
  Cada clase tiene una única responsabilidad.
  Ej: `GradingService` solo calcula el puntaje.

* **O (Open/Closed Principle)**
  El sistema permite agregar nuevos tipos de preguntas sin modificar las existentes.
  Ej: nuevas clases que extiendan `Question`.

* **L (Liskov Substitution Principle)**
  Las subclases de `Question` pueden usarse sin afectar el comportamiento del sistema.

* **I (Interface Segregation Principle)**
  Se utilizan clases específicas sin obligar a implementar métodos innecesarios.

* **D (Dependency Inversion Principle)**
  Las capas dependen de abstracciones (ej: `Question`) y no de implementaciones concretas.

---

##  Notas

* El repositorio contiene el código completo funcional.
* Se mantuvo una organización clara de carpetas y paquetes.
* Los commits reflejan el progreso del desarrollo.


-

##  Estado

Funcional
Compilable
Listo para entrega

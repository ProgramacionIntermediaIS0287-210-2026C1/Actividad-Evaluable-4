# Reporte de Calificación - Actividad Evaluable 5
**Estudiante:** Anderson (ID: 202520001615)
**Asignatura:** PROGRAMACIÓN INTERMEDIA - IS0287 - 210
**Rama evaluada:** `202520001615_ANDERSON`

## Análisis de Historias de Usuario Asignadas
El estudiante tenía asignadas las siguientes historias de usuario (HU):
1. **HU02: Estado de Aprobación:** **No implementado**. El sistema finaliza el examen mostrando el puntaje, pero no determina ni muestra un estado de "Aprobado" o "Reprobado" basado en un umbral de calificación, ni en la lógica de dominio ni en la presentación.
2. **HU07: Prevención Respuestas Vacías:** **Parcialmente implementado**. Se evidencia un intento de prevención en la interfaz gráfica (`SwingUI`), donde se lanza una advertencia si la respuesta está vacía, pero permite al usuario continuar si así lo decide. No se implementó validación de dominio en el Value Object `AnswerText` ni en la interfaz por consola (`ConsoleUI`).
3. **HU12: Exportar Calificaciones:** **No implementado**. No hay evidencia de lógica para exportar los resultados del examen a un archivo (ej. CSV, txt) en ninguna de las capas de la aplicación.

## Criterios de Evaluación y Calificación

El proyecto base compila correctamente y ejecuta el flujo de un examen utilizando los principios SOLID y Arquitectura Limpia con DDD. Sin embargo, la calificación está fuertemente penalizada por la ausencia de las Historias de Usuario asignadas específicamente al estudiante.

| Criterio | Peso Máximo (Puntos) | Puntos Obtenidos | Observaciones |
| :--- | :---: | :---: | :--- |
| **Correctitud funcional** | 10.0 | **3.0** | La aplicación base compila y ejecuta correctamente, permitiendo el ciclo completo del examen. Sin embargo, no se implementaron HU02 ni HU12, y HU07 solo se implementó parcialmente a nivel de la interfaz Swing como una advertencia (no estricta). |
| **Aplicación de principios SOLID** | 12.5 | **10.0** | Buen diseño general en el proyecto base, clara separación de capas y uso de abstracciones (interfaces de repositorio, polimorfismo para renderizado y tipos de preguntas). |
| **Modelado de dominio y DDD** | 10.0 | **7.5** | Correcto uso de entidades y servicios de dominio. Uso de *Value Objects* mediante records, pero faltó enriquecerlos con reglas de negocio (ej. validación contra cadenas vacías en `AnswerText` para cumplir con HU07 a nivel de dominio). |
| **Calidad del código y buenas prácticas** | 10.0 | **7.5** | Código limpio y estructurado en paquetes legibles. Falta de manejo de algunas restricciones de negocio asignadas que reducen la calidad de la entrega funcional. |
| **Entrega y documentación** | 7.5 | **6.0** | El repositorio cuenta con un buen `README.md`, `.gitignore` y diagramas, aunque el historial de commits muestra mensajes poco descriptivos (ej. "cambios", "Changes Made:"). |
| **TOTAL** | **50.0** | **34.0** | |

### **Nota Final: 34.0 / 50.0**

## Conclusión
El proyecto base sobre el que se trabajó posee una arquitectura sólida (DDD, Clean Architecture) y funciona de acuerdo con el caso de uso base. No obstante, la evaluación de las HU individuales evidencia un bajo nivel de completitud de las tareas específicamente encomendadas a este estudiante. Se recomienda aplicar la lógica de validación directamente en la capa de Dominio (Value Objects) y completar las características faltantes.

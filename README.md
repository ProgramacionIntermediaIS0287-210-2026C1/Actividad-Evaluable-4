# actividadEvaluable4# Sistema de Exámenes en Java

## Cómo ejecutar
javac presentation/Main.java
java presentation.Main

## Principios SOLID

- SRP: Cada clase tiene una única responsabilidad
- OCP: Se pueden agregar nuevos tipos de preguntas sin modificar código existente
- LSP: Todas las preguntas funcionan como Question
- ISP: No se usan interfaces innecesarias
- DIP: La lógica depende de abstracciones

## Arquitectura

- domain: lógica de negocio
- application: casos de uso
- infrastructure: CSV
- presentation: consola
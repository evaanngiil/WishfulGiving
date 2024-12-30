# Testing en Java - Aserciones

## Criterios comunes

Para elegir la biblioteca de aserciones en Java, se han considerado los siguientes criterios principales:

- Evitar la dependencia de liberías externas. Es decir, se priorizan herramientas nativas o ampliamente adoptadas en el ecosistema estándar de Java para reducir la complejidad y la deuda técnica.

- Se consideran herramientas con métricas objetivas de mantenimiento, tales como actividad reciente en el repositorio (commits en el último año), volumen de contribuciones y número de versiones estables lanzadas en el último año.

- Deben integrarse fácilmente con sistemas como Maven o Gradle, incluyendo soporte nativo para configuración y ejecución de pruebas.

## Selección de Biblioteca de Aserciones

Java no proporciona un sistema robusto de aserciones más allá del uso básico de assert. Por ello, se consideran bibliotecas externas que complementen las necesidades del desarrollo moderno.

### Opciones de Bibliotecas de Aserciones:

- **[JUnit 5](https://github.com/junit-team/junit5)** se destaca como una biblioteca de aserciones integrada con su test runner estándar. De acuerdo con su repositorio oficial en *GitHub*, ha recibido actualizaciones recientes (al menos dos commits en el último trimestre) y su última versión estable fue lanzada en el último año. Ofrece métodos como `assertEquals`, `assertTrue` y `assertThrows`, cubriendo la mayoría de los casos comunes. Su integración con Maven y Gradle garantiza compatibilidad sin necesidad de configuraciones adicionales.

- **[AssertJ](https://assertj.github.io/doc)**, por otro lado, proporciona una API fluida que permite escribir pruebas altamente legibles, especialmente útil para objetos complejos. Sin embargo, según las métricas de actividad en su repositorio oficial, tiene menos actualizaciones recientes en comparación con JUnit 5. Requiere instalación adicional y podría introducir dependencias innecesarias en proyectos simples.

- **[Hamcrest](https://github.com/hamcrest/JavaHamcrest)** es conocida por sus `Matchers` que permiten escribir pruebas expresivas. Sin embargo, las estadísticas de *GitHub* indican que su repositorio principal ha tenido menos actividad reciente y su última versión estable data de hace más de un año, lo que podría afectar su mantenimiento a largo plazo.

## Elección de Biblioteca de Aserciones

Se selecciona **JUnit 5** como biblioteca de aserciones debido a su integración nativa con herramientas estándar, su mantenimiento activo y su flexibilidad, cumpliendo con los criterios de evitar dependencias adicionales y garantizar la compatibilidad con el ecosistema de Java.
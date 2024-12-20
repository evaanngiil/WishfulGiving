# Testing en Java: Test runners

Para elegir nuestro test runner o framework en Java, debemos tener en cuenta los criterios siguientes criterios:

- **Soporte para paralelismo o concurrencia.**
- **Capacidad para aislar tests o grupos de tests.**
- **Facilidad de integración con herramientas de CI/CD.**
- **Popularidad y soporte de la comunidad.**
- **Impacto en la deuda técnica**

### Estándar - JUnit

JUnit es el framework estándar para realizar pruebas en Java. Su versión actual, JUnit 5, introduce una arquitectura modular que mejora el soporte para pruebas unitarias y de integración, además de permitir paralelismo mediante configuraciones específicas. La anotación `@Test` identifica los métodos de prueba, mientras que características como `@Nested` y `@Tag` facilitan la agrupación y organización de tests. Es altamente compatible con herramientas como Maven y Gradle, lo que asegura su integración en pipelines de CI/CD y evita deuda técnica.

### TestNG

TestNG es un framework avanzado diseñado para pruebas jerárquicas y más complejas. Ofrece soporte nativo para paralelismo y priorización, permitiendo definir dependencias entre tests y agruparlos mediante XML. Esto lo convierte en una herramienta flexible para proyectos que requieren un control detallado sobre la ejecución de las pruebas. Sin embargo, debido a que JUnit es más comúnmente utilizado, TestNG puede generar complejidad adicional en entornos estándar.

### Spock

Spock es un framework basado en Groovy que combina pruebas unitarias, funcionales y de comportamiento (BDD) en un único enfoque. Su sintaxis concisa y expresiva permite escribir pruebas de manera clara y legible. Aunque es compatible con JUnit, su uso está más orientado a proyectos que aprovechan Groovy, lo que puede no ser adecuado para proyectos estrictamente en Java.

### Arquillian

Arquillian está diseñado para pruebas de integración en aplicaciones Java EE o Jakarta EE. Permite ejecutar pruebas dentro de contenedores reales, como WildFly o GlassFish, simulando entornos de producción. Esto lo hace ideal para pruebas end-to-end en proyectos complejos, pero no es práctico para pruebas unitarias simples o proyectos que no requieren interacción con contenedores.

# Herramientas CLI

En el caso de Java, lo habitual para compilar y ejecutar los tests es usar las herramientas estándar integradas en los sistemas de construcción como Maven o Gradle. Sin embargo, Gradle se destaca por su enfoque moderno y eficiente en la gestión de tareas de construcción y pruebas entre otras cosas destacadas [aquí](gestor_tareas.md).

Gradle permite ejecutar tests con el comando gradle test, que utiliza por defecto frameworks como JUnit o TestNG según la configuración del proyecto. Su principal ventaja es el soporte nativo para paralelismo y su capacidad para reutilizar resultados de pruebas a través de un sistema de caché incremental, lo que optimiza los tiempos de ejecución, especialmente en entornos de CI/CD.

Simplemente, el comando a utilizar es `gradle test`, con opciones adicionales configurables directamente en el archivo `build.gradle` según las necesidades del proyecto.

# Elección de test runner

Para un proyecto estándar, el uso de JUnit 5 es la mejor opción, ya que combina simplicidad, soporte nativo y compatibilidad con herramientas ampliamente adoptadas, como Maven o Gradle. En proyectos más complejos que requieren paralelismo avanzado, TestNG puede ser una alternativa válida. Para proyectos con pruebas de integración en entornos reales, Arquillian sería el framework ideal, mientras que Spock es más adecuado para aquellos que buscan una sintaxis clara y legible en pruebas con Groovy.
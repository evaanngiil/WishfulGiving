# Testing en Java: Test runners

El test runner es fundamental para ejecutar y organizar los tests que verifican la calidad de un software como se expresa en #29. En Java, existen varios frameworks que se pueden utilizar para realizar tests. Elegiremos uno de ellos basándonos en los mismos criterios que utilizamos para elegir la [biblioteca de aserciones](testing_aserciones.md). (Evitar dependencias externas, mantenimiento activo y capacidad de integrarse con herramientas CLI).

### Estándar - [JUnit 5](https://github.com/junit-team/junit5)

JUnit 5 es el estándar en Java para la ejecución de pruebas. Según su repositorio en GitHub, cuenta con alta actividad de mantenimiento, con múltiples contribuciones activas y al menos dos versiones estables lanzadas en el último año. Ofrece soporte para pruebas paralelas, agrupación mediante anotaciones como `@Tag`, y compatibilidad nativa con *Maven* y *Gradle*.

### [TestNG](https://github.com/testng-team/testng)

Destaca por su capacidad para manejar dependencias entre pruebas y ejecutar *suites* (conjuntos de tests agrupados) de manera jerárquica. Sin embargo, según las métricas de *GitHub*, tiene una actividad algo menor en comparación con JUnit y podría no ajustarse a proyectos estándar debido a su complejidad adicional.

### [Spock](https://github.com/spockframework/spock)

Spock es un framework basado en *Groovy* que combina pruebas unitarias, funcionales y de comportamiento (BDD) en un único enfoque. Su sintaxis concisa y expresiva permite escribir pruebas de manera clara y legible. Aunque es compatible con JUnit, su uso está más orientado a proyectos que aprovechan Groovy, lo que puede no ser adecuado para proyectos estrictamente en Java.

### [Arquillian](https://github.com/arquillian)

Arquillian está diseñado para pruebas de integración en aplicaciones *Java EE* o *Jakarta EE*. Permite ejecutar pruebas dentro de contenedores reales, como *WildFly* o *GlassFish*, simulando entornos de producción. Esto lo hace ideal para pruebas end-to-end en proyectos complejos, pero no es práctico para pruebas unitarias simples o proyectos que no requieren interacción con contenedores.

# Herramientas CLI

En el caso de Java, lo habitual para compilar y ejecutar los tests es usar las herramientas estándar integradas en los sistemas de construcción como Maven o Gradle. Sin embargo, Gradle se destaca por su enfoque moderno y eficiente en la gestión de tareas de construcción y pruebas como ya se vió [aquí](gestor_tareas.md).

Gradle permite ejecutar tests con el comando `gradle test`, que utiliza por defecto frameworks como JUnit o TestNG según la configuración del proyecto. 

# Elección de test runner

Se elige **JUnit 5** como test runner principal por su simplicidad, soporte nativo en el ecosistema Java, mantenimiento activo y capacidad de satisfacer los requisitos comunes de pruebas. Para escenarios específicos, como pruebas de integración complejas, se podrían considerar opciones adicionales como Arquillian
# Testing en Java: Test runners

El test runner es fundamental para ejecutar y organizar los tests que verifican la calidad de un software como se expresa en #29. En Java, existen varios frameworks que se pueden utilizar para realizar tests. Elegiremos uno de ellos basándonos en los mismos criterios comunes que utilizamos para elegir la [biblioteca de aserciones](testing_aserciones.md) destacados en #25. (Evitar dependencias externas, mantenimiento activo y capacidad de integrarse con herramientas CLI).

### Estándar - [JUnit 5](https://github.com/junit-team/junit5)

JUnit 5 es el estándar en Java para la ejecución de pruebas. Según su repositorio en GitHub, cuenta con alta actividad de mantenimiento, con múltiples contribuciones activas y al menos dos versiones estables lanzadas en el último año. Ofrece soporte para pruebas paralelas, agrupación mediante anotaciones como `@Tag`, y compatibilidad nativa con *Maven* y *Gradle*.

### [TestNG](https://github.com/testng-team/testng)

Aunque popular, su adopción ha disminuido frente a JUnit 5..  Según las métricas de *GitHub*, tiene una actividad algo menor en comparación con JUnit y podría no ajustarse a proyectos estándar debido a su complejidad adicional. Compatible con Maven y Gradle, pero requiere configuraciones adicionales para aprovechar funcionalidades avanzadas. Como son las dependencias explícitas entre pruebas (JUnit no lo soporta) y ejecución de *suites* jerárquicas . 

### [Spock](https://github.com/spockframework/spock)

Su uso está enfocado en proyectos que utilizannel lenguaje Groovy, lo que lo hace menos adecuado para Java puro. Cuenta con una actividad al nivel de JUnit 5 en *GitHub*, con versiones recientes lanzadas. Pero no cumple completamente con el criterio de integración, ya que su dependencia de Groovy y la configuración adicional necesaria en Maven o Gradle lo hacen menos práctico para proyectos Java puro.

# Herramientas CLI

En el caso de Java, lo habitual para compilar y ejecutar los tests es usar las herramientas estándar integradas en los sistemas de construcción como Maven o Gradle. Sin embargo, Gradle se destaca por su enfoque moderno y eficiente en la gestión de tareas de construcción y pruebas como ya se vió [aquí](gestor_tareas.md).

Gradle permite ejecutar tests con el comando `gradle test`, que utiliza por defecto frameworks como JUnit o TestNG según la configuración del proyecto. 

# Elección de test runner

Se elige **JUnit 5** como test runner principal por su simplicidad, soporte nativo en el ecosistema Java, mantenimiento activo y capacidad de satisfacer los requisitos comunes de pruebas. Para escenarios específicos, como pruebas de integración complejas, se podrían considerar opciones adicionales como Arquillian. 

Para ejecutar los tests con la herramienta CLI elegida debemos ejecutar el comando `./gradlew test`. Este comando utiliza el wrapper de Gradle para ejecutar los tests con JUnit 5.
# Testing en Java: Test runners

El test runner es fundamental para ejecutar y organizar los tests que verifican la calidad de un software como se expresa en #29. En Java, existen varios frameworks que se pueden utilizar para realizar tests. Elegiremos uno de ellos basándonos en los mismos criterios comunes que utilizamos para elegir la [biblioteca de aserciones](testing_aserciones.md) destacados en #25. (Evitar dependencias externas, mantenimiento activo y capacidad de integrarse con herramientas CLI).

Además, añadiremos un nuevo criterio de elección: 4. **Características avanzadas**. Considerar características como paralelización, dependencias entre tests y suites jerárquicas para optimizar tiempos y estructuras complejas. 

En este documento se mencionan conceptos claves como Test Engines que puedes ver descritos [aquí](testing_testengine.md).

### Estándar - [JUnit 5](https://github.com/junit-team/junit5)

JUnit 5 es considerado el estándar de facto en Java para la ejecución de pruebas unitarias debido a su adopción masiva en la comunidad de desarrolladores, su soporte integrado en herramientas populares como IntelliJ IDEA, Eclipse, Maven y Gradle, y su diseño modular y extensible. Aunque no viene incluido en las distribuciones oficiales de Java SE o JDK, su instalación es sencilla mediante los sistemas de construcción más utilizados. Además, cuenta con alta actividad de mantenimiento en su repositorio de GitHub, con múltiples contribuciones activas y al menos dos versiones estables lanzadas en el último año.

JUnit 5 requiere del uso de JUnit Jupiter y Platform para ejecutar los test, por ello se especificarán estas dependencias en el `build.gradle` de nuestro proyecto. Estas dependencias son mínimas y esenciales para su funcionamiento, mientras que otras bibliotecas como AssertJ y Hamcrest aumentan la carga de dependencias y configuraciones al no ser parte del ecosistema estándar..

La forma básica de utilizarlo es anotando los tests con la anotación `@Test`. 
Gracias a su Test Engine Jupiter soporta características avanzadas como `@BeforeEach` (para ejecutar código antes de cada test), `@AfterEach` (para realizar la limpieza o el "*tear down* después de cada test), agrupación mediante anotaciones como `@Tag`, pruebas parametrizadas y paralelas. Además éste permite integrar bibliotecas adicionales (e.g., AssertJ, Hamcrest) para personalizar las aserciones sin necesidad de añadir confirguraciones adicionales en el `build.gradle`.

### [TestNG](https://github.com/testng-team/testng)

TestNG sigue siendo una herramienta útil para casos complejos gracias a características avanzadas como la capacidad de establecer dependencias entre pruebas y ejecutar suites jerárquicas. Sin embargo, en proyectos sencillos, estas capacidades pueden no ser necesarias. JUnit 5, al ser más directo en su configuración y enfoque, se adapta mejor a este proyecto y cumple con el criterio de evitar dependencias externas adicionales, ya que es más estándar en proyectos Java actuales. Ambos ofrecen bibliotecas de aserciones, pero mientras TestNG destaca por su flexibilidad en la ejecución, JUnit 5 es preferido por su simplicidad y adopción más amplia en la comunidad.

Finalmente, haciendo mención al uso de Test Engines, TestNG cuenta con su propio test engine y se integra con la JUnit Platform.

### [Spock](https://github.com/spockframework/spock)

**Spock - Spec como concepto**
Spock es un framework de testing y especificaciones para aplicaciones Java y Groovy. Actúa como un test runner y como una biblioteca de aserciones. Su principal característica es el uso de "specs" (especificaciones), que permiten escribir tests de una manera mucho más descriptiva y legible, siguiendo un estilo inspirado en BDD (Behavior-Driven Development) el cual no es el que estamos siguiendo en este objetivo (TDD)..

 Spock Cuenta con una actividad al nivel de JUnit 5 en *GitHub*, con versiones recientes lanzadas. Spock tiene su propio test engine y se integra con la JUnit Platform. Sin embargo, no cumple completamente con el criterio de integración, ya que su dependencia de Groovy y la configuración adicional necesaria en Maven o Gradle lo hacen menos práctico para proyectos Java puro.

# Herramientas CLI

En el caso de Java, lo habitual para compilar y ejecutar los tests es usar las herramientas estándar integradas en los sistemas de construcción como Maven o Gradle.
No obstante, para ejecutar pruebas con un test runner, es obligatorio definir explícitamente el motor de pruebas (*Test Engine)*. Por ejemplo, al usar *JUnit 5*, es necesario especificar `org.junit.jupiter:junit-jupiter `como dependencia en el archivo de configuración del sistema de construcción. Esto asegura que Gradle pueda reconocer y ejecutar los tests correctamente.

La elección de Gradle o Maven como herramienta de construcción no afecta directamente al motor de pruebas utilizado, pero sí influye en la eficiencia y personalización del flujo de trabajo. Por esta razón, aunque la elección de la herramienta CLI no sea crítica para el ecosistema Java, la correcta configuración del Test Engine es esencial para ejecutar pruebas de manera adecuada.

Ejemplo de configuración en Gradle para usar el engine Jupiter del que depende JUnit 5:

```gradle
dependencies {
    testImplementation 'org.junit.jupiter:junit-jupiter:5.10.0'
}
```

Gradle permite ejecutar tests con el comando `gradle test`, que utiliza por defecto frameworks como JUnit o TestNG según la configuración del proyecto.

# Elección de test runner

Se elige **JUnit 5** como test runner principal por su simplicidad, soporte nativo en el ecosistema Java, mantenimiento activo y capacidad de satisfacer los requisitos comunes de pruebas. Para escenarios específicos, como pruebas de integración complejas, se podrían considerar opciones adicionales como Arquillian. 

Para ejecutar los tests con la herramienta CLI elegida debemos ejecutar el comando `./gradlew test`. Este comando utiliza el wrapper de Gradle para ejecutar los tests con JUnit 5.
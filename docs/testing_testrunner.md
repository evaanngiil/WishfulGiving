# Testing en Java: Test runners

El test runner es fundamental para ejecutar y organizar los tests que verifican la calidad de un software como se expresa en #29. En Java, existen varios frameworks que se pueden utilizar para realizar tests. Elegiremos uno de ellos basándonos en los mismos criterios comunes que utilizamos para elegir la [biblioteca de aserciones](testing_aserciones.md) destacados en #25. (Evitar dependencias externas, mantenimiento activo y capacidad de integrarse con herramientas CLI).

Además, añadiremos un nuevo criterio de elección: 4. **Características avanzadas**. Considerar características como paralelización, dependencias entre tests y suites jerárquicas para optimizar tiempos y estructuras complejas. 

Es importante diferenciar entre un framework de testing (como JUnit) y un motor de pruebas (Test Engine). El framework proporciona la estructura para escribir las pruebas (anotaciones, aserciones), mientras que el motor de pruebas es el responsable de descubrir y ejecutar las pruebas.

### Estándar - [JUnit 5](https://github.com/junit-team/junit5)

JUnit 5 es el estándar en Java para la ejecución de pruebas. Según su repositorio en GitHub, cuenta con alta actividad de mantenimiento, con múltiples contribuciones activas y al menos dos versiones estables lanzadas en el último año.

JUnit se compone de tres submódulos:

- **JUnit Platform**: Es la base para lanzar frameworks de testing en la JVM. Define la API `TestEngine` que permite la integración de diferentes motores de pruebas.
- **JUnit Jupiter**: Es el nuevo modelo de programación para escribir tests en JUnit 5. Incluye las nuevas anotaciones (`@Test`,` @BeforeEach`, `@AfterEach`, etc.) y el motor de pruebas que las ejecuta.
- **JUnit Vintage**: Proporciona un `TestEngine` para ejecutar tests escritos con versiones anteriores de JUnit (JUnit 3 y 4), permitiendo la compatibilidad hacia atrás.

JUnit 5 requiere del uso de JUnit Jupiter y Platform para ejecutar los test, por ello se especificarán estas dependencias en el `build.gradle` de nuestro proyecto. Estas dependencias son mínimas y esenciales para su funcionamiento, mientras que otras bibliotecas como AssertJ y Hamcrest aumentan la carga de dependencias y configuraciones al no ser parte del ecosistema estándar..

La forma básica de utilizarlo es anotando los tests con la anotación `@Test`. 
Gracias a su Test Engine Jupiter soporta características avanzadas como `@BeforeEach` (para ejecutar código antes de cada test), `@AfterEach` (para realizar la limpieza o el "*tear down* después de cada test), agrupación mediante anotaciones como `@Tag`, pruebas parametrizadas y paralelas. Además éste permite integrar bibliotecas adicionales (e.g., AssertJ, Hamcrest) para personalizar las aserciones sin necesidad de añadir confirguraciones adicionales en el `build.gradle`.

### [TestNG](https://github.com/testng-team/testng)

TestNG sigue siendo una herramienta útil para casos complejos gracias a características avanzadas como la capacidad de establecer dependencias entre pruebas y ejecutar suites jerárquicas. Sin embargo, en proyectos sencillos, estas capacidades pueden no ser necesarias. JUnit 5, al ser más directo en su configuración y enfoque, se adapta mejor a este proyecto y cumple con el criterio de evitar dependencias externas adicionales, ya que es más estándar en proyectos Java actuales. Ambos ofrecen bibliotecas de aserciones, pero mientras TestNG destaca por su flexibilidad en la ejecución, JUnit 5 es preferido por su simplicidad y adopción más amplia en la comunidad.

Finalmente, haciendo mención al uso de Test Engines, TestNG cuenta con su propio test engine y se integra con la JUnit Platform.

### [Spock](https://github.com/spockframework/spock)

**Spock - Spec como concepto**
Spock es un framework de testing y especificaciones para aplicaciones Java y Groovy. Su principal característica es el uso de "specs" (especificaciones), que permiten escribir tests de una manera mucho más descriptiva y legible, siguiendo un estilo inspirado en BDD (Behavior-Driven Development) el cual no es el que estamos siguiendo en este objetivo (TDD).

A diferencia de JUnit, que se centra en aserciones individuales, Spock se centra en describir el comportamiento del sistema bajo prueba a través de bloques lógicos que representan las diferentes fases de una prueba: `given`, `when`, `then`, `expect` y `cleanup`.

Un ejemplo de uso podria ser:

    def "Sumar dos números positivos"() {
        given: "Una calculadora"
        Calculadora calculadora = new Calculadora()

        when: "Sumamos 2 y 3"
        int resultado = calculadora.sumar(2, 3)

        then: "El resultado es 5"
        resultado == 5
    }

 Spock Cuenta con una actividad al nivel de JUnit 5 en *GitHub*, con versiones recientes lanzadas. Spock tiene su propio test engine y se integra con la JUnit Platform. Sin embargo, no cumple completamente con el criterio de integración, ya que su dependencia de Groovy y la configuración adicional necesaria en Maven o Gradle lo hacen menos práctico para proyectos Java puro.

# Herramientas CLI

En el caso de Java, lo habitual para compilar y ejecutar los tests es usar las herramientas estándar integradas en los sistemas de construcción como Maven o Gradle. Sin embargo, Gradle se destaca por su enfoque moderno y eficiente en la gestión de tareas de construcción y pruebas como ya se vió [aquí](gestor_tareas.md).

Para compilar y ejecutar las pruebas en **Gradle** se requiere definir explícitamente el *testing engine* en el archivo de configuración (`build.gradle`).  

Ejemplo de configuración en Gradle para usar el engine Jupiter:

```gradle
dependencies {
    testImplementation 'org.junit.jupiter:junit-jupiter:5.10.0'
}
```

Gradle permite ejecutar tests con el comando `gradle test`, que utiliza por defecto frameworks como JUnit o TestNG según la configuración del proyecto.

# Elección de test runner

Se elige **JUnit 5** como test runner principal por su simplicidad, soporte nativo en el ecosistema Java, mantenimiento activo y capacidad de satisfacer los requisitos comunes de pruebas. Para escenarios específicos, como pruebas de integración complejas, se podrían considerar opciones adicionales como Arquillian. 

Para ejecutar los tests con la herramienta CLI elegida debemos ejecutar el comando `./gradlew test`. Este comando utiliza el wrapper de Gradle para ejecutar los tests con JUnit 5.
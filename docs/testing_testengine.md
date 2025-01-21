# Testing Engines

En el ecosistema de Java, las bibliotecas de aserciones y los test runners están respaldados por **testing engines**, que definen cómo se ejecutan y gestionan las pruebas. 

Es importante diferenciar entre un framework de testing (como JUnit) y un motor de pruebas (Test Engine). El framework proporciona la estructura para escribir las pruebas (anotaciones, aserciones), mientras que el motor de pruebas es el responsable de descubrir y ejecutar las pruebas.

**JUnit**, por ejemplo, introduce los siguientes engines:  

- **JUnit Platform**: Es la base para lanzar frameworks de testing en la JVM. Define la API `TestEngine` que permite la integración de diferentes motores de pruebas.
- **JUnit Jupiter**: Es el nuevo modelo de programación para escribir tests en JUnit 5. Incluye las nuevas anotaciones (`@Test`,` @BeforeEach`, `@AfterEach`, etc.) y el motor de pruebas que las ejecuta.
- **JUnit Vintage**: Proporciona un `TestEngine` para ejecutar tests escritos con versiones anteriores de JUnit (JUnit 3 y 4), permitiendo la compatibilidad hacia atrás.

Los testing engines permiten la integración de múltiples enfoques y bibliotecas bajo un mismo framework, ofreciendo flexibilidad en la configuración y ejecución de pruebas. Por convención, ya que vamos a usar JUnit 5, se elige **Jupiter** como testing engine.
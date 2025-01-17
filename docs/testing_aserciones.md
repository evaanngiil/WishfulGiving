# Testing en Java - Aserciones

## Criterios comunes

Para elegir la biblioteca de aserciones en Java, se han considerado los siguientes criterios principales:

- Evitar la dependencia de librerías externas. Es decir, se priorizan herramientas nativas en el ecosistema estándar de Java para reducir la complejidad y la deuda técnica.

- Se consideran herramientas con métricas objetivas de mantenimiento, tales como actividad reciente en el repositorio (commits en el último año), volumen de contribuciones y número de versiones estables lanzadas en el último año.

- Deben integrarse fácilmente con sistemas como Maven o Gradle, incluyendo soporte nativo para configuración y ejecución de tests.

## Selección de Biblioteca de Aserciones

Java no proporciona un sistema robusto de aserciones más allá del uso básico de `assert`. Por ello, se consideran bibliotecas externas que complementen las necesidades del desarrollo moderno.

### Opciones de Bibliotecas de Aserciones:

- **[JUnit 5](https://github.com/junit-team/junit5)** se destaca como una biblioteca de aserciones integrada con su test runner estándar. De acuerdo con su repositorio oficial en *GitHub*, ha recibido actualizaciones recientes (al menos dos commits en el último trimestre) y su última versión estable fue lanzada en el último año. Su integración con Maven y Gradle garantiza compatibilidad sin necesidad de configuraciones adicionales.

- **[AssertJ](https://assertj.github.io/doc)** es una biblioteca bien conocida en Java, pero no es considerada nativa ni estándar..Aunque funcional, su actividad en *GitHub* es menor comparada con *JUnit 5*, y las actualizaciones recientes son limitadas. *AssertJ* no cumple completamente con el criterio de integración con herramientas CLI, ya que requiere configuración adicional en Maven o Gradle y no es una biblioteca nativa. Esto puede generar una mayor complejidad en proyectos simples.

- **[Hamcrest](https://github.com/hamcrest/JavaHamcrest)**  aunque fue ampliamente utilizado en el pasado, ha perdido relevancia frente a JUnit 5 y AssertJ. Tiene baja actividad en su repositorio de *GitHub*, con la última versión estable lanzada hace más de un año. Es compatible con Maven y Gradle, pero requiere configuración adicional, por lo que podría incrementar la deuda técnica.

## Elección de Biblioteca de Aserciones

Se selecciona **JUnit 5** como biblioteca de aserciones debido a que esta incluida en la biblioteca estándar de Java, a su mantenimiento activo y su flexibilidad. **JUnit 5** requiere dependencias, pero estas son mínimas y esenciales para su funcionamiento, mientras que otras bibliotecas como AssertJ y Hamcrest aumentan la carga de dependencias y configuraciones al no ser parte del ecosistema estándar

### Testing Engines

En el ecosistema de Java, las bibliotecas de aserciones y los test runners están respaldados por **testing engines**, que definen cómo se ejecutan y gestionan las pruebas. **JUnit**, por ejemplo, introduce los siguientes engines:  

- **Jupiter**: Engine moderno de JUnit 5 para pruebas unitarias. Soporta características como `@BeforeEach`, `@AfterEach` y pruebas parametrizadas.  
- **Vintage**: Engine para ejecutar pruebas escritas con versiones anteriores de JUnit (3 y 4), proporcionando compatibilidad retroactiva.  

Los testing engines permiten la integración de múltiples enfoques y bibliotecas bajo un mismo framework, ofreciendo flexibilidad en la configuración y ejecución de pruebas. Por convención, ya que vamos a usar JUnit 5, se elige **Jupiter** como testing engine.
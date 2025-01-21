# Testing en Java - Aserciones

## Criterios comunes

Para elegir la biblioteca de aserciones en Java, se han considerado los siguientes criterios principales:

- Evitar la dependencia de librerías externas. Es decir, se priorizan herramientas nativas en el ecosistema estándar de Java para reducir la complejidad y la deuda técnica.

- Se consideran herramientas con métricas objetivas de mantenimiento, tales como actividad reciente en el repositorio (commits en el último año), volumen de contribuciones y número de versiones estables lanzadas en el último año. En caso de la herramienta sea estable y madura se valorará positivamente omitiendo lo aspectos de actividad reciente.

- Deben integrarse fácilmente con sistemas como Maven o Gradle, incluyendo soporte nativo para configuración y ejecución de tests.

## Selección de Biblioteca de Aserciones

Java no proporciona un sistema robusto de aserciones más allá del uso básico de `assert`. Por ello, se consideran bibliotecas externas que complementen las necesidades del desarrollo moderno.

### Opciones de Bibliotecas de Aserciones:

- **[JUnit 5](https://github.com/junit-team/junit5)** se destaca como una biblioteca de aserciones integrada con su test runner estándar. De acuerdo con su repositorio oficial en *GitHub*, ha recibido actualizaciones recientes (al menos dos commits en el último trimestre) y su última versión estable fue lanzada en el último año. Su integración con Maven y Gradle garantiza compatibilidad sin necesidad de configuraciones adicionales.

- **[TestNG](https://github.com/testng-team/testng)**  es un framework de testing potente que también proporciona su propia biblioteca de aserciones. Aunque no es parte del JDK estándar, es una opción popular en la comunidad Java. TestNG ofrece características avanzadas como ejecución paralela de pruebas, pruebas parametrizadas, dependencias entre pruebas y generación de reportes detallados. En cuanto a su mantenimiento, TestNG sigue activo, aunque con un ritmo de actualizaciones que puede variar. Su integración con Maven y Gradle es robusta y bien soportada.

- **[Spock](https://github.com/spockframework/spock)**  a diferencia de JUnit, que se centra en aserciones individuales, se centra en describir el comportamiento del sistema bajo prueba a través de bloques lógicos que representan las diferentes fases de un test. Spock utiliza un estilo de aserciones BDD, que se asemeja más al lenguaje natural, utilizando expresiones booleanas dentro del bloque `then` (o `expect`) para verificar las condiciones.

En términos de mantenimiento, Spock cuenta con una actividad similar a JUnit 5 en GitHub, con actualizaciones recientes y una comunidad activa. Sin embargo, su dependencia de Groovy introduce una barrera de entrada adicional para proyectos de Java puro, dificultando el cumplimiento del criterio de evitar dependencias externas.

- **[AssertJ](https://assertj.github.io/doc)** es una biblioteca bien conocida en Java, pero no es considerada nativa ni estándar..Aunque funcional, su actividad en *GitHub* es menor comparada con *JUnit 5*, y las actualizaciones recientes son limitadas. *AssertJ* no cumple completamente con el criterio de integración con herramientas CLI, ya que requiere configuración adicional en Maven o Gradle y no es una biblioteca nativa. Esto puede generar una mayor complejidad en proyectos simples.

- **[Hamcrest](https://github.com/hamcrest/JavaHamcrest)**  aunque fue ampliamente utilizado en el pasado, ha perdido relevancia frente a JUnit 5 y AssertJ. Tiene baja actividad en su repositorio de *GitHub*, con la última versión estable lanzada hace más de un año. Es compatible con Maven y Gradle, pero requiere configuración adicional, por lo que podría incrementar la deuda técnica.

## Elección de Biblioteca de Aserciones

Se selecciona **JUnit 5** como biblioteca de aserciones debido a que esta incluida en la biblioteca estándar de Java, a su mantenimiento activo y su flexibilidad. **JUnit 5** requiere dependencias, pero estas son mínimas y esenciales para su funcionamiento, mientras que otras bibliotecas como AssertJ y Hamcrest aumentan la carga de dependencias y configuraciones al no ser parte del ecosistema estándar

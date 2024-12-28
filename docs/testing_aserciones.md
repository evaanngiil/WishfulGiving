# Testing en Java
## Aserciones

Para elegir la biblioteca de aserciones en Java, se han considerado los siguientes criterios principales:

- **Evitar dependencias innecesarias**: Siempre que las opciones nativas sean suficientemente robustas para cubrir nuestras necesidades, no se añadirán bibliotecas externas.

- **Claridad en los mensajes de fallo**: Las aserciones deben ofrecer mensajes predeterminados claros y permitir la personalización de mensajes cuando sea necesario.

Java cuenta con un sistema de aserciones integrado en su estándar a través de la biblioteca [JUnit 5](https://junit.org/junit5/), que ofrece un amplio rango de métodos de aserción. Estos métodos son suficientemente flexibles para satisfacer las necesidades comunes de pruebas unitarias sin necesidad de bibliotecas externas.

### Caracterísiticas de las Aserciones en JUnit 5.

JUnit 5 proporciona un robusto conjunto de herramientas para realizar aserciones en pruebas unitarias, cubriendo las necesidades más comunes de los desarrolladores sin requerir bibliotecas adicionales. Entre sus capacidades más destacadas, encontramos métodos para verificar igualdad y desigualdad, como `assertEquals` y `assertNotEquals`, que comparan valores esperados y actuales para asegurar que coincidan o difieran según lo esperado. También permite comprobar condiciones booleanas con métodos como `assertTrue` y `assertFalse`, y verificar si un objeto es nulo o no mediante `assertNull` y `assertNotNull`.

Una de las características más útiles de las aserciones en JUnit 5 es la posibilidad de añadir mensajes personalizados. Esto permite que, en caso de fallo, los mensajes sean claros y específicos, facilitando la identificación y resolución de problemas durante la ejecución de las pruebas. La flexibilidad de los mensajes personalizados contribuye significativamente a la eficiencia en la depuración.

En escenarios donde se deben verificar múltiples condiciones relacionadas, JUnit 5 introduce la funcionalidad de aserciones compuestas mediante el método `assertAll` que permite agrupar múltiples aserciones en un único bloque, útil para validar diferentes aspectos de un mismo caso de prueba sin detenerse en el primer fallo. Por otro lado, el método `assertThrows` es ideal para pruebas que necesitan verificar que un bloque de código lanza una excepción esperada, permitiendo evaluar casos excepcionales de manera controlada.

Además, JUnit 5 simplifica la comparación de colecciones y flujos de datos con métodos como `assertIterableEquals`. Esto resulta particularmente útil al trabajar con datos estructurados o en pruebas que involucren grandes volúmenes de información. Estas capacidades hacen que JUnit 5 sea una herramienta completa y suficiente para abordar la mayoría de los casos de prueba en proyectos Java, sin necesidad de recurrir a bibliotecas externas.

## Bibliotecas Externas

Existen también bibliotecas externas que buscan ampliar las capacidades de JUnit. `AssertJ`, por ejemplo, ofrece una API fluida y más legible para realizar aserciones en colecciones y objetos complejos. Otra opción popular es `Hamcrest`, que utiliza combinadores de emparejamiento (`Matchers`) para escribir pruebas más expresivas. Aunque estas bibliotecas pueden ser útiles en ciertos casos, su uso no es estrictamente necesario si las aserciones nativas de JUnit cubren los requisitos del proyecto.

## Elección de Biblioteca de Aserciones

Dado que el proyecto no requiere pruebas extremadamente complejas y JUnit 5 ya ofrece un cojunto robusto de herramientas, no se añadirán bibliotecas adicionales para evitar aumentar la deuda técnica. Esta decisión se basa en que las capacidades de JUnit 5 son suficientes para garantizar claridad y eficacia en las pruebas, manteniendo el projecto simple y fácil de mantener.
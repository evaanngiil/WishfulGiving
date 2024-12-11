# Gestor de Dependencias

La gestión de dependencias es esencial para asegurar que el proyecto pueda integrarse con bibliotecas externas de manera eficiente, manteniendo su estabilidad y facilidad de mantenimiento. Este documento detalla los gestores de dependencias considerados para el proyecto y las razones detrás de su selección. Se han considerado tres opciones: Apache Maven, Gradle y Apache Ivy.

## Criterios de Selección

Para elegir uno de los gestores, nos basaremos en una serie de criterios:

- *Eficiencia*: Tiempos de resolución de dependencias y ejecución de builds, incluyendo soporte para builds incrementales y uso de caché. Teniendo el benchmarking hecho [aquí](https://tomgregory.com/gradle/maven-vs-gradle-comparison/#Maven_vs_Gradle_performance_comparison)
- *Comunidad*: Cantidad y accesibilidad de los recursos de soporte, incluyendo foros oficiales, listas de correo, canales de comunicación como Slack o GitHub, y frecuencia de actualizaciones en la documentación oficial
- *Flexibilidad*:  Capacidad para personalizar procesos de build y adaptar configuraciones. Se medirá a través de niveles de customización una vez el projecto esté listo para compilar.

---

## Gestores de Dependencias Evaluados

### 1. Apache Maven

- **Descripción**: [Maven](https://maven.apache.org/) es una herramienta cuyo fichero base sigue el estándar XML y está basada en el principio de "convención sobre configuración".

- **Eficiencia**: Build completo promedio toma más de 30 segundos en proyectos medianos; no soporta builds incrementales nativamente 
- **Comunidad**: No es obvio a dónde dirigirse para recibir asistencia continua con Maven. No se pueden plantear problemas en el repositorio de GitHub y el canal de Slack es solo para colaboradores.
- **Flexibilidad**: Maven tiene un nivel principal de personalización: los `pom.xml` de cada proyecto, que también pueden referenciar configuraciones en el archivo `settings.xml` global. Permite escribir nuestro propio plugin reusable. Para escribir uno personalizado debemos crear un proyecto independiente y publicar el plugin.

---

### 2. Gradle

- **Descripción**: [Gradle](https://gradle.org/) es un gestor de dependencias y automatización de tareas diseñado para ofrecer alto rendimiento. Su configuración se puede definir en Groovy o Kotlin DSL (`build.gradle` o `build.gradle.kts`).

- **Eficiencia**: Hasta 85 veces más rápido que Maven en builds incrementales gracias al uso de caché y ejecución paralela. La caché en Gradle almacena salidas de tareas previamente ejecutadas para reutilizarlas en lugar de volver a ejecutarlas, optimizando significativamente los tiempos de build.
- **Comunidad**: Para obtener ayuda con Gradle, puedes hacer preguntas en el foro de Gradle, en el canal de Slack de la comunidad de Gradle o plantear problemas en el propio repositorio de Gradle. 
- **Flexibilidad**: Usa 3 niveles de customización; un primero para el build donde se definen tareas, metodos y clases para reusarlas, un segundo para el projecto donde se logra reusar el codigo en múltiples subproyectos, y un tercero para publicar un plugin reusable como Maven.

---

### 3. Apache Ivy

- **Descripción**: [Ivy](https://ant.apache.org/ivy/) es un sistema de gestión de dependencias ligero que se integra fácilmente en flujos de trabajo basados en Ant, una herramienta para la automatización de tareas en proyectos Java. Utiliza archivos que siguen el estándar XML como Maven

- **Eficiencia**: Carece de optimizaciones avanzadas como caché y ejecución incremental, lo que lo hace menos eficiente en comparación con Gradle o Maven
- **Comunidad**: En comparación con Maven o Gradle, Ivy tiene un ecosistema de soporte más limitado y no ofrece opciones modernas como canales de Slack, foros dedicados. Esto puede ser un desafío significativo para equipos que dependen de soluciones rápidas y robustas.
- **Flexibilidad**: Dispone de 2 niveles de personalización; a nivel de proyecto, donde se gestionan dependencias específicas dentro de un único proyecto o módulo. Y a nivel global, donde faciliata la creación y uso de repositorios compartidos, donde las configuraciones y dependencias pueden ser reutilizadas entre múltiples proyectos. Sin embargo, carece de los plugins reutilizables de Gradle.

---

## Selección del Gestor de Dependencias

### Gestor Seleccionado: *Gradle*

Gradle fue seleccionado por su superior rendimiento en builds incrementales, hasta 85 veces más rápido que Maven, lo que lo hace ideal para proyectos grandes y complejos​.Su comunidad activa ofrece soporte moderno a través de foros, Slack y GitHub, superando las opciones limitadas de Maven e Ivy​. Además, su flexibilidad con tres niveles de personalización permite adaptarse a diversas necesidades, superando las limitaciones estructurales de Maven y la simplicidad de Ivy
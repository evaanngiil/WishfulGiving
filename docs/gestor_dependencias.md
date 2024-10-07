# Gestor de dependencias

La gestión de dependencias es escencial para garantizar que el proyecto pueda integrarse con bibliotecas externas de manera eficiente, manteniendo su estabilidad y facilidad de mantenimiento. En este documento se detalla los gestores de dependencias considereados para el proyecto y las razone detrás de la selección. Para ello se han considerado tres opciones: Apache Maven, Gradle y Apache Ivy


## Criterios de selección

Para poder elegir uno de los gestores nos vamos a basar en una serie de citerios:

- *Compatibilidad* : El gestor de dependencias debe ser compaible con el ecosistema de Java y soportar estándares modernos como `XML.

- *Simplicidad* : Debe proporcionar una configuración clara, con comandos intuitivos y un flujo de trabajo bien definido.

- *Escalabilidad* : Debe ser capax de manejar dependencias de proyectos pequeños y grandes sin comprometer el rendimiento.

- *Comunidad* : Es importante que cuente con una comunidad activa y recursos de soporte confiables.

## Gestores de Dependencias Evaluados

### 1. Apache Maven

- **Descripcion**: Maven es una herramienta de gestión de proyectos y dependencias ampliamente utilizada en el ecosistema Java. Utiliza un archiv `pom.xml` como base para definir configuraciones y dependencias.

- **Ventajas**:
  - Compatible con la mayoría de los frameworks y bibliotecas de Java.
  - Gran cantidad de plugins disponibles para automatizar tareas comunes.
  - Estructura estándar que facilita la integración con otros equipos y herramientas.

- **Desventajas**:
  - Sintaxis basada en XML, que puede ser extensa y menos intuitiva.
  - Rendimiento menor en comparación con herramientas más modernas como Gradle.

- **Documentacion Oficial**: [Maven](https://maven.apache.org/)

### 2. Gradle

- **Descripción**: Gradle es un gestor de depencias y automatización de tareas diseñado para ofrecer flexibilidad y alto rendimiento. Su configuración se puede definir en Groovy o Kotlin DSL (`buil.gradle` o `build.gradle.kts`).

- **Ventajas**:
  - Rendimiento optimizado para proyectos grandes.
  - Sintaxis moderna y concisa, especialmente con Kotlin DSL
  - Flexibilidad para personalizar tareas y procesos.
- **Desventajas**:
  - Curva de aprendizaje ligeramente más pronunciada para usuarios nuevos.
  - Puede ser excesivo para proyectos simples.
- **Documentación oficial**: [Gradle](https://gradle.org/)

### Apache Ivy

- **Descripción**: Ivy es un sistema de gestión de dependencias ligero que se integra con Apache Ant. Utiliza un archivo `ivy.xml` para definir dependencias y repositorios.

- **Ventajas**:
  - Ligero y fácil de integrar con proyectos basados en Ant.
  - Permite configuraciones personalizadas de repositorios.
  - Independencia del ciclo de vida de Ant para tareas específicas.
- **Desventajas**:
  - Menos popular y con una comunidad más pequeña en comparación con Maven y Gradle.
  - Carece de algunas características modernas disponibles en otros gestores.
- **Documentación oficial**: [Ivy](https://ant.apache.org/ivy/)


## Selección del gestor de Depedencias

Para nuestro proyecto, hemos seleccionado Gradle como gestor de dependencias debido a las siguientes razones:

1. **Flexibilidad**: Gradle permite personalizar tareas y optimizar flujos de trabajo según necesidades del proyecto.
2. **Rendimiento**: Ofrece tiempos de compilación más rápidos, especialmente en proyectos de gran escala.
3. **Ecosistema Moderno**: Su integración con Kotlin DSL mejora la legibidad y mentalidad del código de configuración.
4. **Compatibilidad**: Gradle es compatible con la mayotía de frameworks y bibliotecas de Java, proporcionando una solución robusta y escalable.
# Wishful Giving

Soy un desarrollador que enfrenta dificultades a la hora de hacer regalos personalizados y significativos a amigos y familiares, lo que afecta tanto la satisfacción de quienes reciben los regalos como la mía al darlos. Esto es un problema considerable debido a lo siguiente:

### Incertidumbre sobre los gustos de la persona:

- No siempre tengo claro qué regalos serían los más apreciados o útiles para la persona a la que quiero regalar. Esto me lleva a dos situaciones comunes:

  - Regalos genéricos: Termino comprando regalos poco personales, lo que puede hacer que el detalle pierda significado.

  - Regalos incorrectos: A veces regalo algo que la persona ya tiene o que simplemente no le gusta, lo que genera una experiencia incómoda para ambos.

### Presupuesto limitado:

- Tengo un presupuesto limitado y no siempre sé cómo asignarlo eficientemente para comprar el mejor regalo posible. Esto me causa los siguientes problemas:

  - Gasto innecesario: A veces compro regalos que no generan la satisfacción esperada, lo que resulta en un gasto de dinero sin lograr el impacto deseado.

  - Oportunidades perdidas: En otras ocasiones, podría haber optimizado mejor el presupuesto para regalar algo que hubiera sido mucho más significativo.

### Falta de coordinación en regalos grupales:

- No tengo una manera eficiente de organizarme con otras personas cuando queremos hacer un regalo en grupo, lo que genera problemas como:

  - Compra de regalos duplicados: Varias personas terminan comprando cosas similares o incluso el mismo regalo, lo que reduce el impacto y la utilidad de los regalos.

  - Distribución desigual del gasto: A veces, no se distribuye bien el costo entre los participantes, lo que puede generar conflictos o incomodidades.

## Tareas

- `./gradlew check`: Verifica el código fuente para su correcto formateado
- `./gradlew buildDependents`: Ensambla y prueba este proyecto y todos los proyectos que dependen de él
- `./gradlew clean`: Elimina los archivos generados por compilaciones anteriores
- `./gradlew assemble`: Compila los archivos de origen y empaqueta el proyecto

## Documentacion

- [Claves](screenshots/clavesGithub.png)
- [User Journeys](docs/user_journeys.md)
- [Historias de usuario](docs/user_stories.md)
- [Milestones](docs/milestone.md)

### Elección del gestor de dependencias y tareas

Para elegir el gestor de dependencias se ha tenido en cuenta una serie de criterios detallados en [este archivo](docs/gestor_dependencias.md). Donde se llega a la conclusión de que Gradle es la mejor opción.

Así mismo se detalla [aquí](docs/gestor_tareas.md) los criterios en los que me he basado para elegir Gradle como gestor de tareas.

### Aserciones en Java y test-runner:

En [este](docs/testing_aserciones.md) documento se detallan los motivos que me ha llevado a elegir `JUnit 5` como biblioteca de aserciones. 

Además, en este [otro](docs/testing_testrunner.md) encontrarás los criterios utilizados para elegir a `JUnit 5` como test-runner y a `Gradle`como herramienta que nos permite ejecutar los tests usando el TestEngine de cada biblioteca, en los ecosistemas Java no existen  herramientas CLI de tests.
Para poder ejecutar los tests con la herramienta CLI debemos ejecutar el comando `./gradlew test`

## Docker

La aplicación ha sido virtualizada usando Docker. Para ello se han seguido una serie de criterios que han llevado a elegir Alpine como imagen base. Lo puedes ver en [aquí](docs/imagen_docker.md) .

Para poder ejecutar el contenedor subido a Docker Hub usaremos:

```bash
  docker run -t -u 1001 -v `pwd`:/app/test evaanngc/wishfulgiving:1.0
```

Para ejecutarlo en local necesitamos instanciar el contenedor con:

```bash
    docker build -t app 
```
y posteriormente ejecutarlo con:

```bash
    docker run -t -u 1001 -v `pwd`:/app/test app
```
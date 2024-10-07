# Milestones

## [M0] Modelado del problema

+ **Obejetivo:**: El objetivo de este milestone es diseñar un modelo conceptual que refleje fielmente el dominio del problema relacionado con la gestión de listas de deseos, presupuestos y prioridades en regalos. Este modelo debe ser lo suficientemente claro para que otros desarrolladores puedan entender cómo estructurar las entidades principales y sus relaciones.
+ **Entregable:** El producto que se entregará es un conjunto de diagramas y clases que representen los elementos del dominio, como listas de deseos, artículos, usuarios, prioridades y presupuestos. Además, se incluirá una descripción detallada que explique cómo estos elementos interactúan.
+ **Viabilidad:** Si el revisor considera que los objetivos no son factibles, se revisará el alcance del modelo, desglosando los elementos más complejos en fases más manejables. Se priorizará la representación de las entidades fundamentales para que el proyecto pueda avanzar.

*HUs: HU1, HU2, HU3, HU4, HU5*

## [M1] Implementación de la creación y consulta de listas de deseos

+ **Objetivo:** Implementar la funcionalidad para que los usuarios puedan crear y consultar listas de deseos. Sin embargo, este milestone no debe limitarse a operaciones CRUD. Se buscará aportar valor mediante la implementación de una funcionalidad que permita a los usuarios organizar y priorizar los artículos de sus listas, añadiendo metadatos que puedan ser utilizados en la etapa posterior para sugerir regalos basados en presupuestos.
+ **Entregable:** Código que permita a los usuarios no solo crear y consultar listas de deseos, sino también asignar prioridades y clasificar los artículos. Esto facilitará futuras sugerencias personalizadas en el milestone 2.
+ **Viablidad:** El milestone será considerado alcanzado cuando los usuarios puedan realizar estas operaciones y se validen mediante pruebas que verifiquen que las prioridades y clasificaciones se manejan correctamente.

*HUs: HU1, HU2, HU3*

## [M2] Implementación de la gestión de presupuestos y sugerencias de regalos

+ **Objetivo:** Implementar la lógica para gestionar presupuestos y proporcionar sugerencias de regalos basadas en las prioridades de la lista y el presupuesto disponible.
+ **Entregable:** Código con las clases y/o módulos necesarios para gestionar presupuestos y generar sugerencias de regalos.
+ **Viablidad:** Se considera viable cuando se pasen los tests planetados para la gestión de presupuestos y las sugerencias de regalos.

*HUs: HU4, HU5*

### Milestones adicionales 

#### [M3] Implemetación de la organización de regalos grupales

+ **Objetivo:** Implementar la funcionalidad para coordinar regalos grupales, incluyendo la distribución del costo entre los participantes y la prevención de duplicación de regalos.
+ **Entregable:** Código con las clases y/o módulos necesarios para gestionar regalos grupales.
+ **Viablidad:** Se considera viable cuando se pasen los tests planetados para la organización de regalos grupales

*HUs: HU6*
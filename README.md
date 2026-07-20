\# Veterinaria Mascotitas - Registro de Pacientes



Esta es una aplicación móvil nativa para Android desarrollada como parte del \*\*Trabajo Práctico 1\*\* de la materia "Introducción a la Programación para Dispositivos Móviles". La aplicación permite gestionar el registro de mascotas en una clínica veterinaria mediante una interfaz moderna, limpia y reactiva.



\## Características Principales



\* \*\*Registro de Pacientes:\*\* Captura de datos detallados (Nombre, Especie, Raza, Edad y Peso).

\* \*\*Filtros en Tiempo Real:\*\* Los campos de edad y peso validan que solo se ingresen caracteres numéricos (y puntos decimales para el peso).

\* \*\*Listado Dinámico:\*\* Utilización de `LazyColumn` y `LazyRow` para una visualización eficiente y con bajo consumo de memoria de los registros.

\* \*\*Arquitectura MVVM:\*\* Implementación de `ViewModel` para garantizar la persistencia de los datos en memoria ante cambios de configuración (como la rotación de pantalla o cambio de tema).

\* \*\*Diseño Personalizado:\*\* Interfaz estilo \*Glassmorphism\* con una paleta de colores otoñal cálida.

\* \*\*Soporte de Tema Nativo:\*\* Adaptación automática a \*\*Modo Claro\*\* y \*\*Modo Oscuro\*\* según la configuración del sistema operativo.

\* \*\*Iconografía Vectorial:\*\* Uso de iconos de Material Design y creación de un ícono vectorial personalizado (Huesito) mediante código puro.



\## Estructura del Proyecto



El código fuente sigue las mejores prácticas de modularización recomendadas por Material Design:



\* MainActivity.kt: Contiene el orquestador principal, el ciclo de vida de la Activity (onStart, onStop, onDestroy), el modelo de datos (Mascota), el MascotaViewModel y la UI declarativa del Dashboard.

\* ui/theme/Theme.kt: Orquesta y aplica dinámicamente las paletas de colores dependiendo del tema del sistema (Light/Dark).

\* ui/theme/Color.kt: Define de forma aislada la paleta de colores hexadecimales (tonos tierra/otoñales y transparencias).

\* ui/theme/Type.kt: Configuración tipográfica de la app.

\* ui/theme/Icons.kt \*(añadido)\*: Almacena los recursos vectoriales creados por código, en este caso.



\## Cómo ejecutar la aplicación



Para compilar y ejecutar este proyecto en tu entorno local, sigue estos pasos:



1\. \*\*Clonar el repositorio:\*\*

&#x20;  ```bash

&#x20;  git clone <https://github.com/abelespinola/apdm-oto-2026-abel-espinola-registro-mascotas.git>




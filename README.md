Proyecto: CasoPráctico2 - Análisis de Datos Biológicos
Este proyecto es un sistema para procesar datos biológicos desde un archivo CSV utilizando hilos, visualizar el rendimiento del sistema y presentar eventos procesados por tipo de dato. El sistema incluye un backend desarrollado en Spring Boot y una interfaz web que muestra los resultados del procesamiento de datos.

Estructura del Proyecto
/Backend
Contiene el código del backend que gestiona el procesamiento de datos del archivo CSV y la ejecución de los hilos.

CasoPractico2Application.java: Punto de entrada principal de la aplicación Spring Boot.
controller/CSVController.java: Controlador encargado de exponer los endpoints para procesar los datos biológicos y manejar la concurrencia de hilos.
concurrency: Paquete que contiene la lógica relacionada con la ejecución de hilos para procesar los datos del CSV.
config: Configuraciones del proyecto, incluyendo la gestión de los hilos y el ExecutorService.
model: Modelos de datos utilizados para representar los datos biológicos.
service: Contiene la lógica de negocio relacionada con el procesamiento de los datos.
/Frontend
Contiene los archivos del frontend, que incluyen la visualización de los datos procesados y un gráfico de rendimiento en tiempo real.

Funcionamiento del Proyecto
Backend
El backend procesa un archivo CSV que contiene datos biológicos y distribuye las tareas entre varios hilos utilizando el paquete de concurrencia de Java. El archivo biological_data.csv se procesa cuando se accede a un endpoint específico. El backend expone varios endpoints, como el que permite iniciar el procesamiento de los datos utilizando hilos.

Frontend
El frontend muestra una tabla con los eventos procesados por tipo de dato (por ejemplo, Species, Height, Location Zone) y un gráfico de rendimiento que visualiza cuántos eventos han sido procesados por segundo en tiempo real.

Requisitos Previos
Java 11+
Maven
Spring Boot
Instrucciones de Ejecución
Paso 1: Clonar el repositorio
bash
Copiar código
git clone https://github.com/tu-proyecto/casopractico2.git
Paso 2: Construir el proyecto
Ejecuta el siguiente comando dentro del directorio del proyecto para construir el backend:

bash
Copiar código
mvn clean install
Paso 3: Iniciar la aplicación
Para iniciar la aplicación de Spring Boot, ejecuta:

bash
Copiar código
mvn spring-boot:run
La aplicación estará disponible en http://localhost:8080.

Paso 4: Ejecutar los hilos para procesar los datos biológicos
Para iniciar el procesamiento del archivo biological_data.csv utilizando hilos, abre un navegador web e ingresa la siguiente URL:

bash
Copiar código
http://localhost:8080/process-biological-data?filePath=biological_data.csv&continue
Credenciales de acceso:

Usuario: admin
Contraseña: admin

Esto iniciará el procesamiento de los datos por parte de los hilos, que distribuirán las tareas para procesar cada fila del archivo CSV.

Paso 5: Visualizar los resultados
Puedes visualizar los resultados del procesamiento (tabla y gráfico de rendimiento en tiempo real) accediendo a la interfaz web en:

bash
Copiar código
http://localhost:8080/index.html
Esta página muestra la tabla con el número de eventos procesados por tipo de dato y un gráfico en tiempo real que ilustra el rendimiento del sistema mientras los hilos procesan los datos.

## Iniciar la aplicación

Construcción y Ejecución
Paso 1:

Construir y levantar los contenedores
Para construir y ejecutar la aplicación completa, asegúrate de estar en el directorio raíz del proyecto (donde está el archivo docker-compose.yml) y ejecuta el siguiente comando:

docker-compose up --build
Este comando hace lo siguiente:

Construye las imágenes de los contenedores para el backend y el frontend.
Descarga la imagen de MySQL si no la tienes.
Levanta todos los servicios definidos en docker-compose.yml.
Acceso a la Aplicación
Una vez que los contenedores estén ejecutándose, puedes acceder a los siguientes servicios:

Frontend (React): http://localhost:5000
Backend (Spring Boot API): http://localhost:8181
Base de datos MySQL: disponible en el puerto 3306 con los datos configurados en docker-compose.yml.

Credenciales de Mysql

MYSQL_USER: aurora_user
MYSQL_PASSWORD: aurora_user_password
MYSQL_DATABASE: aurora

Detener la Aplicación
Para detener y eliminar los contenedores, ejecuta el siguiente comando:

docker-compose down

Esto detendrá todos los contenedores y eliminará los volúmenes definidos, de modo que los datos de MySQL se mantendrán gracias al volumen db_data.

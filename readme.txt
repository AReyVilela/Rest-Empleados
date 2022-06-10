Ejercicio 1: Desarrollo de API REST
En el siguiente ejercicio práctico nos pondremos en la piel de un equipo agile de desarrollo
enfrentándose a una nueva funcionalidad definida por el Product Owner.
La nueva tarea hace referencia a una nueva API REST encargada de la gestión e información de
empleados. El Product Owner ha definido los siguientes requisitos:

La api deberá de tener un objeto Empleado definido con los siguientes datos:
○ Nombre.
○ Apellidos.
○ Edad.
○ Dirección.
○ DNI.
○ Salario.
○ Rol.
Un endpoint encargado de devolver a todos los empleados: /getEmpleados. Este endpoint
devolverá información específica de los empleados:
○ Nombre.
○ Apellidos.
○ Rol.
○ DNI.
Un endpoint encargado de devolver un empleado en concreto: /getEmpleadosById. Este
endpoint recibirá como parámetro un id, y devolverá toda la información del empleado.
Un endpoint encargado de modificar la información de un empleado en concreto
/putEmpleadoById. Este endpoint recibirá un body con la información nueva del empleado.
Modificara esta información del empleado y devolverá toda la información actualizada del
empleado.
Un endpoint encargado de crear un nuevo empleado: /postEmpleado. Este endpoint recibirá
un body con la información completa del empleado. Añadirá ese empleado, y la respuesta
será la información básica de ese empleado (la misma que en /getEmpleadosById).
Un endpoint encargado de borrar un empleado: /delEmpleado. Este endpoint recibirá un id por
parámetro, y se encargará de borrar ese empleado, y la respuesta será un NO CONTENT.
Con las anteriores especificaciones desarrollaremos la API siguiendo las siguientes pautas:
● Utilizaremos DTO’s como estructura de datos para la respuesta del endpoint de
/getEmpleados.
● Utilizaremos un fichero (.csv ó el tipo que pueda ser mejor en este caso) para tener datos
almacenados, y que la API ataque a esos datos.

El servicio debe de códigos de error personalizados, explicando el motivo del error. Ejemplo:
○ 404: not found -> empleado con el nombre: X no es un empleado
Los formatos de los datos de respuesta y body serán JSON.
3NUMA QA: Track API REST
Ejercicio 2: Dockerizar la API
En el siguiente ejercicio práctico hay que generar una imagen docker que al arrancar levante la API
generada en el ejercicio anterior y sea accesible desde el exterior.
Para generar la imagen docker tener en cuenta las siguientes condiciones:
● Generar fichero Dockerfile dentro del proyecto creado en el ejercicio anterior.
● Utilizar como imagen base para la imagen a generar: openjdk:8-jdk-alpine

Ejercicio 3: Suite de testing con Postman
En el siguiente ejercicio práctico, nos pondremos en la piel de un QA enfrentándose a una
automatización de tests de API con Postman.
Basándose en los conocimientos adquiridos durante los cursos hay que automatizar la API creada y
dockerizada en los ejercicios anteriores con Postman como herramienta base.
Habrá que hacer tests para todos los casos que se nos ocurran para garantizar que la API tiene la
suficiente calidad como para salir a producción.
Consejos:
● Antes de empezar a automatizar crear un plan de pruebas (de la manera más simple que se nos
ocurra) en el que contemplemos todas las pruebas que queremos hacer, para poder garantizar su
salida a producción.
● Como QA’s sabemos que, para salir a producción con una API deben estar probados TODOS
los casos de cada endpoint.

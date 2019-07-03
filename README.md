# santatecla-tiempos-3

# Equipo de desarrollo

|        **Miembro**        |          **Correo URJC**          |        **GitHub**       |
|:---|:---|:---|
| *Miguel Torrijos*       | m.torrijos@alumnos.urjc.es    | [MiguelTG35](https://github.com/migueltg35)          |
| *María Delgado Eiriz*   | m.delgadoei@alumnos.urjc.es   | [MariaDelgadoEiriz2](https://github.com/mariadelgadoeiriz2)  |
| *Omar Khanji Dobosh*    | o.khanji.2016@alumnos.urjc.es | [khenji55](https://github.com/khenji55)            |
| *Wu Li Lu*              | w.lil@alumnos.urjc.es | [alilu8](https://github.com/alilu8)            |



# Imágenes

## Inicio de sesión
![Inicio de sesión](screenshots/Phase&#32;1/Captura&#32;3.jpg)

## Página de categorías
![Categorías](/screenshots/Phase&#32;1/Captura&#32;1.jpg)

## Página de eventos
![Eventos](screenshots/Phase&#32;1/Captura&#32;4.jpg)

## Página de tiempos
![Tiempos](screenshots/Phase&#32;1/Captura&#32;7.jpg)

## Ventana nueva/editar categoría
![Ventana nueva/editar categoria](screenshots/Phase&#32;1/Captura&#32;2.jpg)

## Ventana nuevo/editar evento
![Ventana nuevo/editar evento](screenshots/Phase&#32;1/Captura&#32;5.jpg)

## Ventana nuevo/editar tiempo
![Ventana nuevo/editar tiempo](screenshots/Phase&#32;1/Captura&#32;6.jpg)

# Diagrama de entidades BBDD

![diagram](https://github.com/CodeURJC-DAW-2018-19/santatecla-tiempos-1/blob/master/screenshots/Phase%201/Diagrama.PNG)

# Diagrama de clases

![diagram](https://github.com/CodeURJC-DAW-2018-19/santatecla-tiempos-1/blob/master/screenshots/Phase%201/Clases.png)

# Instalación y configuración del entorno de programación

## Base de datos

Se debe instalar mysql, configurarlo en las variables del path e inciarlo en el directorio del proyecto. Se lanzan las queries de la creación de la base de datos y tablas tras acceder desde ahí a mysql, y la query de inserción de datos. Posteriormente se ejecuta el aplication.java del proyecto, y se puede acceder ya con https://localhost:8433 a la aplicación.

##API Rest
Para llevar a cabo la creación de la API Rest en nuestro proyecto hemos creado un nuevo paquete en el cual hemos incluido todos los archivos para el correcto funcionamiento de la misma.
####Package
![API Proyecto](screenshots/Phase&#32;3/api.png)

Y uno de los códigos de los fragmentos queda definido de este modo.
####Fragmento de código
![API Categoria](screenshots/Phase&#32;3/sc1.png)

## Docker

Para instalar Docker en el entorno primero hay que descargarlo, en nuestro caso, elegimos el entorno de linux para hacerlo usamos el siguiente enlace https://www.digitalocean.com/community/tutorials/como-instalar-y-usar-docker-en-ubuntu-16-04-es.
Una vez se haya seguido los pasos, hay que configurar Docker.Para ello hay que asegurarse que el Daemon esta habilitado y configurado.

### Creación de la imágen del docker
![Creación de la imágen del docker](screenshots/Phase%201/crear%20imagen.jpeg)
### Creación del docker_compose
![Creación del docker_compose](screenshots/Phase%201/crear%20imagen.jpeg)
# Enlace a la documentación

##Angular
Una vez que hemos realizado el proyecto con la API Rest y Docker, procedimos a la implementación de angular en todo el proyecto. El uso de angular en nuestro proyecto nos llevo a la inclusión de un nuevon lenguaje que es TypeScript, el cual se encarga de conectar el Frontend en Angular con nuestro Backend de la api rest en Spring Boot.

##Documentación
https://docs.google.com/document/d/1rWcAxrTCxYdzGzAHamFft_bQ4EsX8VsRZJQfyriQ8r0/edit

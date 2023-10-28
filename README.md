# Creacion de un Full-Stack con Spring y ReactJS y Dockerizado

Levantando una aplicacion login con Spring y ReactJS

## Dockerizando Aplicacion.


### 1. Creacion de la imagen

(Esto solo ejecutarlo una vez)

Ejecuta este comando para construir la imagen docker para la app: `docker build -t backend-login-jwt .`



### 2. Ejecucion de la App Spring Framework y la base de datos:

Asegúrate de que PostgreSQL no esté activado en tu sistema, 
ya que utilizaremos un contenedor Docker para la base de datos.
Luego, sigue estos pasos:

```shell
$ chmod 744 start.sh

$ ./start.sh      

Ingresando a la ayuda: # Mostrara las siguientes opciones

Para ver la ayuda, ingresa con: --help
--mbuild - Compilar .jar para maven
--cbuild - construir y levantar la imagen de docker
--run    - ejecuta todos los pasos en conjunto
--kill   - limpia el contenedor
```

### 3. Ejecucion del entorno ReactJS y del login:

```shell
# Navega al directorio de la aplicación ReactJS:
$ cd react-hooks-jwt-auth/
# Instala las dependencias necesarias:
$ npm install 
# Luego, inicia el entorno de desarrollo:
$ npm run dev 


# Ingreso al frontend de la aplicacion:

  VITE v4.5.0  ready in 328 ms

  ➜  Local:   http://localhost:5173/
  ➜  Network: use --host to expose
  ➜  press h to show help

```

### 4. Ingreso al Frontend

Después de ejecutar los contenedores con docker-compose 
y el entorno ReactJS, podrás acceder al frontend de la 
aplicación en tu navegador, Ingresando a: [http://localhost:5173/](http://localhost:5173/)

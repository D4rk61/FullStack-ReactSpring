#!/bin/bash

function help() {
    echo -e "\nIngresando a la ayuda:\n"
    echo -e "Para ver la ayuda, ingresa con: --help"
    echo -e "--mbuild - Compilar .jar para maven"
    echo -e "--cbuild - construir y levantar la imagen de docker"
    echo -e "--run    - ejecuta todos los pasos en conjunto"
    echo -e "--kill   - limpia el contenedor"
}

function package() {
    ./mvnw clean package -DskipTests
}

function build() {
    docker-compose build
}

function up() {
    docker-compose up
}

function run() {
    package
    build
    up
}

function clean() {
    docker-compose down -v
    docker system prune -f
}

if [ $# -eq 0 ]; then
  help
  exit 1
fi

case "$1" in
    --mbuild)
        package
        ;;
    --cbuild)
        build
        ;;
    --run)
        run
        ;;
    --kill)
        clean
        ;;
    --help)
        help
        ;;
    *)
        echo "Opción no válida. Consulta la ayuda con: --help"
        exit 1
        ;;
esac
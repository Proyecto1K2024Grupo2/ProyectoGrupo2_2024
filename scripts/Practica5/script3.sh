#!/bin/bash

salir=0

#Mientras que salir no sea 1
while [[ salir -ne 1 ]]
do
        echo "1. Mostrar proceso"
        echo "2. Matar proceso"
        echo "3. Salir"
        read resp

#Si la respuesta no es un numero del 1 al 3
        if [[ $(echo $resp | egrep -x "[1-3]") == $resp ]]
        then
#Para el 1, hago un ps. Para el 2, le pido el proceso, compruebo que existe y si existe lo mato. Para el 3, salir = 1
                case $resp in
                1) ps ;;
                2) read -p "Indica el proceso: " proc
                        if [[ -n $(ps | tr -s " " | cut -d" " -f2 | tail -n +2 | grep $proc) ]]
                        then
                                kill $proc
                        else
                                echo "El proceso no existe"
                        fi
                ;;
                3) salir=1;;
                *) echo "Opcion incorrecta";;
                esac
        else
                echo "opcion incorrecta"
        fi
done
# -*- coding: utf-8 -*-
from examenSegundoTrimestrePython.Cuadrado import Cuadrado
'''
Created on 5 abr. 2019
Crea la clase Rectángulo de forma que:
• Un objeto de esta clase se construye pasándole el ancho y el alto. Ninguno de los dos atributos
puede ser menor o igual a cero ni mayor que diez, en esos casos se debe lanzar la excepción
ArithmeticException.
• Mediante getters y setters permite que se acceda y se modifique el ancho y el alto del
rectángulo teniendo en cuenta las restricciones en cuanto a las dimensiones del apartado
anterior.
• Al imprimir en pantalla un objeto de la clase usando System.out.print se debe dibujar el
rectángulo por la pantalla (de manera similar a como se imprime un cuadrado en la página 130
del libro Aprende Java con Ejercicios).
• Crea la clase Cuadrado como subclase de Rectángulo. Le debes añadir a su comportamiento
la posibilidad de comparar objetos cuadrados entre sí.
• Crea los programas de test correspondientes a ambas clases. Debes provocar que se lance la
excepción y capturarla. 
@author: Álvaro Leiva Toledano
@version: 1.0
'''
import sys

try:
    
    cuadrado1 = Cuadrado(2)
    cuadrado2 = Cuadrado(4)
    cuadrado3 = Cuadrado(6)
    cuadrado4 = Cuadrado(2)

    print(cuadrado1)
    print(cuadrado2)
    print(cuadrado3)
    print(cuadrado4)
    
    print("Cuadrado 2 mayor que cuadrado 1: " + str(cuadrado2>cuadrado1))
    print("Cuadrado 2 mayor que cuadrado 3: " + str(cuadrado2>cuadrado3))
    print("Cuadrado 1 mayor que cuadrado 3: " + str(cuadrado1>cuadrado3))
    
    print() #salto de línea
    
    print("Cuadrado 1 igual que cuadrado 2: " + str(cuadrado1==cuadrado2))
    print("Cuadrado 1 igual que cuadrado 3: " + str(cuadrado1==cuadrado3))
    print("Cuadrado 1 igual que cuadrado 4: " + str(cuadrado1==cuadrado4))
    
    print()
    
    print("Cuadrado 3 menor que cuadrado 2: " + str(cuadrado3<cuadrado2))
    print("Cuadrado 1 menor que cuadrado 3: " + str(cuadrado1<cuadrado3))
    print("Cuadrado 2 igual que cuadrado 2: " + str(cuadrado2<cuadrado2))
    
    #print(cuadrado1.compararCuadrados(cuadrado2))
    
except TypeError:
    sys.stderr.write("ERROR: Los parámetros han de ser iguales.\n")
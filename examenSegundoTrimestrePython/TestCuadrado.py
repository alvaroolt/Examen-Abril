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
    
    cuadrado1 = Cuadrado(2, 2)
    cuadrado2 = Cuadrado(4, 4)

    print(cuadrado1.imprimirFigura())
    print(cuadrado2.imprimirFigura())
    
    print(cuadrado1.compararCuadrados(cuadrado2))
    
except TypeError:
    sys.stderr.write("ERROR: Los parámetros han de ser iguales.\n")
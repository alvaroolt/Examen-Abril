# -*- coding: utf-8 -*-
from examenSegundoTrimestrePython.Rectangulo import Rectangulo
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
    rectangulo1 = Rectangulo(4, 2)
    rectangulo2 = Rectangulo(6, 8)
    # rectangulo3 = Rectangulo(5,11)
    
    print(rectangulo1)
    print(rectangulo2)
    # print(rectangulo3)

except TypeError:
    sys.stderr.write("ERROR. Introducidos valores no permitidos.")

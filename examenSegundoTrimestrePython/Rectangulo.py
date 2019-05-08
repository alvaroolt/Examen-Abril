# -*- coding: utf-8 -*-
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


class Rectangulo:
    
    # constructor
    def __init__(self, ancho, alto):
        self.ancho = ancho
        self.alto = alto
    
    @staticmethod
    def compruebaAncho(self, ancho):
        if ancho > 10 or ancho < 1:
            raise TypeError("Ancho no válido.", ancho)
        
    @staticmethod
    def compruebaAlto(self, alto):
        if alto > 10 or alto < 1:
            raise TypeError("Alto no válido.", alto)
        
    @property
    def ancho(self):
        return self.__ancho  # alternativa a getter en java
    
    @ancho.setter
    def ancho(self, ancho):
        Rectangulo.compruebaAncho(self, ancho)
        self.__ancho = ancho
    
    @property
    def alto(self):
        return self.__alto  # alternativa a getter en java
    
    @alto.setter
    def alto(self, alto):
        Rectangulo.compruebaAlto(self, alto)
        self.__alto = alto
    
    def __str__(self):
        mensaje = ""
        
        print("La figura impresa es la siguiente:")
        for i in range(self.alto):
            for j in range(self.ancho):
                mensaje += "X"
            mensaje += "\n"
        return mensaje
        print()

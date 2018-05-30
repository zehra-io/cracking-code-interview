package io.kaluh.java8.basic.string;

/**
 * String: Esto hace que las cadenas sean Threadsafe y puedan ser accedidas por
 * varios hilos de forma simult�nea sin generar ning�n tipo de problema. Ahora
 * bien todo tiene un precio, si cada vez que modificamos una cadena se crea una
 * nueva, esto implicar� que el programa tendr� que almacenar muchas cadenas. La
 * implicaci�n de este enfoque es clara , el consumo de memoria se incrementar�
 * ya que hay muchas cadenas iguales.
 * 
 * 
 * Para reducir este problema Java de forma interna implementa el patr�n
 * flyweight y genera un pool de Strings que se comparte . De esta forma cada
 * vez que nosotros necesitamos crear una nueva cadena Java revisa si ya existe
 * en el pool, en tal caso nos devuelve una referencia a ella.
 * 
 * De ah� que cuando creamos dos cadenas con el mismo texto el operador == nos
 * devuelva true siempre, ya que apuntan al mismo objeto del pool.
 * 
 * @author Z462725
 *
 */
public class StringPool {

}

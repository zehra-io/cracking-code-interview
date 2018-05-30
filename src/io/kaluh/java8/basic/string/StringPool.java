package io.kaluh.java8.basic.string;

/**
 * String: Esto hace que las cadenas sean Threadsafe y puedan ser accedidas por
 * varios hilos de forma simultánea sin generar ningún tipo de problema. Ahora
 * bien todo tiene un precio, si cada vez que modificamos una cadena se crea una
 * nueva, esto implicará que el programa tendrá que almacenar muchas cadenas. La
 * implicación de este enfoque es clara , el consumo de memoria se incrementará
 * ya que hay muchas cadenas iguales.
 * 
 * 
 * Para reducir este problema Java de forma interna implementa el patrón
 * flyweight y genera un pool de Strings que se comparte . De esta forma cada
 * vez que nosotros necesitamos crear una nueva cadena Java revisa si ya existe
 * en el pool, en tal caso nos devuelve una referencia a ella.
 * 
 * De ahí que cuando creamos dos cadenas con el mismo texto el operador == nos
 * devuelva true siempre, ya que apuntan al mismo objeto del pool.
 * 
 * @author Z462725
 *
 */
public class StringPool {

}

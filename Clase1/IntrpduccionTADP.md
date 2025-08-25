# TDAP
--- 
Profesor: Nicolas Scarcela 
Mail: nscacella@gmail.com
Pagina: tadp-utn-frba.github.io
- Calendario
- Discord
- Github 
- Planilla

## 2 Modulos grandos 
### 1 Rubi
- Modulos -> Mecanismo de instanciacion de objetos 
- Metaprogramacion (Capacidad de un programa de analizar o cosntruir un programa)

### 2 Scalla
- Tipado 
- Programacion Hibrido objeto / Funcional 

---
Clase 1
Ejercicio: Tengo un gerrero pero tambien quiero crear una clase espadachines que comparta comportatimiento con guerrero 
* Solucion 1 
-  Crear 2 clases distintas Clase Guerrero y Clase Espadachin 

* Solucion 2 
- Asignarle una espada al guerrero y que se aplica un "Stratergy" para calcular los distintos ataques 

* Solcion 3 
- Hacer una herencia de guerrero < --  Espadachin (Pero que te certifica que  se herda asi no no al revcwz ??
                                                   Para solucionar esto tiene que ser por conosimiento y logica aunque no siemrpe se va a llevar bien) 

                                            
Segunda parte del codigo 
* Aunque muralla este vacio NO esta mal ya que podemos identificar que es una muralla ya que si en un futuro me agregan un metodo a SOLO muralla me rompe todo ya que la otra altenativa es onstanciar el Defensor pero si pasa eso y aguego un metodo para el solo muralla haciendo eso El guerroro puede hacer ese metodo.


(Problema y con solucion MUY CROTA)
Tecer caso cuando tenes una clase mas que es misil en este caso tendriamso Muralla (que solo defiende) que hereda de defesonr misil (que solo ataca) y guerrero que (hereda de defensor y de atacante) pero esto no se puede (Ya que no admite herencia multiples el paradigma de objeto) la mejor forma de resolver esto es copiando y pegando. Me explico misil y guerrero hereda de atacante y copia y pega los metodos de defensor y por otro lado la muralla simplemente hereda de denfensor 
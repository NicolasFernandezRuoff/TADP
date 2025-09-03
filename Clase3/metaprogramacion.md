# Metaprogramación en Ruby
---
## ¿Qué es la metaprogramación?
Es un proceo o práctica por la cual se escriben programas que generan o modifique otros programas. (No los aplicamos a heraramientas externas)

Algunos ejemplos pueden ser:
- Compiladores
- Formateador de código
- Herramientas de generación de documentación
- Frameworks (Springboot, Angular, React)

### ¿Para qué se usa?
- Desarrollo de frameworks y herramientas
- Dominio de los frameworks
Algunos ejemplos son: como ORMs, Testing (JUnit), Documentadores de código o Analizadores de código

### Reflection
Es *metaprogramar* en el mismo lenguaje que los programas.
#### Tipos de Reflection
- **Introspection**: herramientas del lenguaje para poder analizarse a sí mismo. Que el programa se vea a sí mismo o que revise a otro programa.
- **Self-modification**: el programa puede cambiar el comportamiento, puede modificarse a sí mismo.
- **Intercession**(No la vemos): capacidad en un lenguaje de agregar una característica nueva que no esté previamente.

- - -

## Metaprogramación en Ruby

Utilizaremos la consola `pry`.
### Comandos pry
| Comando |Funcionalidad | Detalles |
|---------|--------|--------|
|`require_relative`| Importar archivo|-|
|`unObjeto.class`| Dice la clase de un objeto|-|
|`unObjeto.class.superclass `| Dice la superclase de un objeto|-|
|`unaClase.ancestors `| Muestra todos los superiores a un objeto | En forma de lista `[]`|
|`unaClase.is_a? otraClase `| Devuelve booleano | -|
|`unObjeto = Clase.new`| Instanciar un objeto |-|
|`class B < A end`| Crear clase B y heredarla de A |-|
|`unObjeto.methods`| Llama a un método |-|
|`unaClase.singleton_class`| Permite obtener la eigenclass de unaClase, *metaclass* **el objeto unaClase** | Puede servir para ver los métodos de clase, no de instancia|
|`unObjeto.methods.include? :method`| Dice si los métodos incluyen un método |-|
|`unObjeto.unMetodo`| Llama al método y muestra el valor de retorno|-|
|`unaClase.instance_methods(Boolean)`| Muestra los métodos que implementa la clase y su superclase |`instance_methods(false)` no incluye a la superclase, viene defoult true|
|`unaClase.instance_method :unMetodo`| Devuelve un método de esa clase no bindeado a ningún objeto |-|
|`unMetodoNoBindeado.bind(unObjeto)`| Bindea un método no bindeado a un objeto |No se puede bindear un método a un objeto de una clase que no tenga ese método.|
|`unObjeto.send(:unMetodo)`| Llama al método y muestra el valor de retorno | Manda un mensaje explícitamente, más tipo **introspection**. Permite llamar a métodos privados. y en momento de ejecucion podes cambiarlo a comparacion de hacer el `unObjeto.unMetodo` pudiendo recibir por un parametro el `unMetodo` guardado como unba variable y enviarlo por send |
|`unObjeto.method(:unMetodo)`| Devuelve una instancia de method| Un método bindeado a la instancia. Lo puedo guardar |`variable = unObjeto.method(:unMetodo)`|
|`unMetodo.call`|  Llama a un método bindeado a una instancia |-|
|`unMetodo.parameters`| Dice todos los metodos de ese objeto| Los muestra como una lista de tuplas `[[:req, :un_danio]]`, el primero nos dice qué tipo de parametro es y el otro el nombre. |
|`unMetodo.arity`| Dice la cantidad de parámetros de ese método|-|
|`unObjeto.method(:unMetodo).receiver`| Devuelve a quién está bindeado un método |-|
|`unMetodoNoBindeado.owner`| Dice la clase a la que pertenece el metodo, **quien implementó el método** |-|
| `unObjeto.define_method('nombre') {codigo}`| Metodo para definir metodos en tiempo de ejecucion| -|
---
#### Variables de Instancia
|Comando|Funcionalidad|Detalles|
|---------|--------|--------|
|`unObjeto.instance_variables`| Permite ver los atributos| - |
|`unObjeto.instance_variables_get(:@unAtributo)`| Permite ver el valor de un atributo| - |
|`unObjeto.instance_variables_set(:@unAtributo, valor)`| Permite setear el valor de un atributo| - |

#### Notas
- El `:unMetodo` es un símbolo, un String.
- El simbolo `:@` es la forma de definiar atributos 
    - cuando hacemo `unObjeto.interface_variable_set` solo te devuelve los que no esta en nill(null) o esten instanciados (Aunque tenga sea null)
- Todo atributo se define en nill y no es conocido por el sistema, hasta que el usuairo lo "instancia"
- Hacer `unaClase.class` devuelve la clase a la que pertenece. Al sumarle a la clase perteneciente métodos, no se le agregan a la clase a la que pertence porque ensuciaría el ecosistema. 
- El `methods` es para objetos y te devuelve los metodos que entiende y el `unObjeto.intance_methods` es para las clases 
- Para usar el `call` sirve para hacer obtener un metodo que puede o no estar asociado a una clase y con el `unObjeto.call(methods)` puedo hacer que un objeto ejecute un metodo que puede o no tener por herencia osea
    - Ejemplo basico tengo la clase A que tiene el un metodo `hola` yo obtengo este metodo y despues le digo a la clase B que es totalmente diferente y no tienen relacion le digo `B.call(hola)` y la clase b lo puede ejecutar sin problemas 


## Self Modification en Ruby

- #### Open Classes
Es posible en cualquier momento redefinir las clases. 

Por ejemplo si ya tengo mi clase 
```ruby
class unaClase
    def blah
        2
    end
end
```
Como **Ruby es imperativo** puedo redefinir la clase
```ruby
class unaClase
    def blah
        46
    end
end
```
Y este comportamiento **es retroactivo**, el objeto no tiene el comportamiento, se lo pide a la clase.

- #### Duck typing
Por la naturaleza de Ruby de ser dinámicamente tipado, se hace referencia a un tipo de dato no por el tipo en sí sino por el comportamiento que tiene. 

- #### Monkey patching
Posibilidad de modificar un tipo, una clase o un objeto para que satisfazga las necesidades que se tienen.

## Metamodelo en Ruby
Siguiendo el ejemplo de Guerreros, el árbol quedaría de esta manera:

#### Metodo Ducapt (O como se escriba)
- Es 1 paso azul N pasos rojos (Caso de java)
    - Paso azul del objeto a la clase (=>)
    - Paso rojo de clase hijo a clase padre (->)

<img src="Captura.PNG"></img>

### Copiar foto del video de como es el Metamodelo

- 1 paso negra y N paso rojos (Caso de Ruby) 
    - Paso azul del objeto a la clase (=>) ==> azul == negra + roja
    - Paso rojo de clase hijo a clase padre (->)
    - Paso negro de clase hermano (..>) 
    - En este caso ya que se debe cortar la recursividad se agrega nill(objeto) que hereda de NilClass y nillClas herea de Objetos 
        - En este caso no es corta la recursividad 
        nill => NillClass -> Object -> BasicObjet -> nill => NillObjet(Ahi corta la recusrsividad)
    - todas las clases van a una clase `Class`que la class tiene una flecga azul a si misma y la flecha roja a Module y de ahi a Objet (Class => Class -> Module -> Objet)
    - Si queremos que un metodo lo tengan todas las clases se pueden poner un metodo en Objet y eso hace que **TODOS** los metodos tengan esos 
    - Pero si se queire hacer que que una clase tenga metodos solo para el entonce se asocia una Clase A con una clase #Clase A y ellps apunto a class y despues de estos #Clase A si necesitan su clase personal (##Clase a) lo resuelve con lazy los va generando mendiante pasa. Y todas las # se conectan entre si para heredar metodos
        - A ..> #a => Class && #a -> Class
        - Esto tambien pasa con sus objetos "a" : a ..> #a -> a || a => a

Notas:
 - SI quiere hacer que todas las clases tengan un metodo es tan simple como poner en eobjet por ejemplo quiero que pongamos `toString()` que la implemento dentro de objet y ya TODAS las clases creadas van a tener ese metodo
 - No tiene recursividad infinita ya que lo unico que puede ser infinito lo arregla con lazy
 - Si quiero hacer que poner un metodo que solo lo tenga una clase se agrega en en su #class 


### Objeto auto clase
En Ruby todo es un objeto, los números, strings, arrays y también las Clases. Las clases mismas son instancias de Class. Clases tienen singleton_class Como son objetos, también pueden tener métodos definidos “solo para ellas”.


# Metaprogramacion 
---

``` Ruby
#ir_de_Comprass 
def ir_de_compras_con(un_carrito)
    un_carrito.agregar_producto("Paquete de fideos", 2)
    un_carrito.agregar_producto("Leche 1L", 3)
    un_carrito.total_a_pagar
    un_carrito.agregar_producto("Pan lactal", 1)
    un_carrito.total_a_pagar
end

#Arreglo caso (2)
class RegistradorDeMensajes < BasicObject
  attr_reader :mensajes_recibidos 
  # Defino el lugar dodne voy a guardar los mensajes redibidos

  def initialize(objeto_original)
    @objeto_original = objeto_original # Objeto que catcheo (CarritoDeCompra)
    @mensajes_recibidos = [] # Mensajes recibidos por el carrito
  end

  def method_missing(nombre_mensaje, *argumentos, &bloque) 
  # Redefino el metodo que no tengo el metodo para...
    @mensajes_recibidos << { mensaje: nombre_mensaje, argumentos: argumentos } 
    #Guardar los datos en mi variable objetos recibidos
    @objeto_original.send(nombre_mensaje, *argumentos, &bloque)
    #Volverle a enviar el metodo a CarritoDeCompra
  end

  # Para sabes si debe devolver True o False caso (1)
  def method_tomissing?(nombre_mensaje, include_private = false)
    #Le pregunto al objeto si sabe responder el mensaje
    @objeto_original.respond_to?(nombre_mensaje)
  end
end

carrito = CarritoDeCompra.new
registradorDeMensajes = RegistradorDeMensajes.new(carrito)
ir_de_compras_con(registradorDeMensajes)

# Puts es para mostrar el mensaje y ene ste caso estoy mostrando los mensajes_recibidso
#En este caso mostrando los mensajes de ir_de_comrpas_con...
puts registradorDeMensajes.mesajes_recibidos
```

### Ambos objetos entienden los mismos mensajes ? (1)
``` Ruby
    puts carrito.respond_to? :total_a_pagar #True  
    puts registradorDeMensajes.respond_to? :total_a_pagar  #Flase

    #Porque nos devuelve false el registrador de mensajes si delega al Carrito?
    # Porque no tenemos el redefinido el respond_to_missing() 
        # Metodo que se encarga de devolver True ya que No tiene sentido el False
```

### Que pasas si le pregunto si es un carrito de compra? (2)
``` Ruby
    puts carrito.is_a? :CarritoDeCompra #True  
    puts registradorDeMensajes.is_a? :CarritoDeCompra  #Flase
    # Para solicionarlo y que ambos devuelvan True en vez que RegistradorDeMenajes herede de
    # Objet (Tiene definido el metodo is_a) puedo hacer que herede de BasicObjet

```
#### En resumen
* Para mantener consisnte el `respond_to?` se debe redifinir el `method_mising` y usualmente el `respond_to_mising?`
* Simpre delegar a `super` si no sabesmo responder el mensaje (Caso (1)) 

--- 
## Bloques, Landas y Closueres

### Bloque / Closers
* Todos los metodos en ruby recibeen un bloque 
* Toda variable creada dentro de un bloque vive SOLO dentero del bloque pero pueden redifinir variables del codigo a comparacion de las metodos 

``` Ruby
    # Pirmera forma de ejecutarlo
    def m1
        yield #Esta funcion lo que permite es ejecutar lo qeu esta andetro del bloque 
    end

    # Seguda FOrma de ejecutarlo
    def m1(&bloque) # El & sirve para recibir el bloque 
        bloque.call #Ejecuta el bloque 
        #Esto te permite poder mandar este bloque entre objetos 
    end

    #Bloque opcion 1 de definir el bloque se utiliza cando hay mas de una linea
    m1 do 
        puts "chau"
    end
    # Opcion 2 se utiliza cuando hay una sola linea
    m1 {puts "chau"}

    # Se pueden guardar esto bloques de la forma 
    bloque = proc { funcion } #Ejemplo Imprimir_hola = prox { puts "hola" }
    # Y se llama con 
    bloque.call ## Ejemplo Imprimir_hola.call

```
### Si quiero tener una clase/Metodo con acceso a variables globales
``` Ruby
    nombre = "Pepe"
    #Caso metodo le paso un bloque
    define_method(:m1) do 
        puts nombre
    end
    m1
    #Caso Clase le paso un bloque a la clase
    C1 = Clas.new do 
        puts nombre
    end
``` 
---
### Landa
* Principal diferencia es que a las lambda no se le puieden pasar argumnentos de mas  en el caso de abajo si es lambda **rompe** pero en el caso de lo bloquess devuelveria `nill 2 2`


``` Ruby
# Insepct te permite mostrar los nill
lam = lambda {|x| puts x.inspect }
lam.call()
lam.call(2)
lam.call (2,3,4)
```
---

#### `instance_eval` vs. `class_eval` (Lo podemos desarrollar mas en la clase)
| Método              | Contexto donde se evalúa el código              | `self` dentro del bloque             | Uso típico |
|---------------------|------------------------------------------------|--------------------------------------|------------|
| `eval`              | Evalúa un string en el contexto actual (scope global o local) | No cambia, se mantiene el actual     | Ejecutar código dinámico escrito como string (⚠️ peligroso si viene de usuarios). |
| `instance_eval`     | Evalúa un bloque **en el contexto de una instancia** | Ese objeto en particular (`self = objeto`) | Definir métodos singleton o acceder a variables privadas de un objeto. |
| `instance_exec`     | Evalúa un bloque **en el contexto de una instancia**, **pero permite pasar parámetros** | Ese objeto en particular (`self = objeto`) | Ejecutar un bloque con acceso al objeto y parámetros adicionales. |
| `class_eval` / `module_eval` | Evalúa un bloque **dentro del contexto de una clase o módulo** | La clase/módulo en sí (`self = Clase`) | Abrir clases dinámicamente, agregar métodos de instancia o macros de DSL. |


En resumen:  
- `eval` = ejecuta strings como código.  
- `instance_eval` = mete el bloque dentro de **una instancia**.
- `instance_exec` = me permite pasar argumento  
- `class_eval` = mete el bloque dentro de **la clase/módulo**.  

---
# Mixins vs. Traits
|   ********************* | **Mixins**      | **Traits**                 | **H.M** (Python) |
|-------------------------|-----------------|----------------------------|---------|
| **Granularidad**        | Módulo          | Método                     | Modulo
| **Mec. seleccion** | Automatico | Algebra |Autonatico
| **Implementación**      | Linearización   | Aplanado                   | Linealizados
| **Resolución de Conflictos** | Automática       | Manual                     | Automaticos
| **Estado**              | Sí              | No (Solo en smalltalk)                 | Si 
| **Rol de la clase**     | Solo cuando lo necesitas      | Sirmpre se deberia usar (Glue Code)     | El mismo de siempre
| **Flexibilidad**| Menos | Mas | Menos


<small> H.M = Herencia Multiple </small>

### Linealizacion 
Simplemetne cuando instancio una clase siemplemetne traigo todo los metodos de ese mixin(Clase abstracta)
Los mixines funcionan en RUNTIME ya que estan linalizados,  copiando las clases que hereda
* Si hay **super** ya que esta en metodo de ejecucion entonces esto permite que se puede ir para atras ( a -> b -> c )
_ _ _
### Aplanado 
No sucede en RUNTIME y cuando se ejecuta simplemente se "Aplana", copiando los metodos de los metodos de la  clases que hereda
* No  hay **super** ya qeu no existe el siguiente como el mixin ya que esta aplanado
_ _ _ 
### Confilcto 
El caso del rompo (rombo.puml) 


## Presencia en Tecnologías

| Lenguaje | Sintaxis Ejemplo | Granularidad | Linearización | Resolución de Conflictos | Estado |
|----------|--------------|--------------|---------------|--------------------------|--------|
| **Ruby** (Mixins) | `module MiModulo ... end` | ✅ Módulo | ✅ Sí | ✅ Automática | ✅ Sí |
| **Scala** (Traits[mixins]) | `trait MiTrait { ... }` | ✅ Modulo | ✅ Sí | ✅ Automatica | ✅ Si |

_ _ _ 
#### Protip
* Usar mixin cuanto más puedas para poder abstraer la lógica lo más posible
* Cuando se invierte el orden de prioridad (quién pisa a quién con los mixins), dejar documentado con fecha  

#### Patrones
  * Decorator Pattern -> No sirve para mixins
  * Cake Pattern -> Sirve para mixins y es el que usa la Unidad (es el que terminamos utilizando)

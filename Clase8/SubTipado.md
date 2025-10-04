# SubtiPado
---
### Tipos de Bounds
- `Corral[A]` aca puede entrar cualquier tipo de variable 
  - No podes certificar que TODOS los elementos entienden los mismo metodos
- `Corral[A <: Animal]` aca entra todo de animal para abajo restringiendo un poco el dominio de lo qeu puede entrar 
  - Esto te permite **Certificar** que todos los elementos de esta listan vna a entender los `metodos` de animal
- `Corral[A >: Animal]` aca deberiamos tener en la lista todos los objetos mas de alto jerarquia de animal por ejemplo `Object`
---
### Problemitas de Scala
```scala

var vacas: Set[Vaca] = set[Vaca]()
var animal: Animal = vaca // Esto funciona perfectamente
var animales: Set[Animal] = vacas //Esto no funciona

// Esto romperia ya que dentro de un set de animales SI pueddo guardar un set de Caballos
//  Pero un caballo no es una vaca ROMPE POR ESTO
//  Pero un caballo y una banca SI es un animal
animales.add(new Caballo) 
```
---
### Funciones en Scala
```scala
  // f[P, R] 
  var f: Vaca => Vaca = ???
  // Esta funcion acepta a cualquir vaca o superior a el
  // Esta funcion responde cualqueir vaca para abajo de ella
```
---
### Invarianza vs Bivarainza vs Covarianza 

#### Invarianza
- A =:= B ( A y B son del mismo tipo)
- `T[A]<:T[B]`
  - Sirve para los `set` que deben ser exactamente el mismo caso del `problemitas de Scala` 

#### Bivarianza
- A es subtipo o supertipo de B
- `T[A]<:T[B]`

#### Cobarianza
- A <: B Entonces 
- `T[A] <: T[B]`
  - Sirve para que la funcion de arriba devuelva `VacaLoca` se denota con `+`
  - Las listas **SI** son cobariantes pero los set **NO**

#### Contrabarianza
- A :> B
- `T[A] <: T[B]`
  - Sirve para que las funcion de arriba acepte cualquir cosa arriba de `Vaca`, se denota con `-`

*Notas*:
- Los parametros de entrada son contrabariantes por ejemplo parametros que le ingresa a la funcion
- los parametros de salida son contrabariantes por ejemplo un return
  - Siguen los valores de la funcion `[-P, +R]`
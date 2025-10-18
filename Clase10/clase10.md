# Clase 10 
- - -

*Notas:*
- **No** usar tanto `pathermatching` sino las `funciones nativas` del programa ya que si lo programamas vos te acoplas a la estructura brindada por el lenguaje
  - por ejemplo en vez de hacer `materia::otras` hacer `    heade(materias)`
- Hay que abstraer todO en pocas palabras 
- EL SENTIDO DE FUNCIONAL ES PODER ABSTRAR CADA VEZ MAS 
  - Hata que llegas a las funciones que conocemos de toda la vida `map`, `filter`, `flatmap`, etc

## Monadas 
Te dan el beneficio de no manejar caminos infelizces por ejemplo una lista vacia. 

`Unit :: T -> Monad[T]` 
  - Te genera una lista con un elemento 

`bind::(T -> Monad[R]) -> Monad[T] -> Monad[R]`
  - Desde una lista llegas a otra lista totalmetne distinta sin saber que pasa 

`zero :: Monad[T]`
  - Creas una monada con nada adentro 

`plus:: Monada[T] -> Monada[T] -> Monada[T]`
  - De 2 listas llegas a otra lista

### Tipos de monadas 
#### Option
2 posibilidades 
- o tenes algo tipo T
- o no tenes nada None

*Tips*
- Se puede filtrar

#### Try
2 posibilidades (Se usa para las exepciones)
- O tenes el valor 
- O o notenes nada y tiras una expecion
  - Podes tener `recover` que si te tira un error podes salvarlo gracias a esto 

*Tips*
- No se puede filtrar

#### Ejemplo de monadas 
- Either 
- State 
- I/O -> No tiene trasparencia referencial 
- Future -> Son las promesas de Js, que no son de todo una monadas
- Trasformadores
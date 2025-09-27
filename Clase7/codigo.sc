trait Defesnor { // Misin de toda la vida pero se llama trati
    // Declaracion de los metodos
    def potencialDefensivo : Int
    def recibirDanio(danio: Int) : Unit
}
type Atacable{ // Sirve para abstraer lo que deberia estar en la firma de atacarA
// Esto te permite no tener que importarlo en que solo a lo que le llegue a atacar tiene 
// que tener estos 2 metodos
        def potencialDefensivo : Int
        def recibirDanio(danio: Int) : Unit
}

class Guerrero(var potencialOfensivo: Int = 20 ) extends Defesnor {
    
    var energia: Int = 100
    var potencialDefensivo: Int = 10

    def rexibirDanio(danio: Int) = {
        this.energia = (this.energia - danio).max(0)
    }
    
    // Unit es igual a void
    // Val son las constantes
// Aca estas anclado a lo suqe te llega tiene que ser SI o SI un defensor
    def atacaA(otro: Defesnor): Unit = {
        if(otro.potencialDefensivo < this.potencialOfensivo) {
            otro.recibirDanio(this.potencialOfensivo - otro.potencialOfensivo )
        }
    }
// La ventaja de esto es que no me hace falta llegar algo que sea defensor solo que tenga
// Los metodos que tiene que rexibir 
    def atacaA(otro: Atacable) = {
            if(otro.potencialDefensivo < this.potencialOfensivo) {
            otro.recibirDanio(this.potencialOfensivo - otro.potencialOfensivo )
        }
    }
}

class Misil(val anioFabricacion: Int){
    def atacaA(otro: Any) =

    def potencialOfensivo : Int = {
        (2016 - anioFabricacion) = 10
    }
}

class Muralla extends Defesnor{
    var energia = 1000
    var potencialDefensivo: Int = 10

}


class Espadachin (val potencialOfensivoDeEspada: Int ) {
    extends Guerrero(potencialDefensivo = 30) {}
}
val connan = new Guerrero()
val zorro = new Espadachin(50)
val muralla = new Muralla()

conna.atacaA(muralla) // No puede hacerse ya que atacarA es un guerrero per rexibe una muralla 


var espadachin: Espadachin = zorro

// Ejemplo de falso negativo
val connan2 : Object = new Guerrero
connan2.atacaA(zorro)
// Si bien conna2 es un guerrro no puede tener su mensajes ya qeu solo entede
// Los menajes del Obeject NO los de oGuerrro
// Por eso la linea 33 romperia


// Resumen de la clase 
// Puedo  guardar algo de tipo Padre (Guerrero) = un Hijo(Espadachin)
// No puedo guardar el tipo hijo(Espadachin) = un tipo padre (Guerrero)
    // YA que al guardarle un padre en un hijo no entenderia un monton de metodos que guardamos en espachin
    // No ententendiendo todos los metodos de Espadachin SOLO los de guerreros
    // Rompiendo el programa :D 


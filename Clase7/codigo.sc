trait Defesnor { // Misin de toda la vida pero se llama trati
    // Declaracion de los metodos
    def potencialDefensivo : Int
    def recibirDanio(danio: Int) : Unit
}

class Guerrero(var potencialOfensivo: Int = 20 ) extends Defesnor {
    
    var energia: Int = 100
    var potencialDefensivo: Int = 10
    
    // Unit es igual a void
    // Val son las constantes

    def atacaA(otro: Defesnor): Unit = {
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


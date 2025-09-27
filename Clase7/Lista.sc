Class Lista{
    var elementos: Array
    def tamanio : Int
    def concatenar(otra: Lista) : Lista
    def include (elemento: Object): Lista
    def filtrar(condicion: Object => Boolean) : Lista {
        val respuesta = new Array()
        for(elemento  <- elementos){
            if(codnficion(elemento)){
                respuesta.add(elemento)
            }
        }
        return respuesta
    }
}
val lista = new Lista()

// Esto no va a andar ya que lo que rexibe es objet y no va a entender el mensaje.energia
lista.filtrar(guerrero => guerrero.energia > 10)

// La una forma de arreglarlo esto es que hay que castear el estonces 
lista.filtrar(guerrero => guerrero.asInstanceOf[Guerrero].energia > 10)

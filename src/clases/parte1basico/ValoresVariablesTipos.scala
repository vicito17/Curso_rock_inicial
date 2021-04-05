package clases.parte1basico


object ValoresVariablesTipos extends App {

  val x: Int = 42 // equivalente a val x = 42 la maquina detecta el número

  println(x)
//  Inmutables (val)
//  Tipos de variables
  val aString: String = "Hola, Scala";
  val anotherString = "Adios"

  val aBoolean : Boolean = false
  val aChar: Char ='a'
  val aShort : Short = 32767
  val aLong : Long = 43243543545342334L
  val aFloat : Float = 2.0f
  val aDouble : Double = 3.14

//  variables (var)
  var aVariable: Int = 4
}

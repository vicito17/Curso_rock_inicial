package clases.parte3Funciones

object AnonymusFunctions extends App{

  val doubler: Int=> Int = (x: Int) => x*2

  val adder: (Int, Int)=> Int = (a:Int, b:Int)=> a+b

  val JustDoSomething: ()=> Int = () => 3

  println(JustDoSomething)
  println(JustDoSomething())

  val stringToInt = {(str: String)=>
    str.toInt
  }

  println(stringToInt("45"))
//  val niceIncrementer: Int=> Int = (x:Int)=> x+1
  val niceIncrementer: Int=> Int = _ + 1//equivalente a lo anterior
  val niceAdder: (Int, Int) => Int = _ + _

  val supperSdder = (x: Int ) => (y: Int) => x + y

}

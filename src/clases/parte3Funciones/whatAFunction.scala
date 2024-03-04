package clases.parte3Funciones

object whatAFunction extends App{
  //Dream use functions as first class elements
  //probel opp

  val doubler = new MyFunction[Int, Int]{
    override def apply(element: Int): Int = element * 2
  }
  val sringtoInteConverter = new Function1[String, Int] {
    override def apply(string: String): Int = string.toInt
  }
  println(sringtoInteConverter("3") + 5)
  val adder: ((Int, Int)=> Int) = new Function2[Int,Int,Int]{
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }
  val concatStrings: (String, String) => String = new Function2[String, String, String]{
    override def apply(v1: String, v2:String): String = v1 + v2
  }

  val superAdder= new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int):Function1[Int, Int] = new Function1[Int, Int]{
      override def apply(y : Int): Int = y + x
    }
  }
  val adder3 = superAdder(3)
  println(adder3(4))
  println(superAdder(3)(4))
}
trait MyFunction[A,B]{
  def apply(element: A): B
}
// exercices
//1 create function concatenate 2 strings
//transform MyPredicate an MyTransform into function types
//define a function which takes an int rteturns function wich takes an int and returns an int
// - what's type of this function
//- how do ir


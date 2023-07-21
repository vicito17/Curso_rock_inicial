package clases.parte2oop

import playground.{Cinderella=> Princess, PrinceCharming}

object PackagingAndImports extends App{

  // package members are accessible by their simple name
  val writer = new Writer("Daniel", "RockTheJVM", 2018)

  // import the package

  val princess = new Princess
  sayHello
  println(SPEED_OF_LIGHT)

  val prince = new PrinceCharming

  // 1. use FQ names
  val date = new Date
  val sqlDate = new SqlDate(2018, 5, 4)
  // 2. use aliasing

  // default imports
  // java.lang - String, Object, Exception
  // scala - Int, Nothing, Function
  // scala.Predef - println, ???
}

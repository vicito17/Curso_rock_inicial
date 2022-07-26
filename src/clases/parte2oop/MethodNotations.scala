package clases.parte2oop

object MethodNotations extends App{


  //constructor
  class Person(val name: String, favouriteMovie: String, age: Int){
    def likes(movie: String): Boolean= movie == favouriteMovie
    def +(person: Person): String = s"${this.name} is haging out with ${person.name}"
    def unary_! : String = s"$name, what the heck?!"
    def isAlive: Boolean = true
    def apply(): String = s"Hi my name is $name and I like $favouriteMovie"
    def apply(value: Int): String = s"${this.name} watched $favouriteMovie $value times"
    def +(value: String): Person = new Person("${this.name} + ($value)", favouriteMovie, age)
    def unary_+ : Person = new Person(this.name, favouriteMovie, age +1 )
    def learns(value: String) : String = s"${this.name} learns $value"
    def learns : String = s"${this.name} learns scala"
  }
  val mary = new Person("Mary", "Inception",20)
  println(mary.likes("Inception"))
  println(mary likes "Inception")

  val tom = new Person("Tom", "Tight club", 20)
//  println(mary hangOutWith tom)
  println(mary + tom)

  println(1+2)
  println(1.+(2))
  println(1.unary_-)

  println(!mary)
  println(mary.unary_!)


  println(mary.apply())
  println(mary())

  println(mary + "the rockstar")
  println(+mary)
  println(mary learns "java")
  println(mary.learns)
  println(mary(10))
}

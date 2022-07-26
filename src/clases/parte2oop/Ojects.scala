package clases.parte2oop

object Ojects extends App{

  object Person {// esto es una instancia
    // "static/"class" -- level functionality

    val N_EYES = 2
    def canFly: Boolean = false

    def apply(mother: Person, father: Person): Person= new Person("Bobbie")
  }

  class Person(val name: String) {
//instnce level functionality
  }
  println(Person.N_EYES)
  println(Person.canFly)

  //la diferencia entre la clase y el objeto es que el objeto es una estancia o singleton única por lo que
  // si se da el caso para definir la clase necesitaremos el new y para el objeto no hace falta

  val mary = new Person("Mary")
  val john = new Person("John")
  println(mary == john)

  val person1 = Person
  val person2 = Person
  println(person1==person2)
  val bobbie = Person(mary, john)

  // Scala Application = scala object
//  def 
}

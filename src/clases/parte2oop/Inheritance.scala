package clases.parte2oop

object Inheritance extends  App {

  class Animal{
    val creatureType = "wild"
    def eat = println("nomnom")
//    private def eat = println("nomnom") en este caso no se herreda la funcion
    //    protected def eat = println("nomnom") // solo se puede llamar dentro de la clase o subclase
    //    final def eat = println("nomnom") // impide que las subclase modifiquen esta caracteristica/ funcion

  }
  class Cat extends Animal{
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch

  class Person(name: String, age: Int){
    def this(name: String) = this(name,0) // esto nos permite cuando extendamos no tener que poner algunos parametros
    // porque le estamos diciendo que en caso de solo tener un parametro de entrada el name el age se convertira en 0
  }
  class Adult(name: String, age: Int, IdCard: String) extends Person(name, age)

  class Dog extends Animal{
    override val creatureType: String =  "domestic"
    override  def eat = print("crunch, crunch")

  }

  val dog = new Dog
  dog.eat
  println(dog.creatureType)



  class Dog2(override val creatureType: String) extends Animal{
    override  def eat = {
      super.eat
      print("crunch, crunch")
    }

  }

  val dog2 = new Dog2("domestic")
  dog2.eat
  println(dog2.creatureType)


  val unknownAnimal : Animal = new Dog2("K9")
  unknownAnimal.eat

  //overRIDING vs overLOADING
  //super sirve para llamar a una funcion de la clase inicial
  //prevent
// 1 - use final on member ese elemetno no se podrá modificar
// 2- use final on the entire class no se podrá modificar nada de la clase
// 3 - seal the class = extend classe in this file and prevent extension in other files

}

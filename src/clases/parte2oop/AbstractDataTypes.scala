package clases.parte2oop

object AbstractDataTypes extends App {

  abstract class  Animal{
    val creatureType: String = "wild"
    def eat: Unit
  }
  class Dog extends Animal{
    override val creatureType: String = "Canine"
    def eat: Unit = println("crunch crunch")
  }
  trait Carnivor{
    def eat(animal: Animal): Unit
    val preferredMeal: String = "fresh meat"
  }
  trait ColdBlood
  class Crocodile extends Animal with Carnivor with ColdBlood {
    override val creatureType: String = "croc"
    def eat: Unit = println("nomnomnom")
    def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")

  }

  val dog = new Dog
  val croc = new Crocodile
  croc eat dog

//  traits vs abs
// traits do not have constructor parameters in scala 3 yes
// we can use multiple traits
// las clases son el cuerpo lo que son y los traits los habitos

}

package clases.parte2oop

object Generics extends App{

  class MyList[+A]{
    //use the type
    def add[B>: A](element: B): MyList[B] = ???
    /*
      A = Cat
      B = Animal
    */
    // Esto se hace porque un un elemento de clase DOG no puede estar en una lista de clase Cat
    //No obstante ambos pueden estar en una lista de elementos de clase Animal
  }
  class MyMap[Key, Value]
  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // generic methods
  object MyList{
    def empty[A]: MyList[A] = ???
  }
  val emptyListOfInteger = MyList.empty[Int]

  // variance problem
  // (don't stress about it)
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // 1. yes, List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) ??? HARD QUESTION => we return a list of Animals

  // 2. NO = INVARIANCE
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. Hell, no! CONTRAVARIANCE
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded types
  // <: Solo acepta subtipos
  // >: solo acepta supertipos
  class Cage[A <: Animal](animal: A)
  val cage = new Cage(new Dog)

  class Car
  // generic type needs proper bounded type
  //  val newCage = new Cage(new Car)


  // expand MyList to be generic

}

package clases.parte2oop


abstract class MyList[+A] {
  /*
  head = first element of the list
  tail = reminder of the list
  isEmpti = is this list empty
  add(int) => new list with this element added
  toString => a string representation of the list
   */
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B>: A](n:B): MyList[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"
  def map[B](transformer: MyTransformer[A,B]): MyList[B]
  def flatMap[B](transformer:MyTransformer[A,MyList[B]]): MyList[B]
  def filter(predicate:  MyPredicate[A]): MyList[A]
  //concatenation
  def ++[B >: A ](list: MyList[B]): MyList[B]

}
case object Empty extends MyList[Nothing]{
  def head: Nothing = throw new NoSuchMethodException()
  def tail: MyList[Nothing] =  throw new NoSuchMethodException()
  def isEmpty: Boolean =  true
  def add[B >: Nothing](n:B): MyList[B] = new Cons[B](n, Empty)
  def printElements: String = ""
  def map[B](transformer: MyTransformer[Nothing,B]): MyList[Nothing] = Empty
  def flatMap[B](transformer:MyTransformer[Nothing,MyList[B]]): MyList[Nothing] = Empty
  def filter(predicate:  MyPredicate[Nothing]): MyList[Nothing] = Empty
  def ++[B >: Nothing ](list: MyList[B]): MyList[B] = list


}
case class Cons[+A](h: A, t: MyList[A]) extends MyList[A]{
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](n:B): MyList[B] = Cons(n, this)
  def printElements: String = {
    if(t.isEmpty) "" + h
    else s"$h ${t.printElements}"
  }

  def filter(predicate:  MyPredicate[A]): MyList[A]={
    if(predicate.test(h)) new Cons(h,t.filter(predicate))
    else t.filter(predicate)
  }
  def map[B](transformer: MyTransformer[A,B]): MyList[B] =
    new Cons(transformer.transform(h), t.map(transformer))

  def ++[B>:A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)

  def flatMap[B](transformer:MyTransformer[A,MyList[B]]): MyList[B] =
    transformer.transform(h) ++ t.flatMap(transformer)

}
trait MyPredicate[-T]{
  def test(elem: T): Boolean
}
trait MyTransformer[-A, B]{
  def transform(element: A): B
}

//
//class EvenPredicate extends MyPredicate[Int]{
//  override test[Int](element: Int): Boolean = (elememt % 2)==0
//}

object ListTest extends App{
  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val cloneListOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val listOfAnotherIntegers: MyList[Int] = new Cons(4, new Cons(5, new Cons(6, Empty)))
  val listOfStrings: MyList[String] = new Cons("Hello", new Cons("Scala", Empty))
  println(listOfIntegers.toString)
  println(listOfStrings.toString)

  println(listOfIntegers.map(new MyTransformer[Int,Int]{
    override def transform(element: Int): Int = element * 2
  }))

  println(listOfIntegers.filter(new MyPredicate[Int]{
    override def test(elem: Int): Boolean = elem % 2 ==0
  }).toString)

  println((listOfIntegers ++ listOfAnotherIntegers).toString)
  println(listOfIntegers.flatMap(new MyTransformer[Int, MyList[Int]]{
    override def transform(element: Int): MyList[Int] = new Cons[Int](element, new Cons[Int](element + 1, Empty))
  }).toString)
  println(cloneListOfIntegers== listOfIntegers)
}
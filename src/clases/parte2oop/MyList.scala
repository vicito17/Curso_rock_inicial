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
  def map[B](transformer: A =>B): MyList[B]
  def flatMap[B](transformer:A => MyList[B]): MyList[B]
  def filter(predicate:  A => Boolean): MyList[A]
  //concatenation
  def ++[B >: A ](list: MyList[B]): MyList[B]

  def foreach(f: A => Unit): Unit
  def sort(compare: (A,A) => Int ): MyList[A]

  def zipWith[B,C](list: MyList[B], zip: (A, B)=> C): MyList[C]
  def fold[B](start: B)(operator:(B, A) => B) : B
}
case object Empty extends MyList[Nothing]{
  def head: Nothing = throw new NoSuchMethodException()
  def tail: MyList[Nothing] =  throw new NoSuchMethodException()
  def isEmpty: Boolean =  true
  def add[B >: Nothing](n:B): MyList[B] = new Cons[B](n, Empty)
  def printElements: String = ""
  def map[B](transformer: Nothing => B ): MyList[Nothing] = Empty
  def flatMap[B](transformer: Nothing =>MyList[B]): MyList[Nothing] = Empty
  def filter(predicate:  Nothing => Boolean): MyList[Nothing] = Empty
  def ++[B >: Nothing ](list: MyList[B]): MyList[B] = list

  def foreach(f: Nothing => Unit): Unit = ()
  def sort(compare: (Nothing, Nothing) => Int ) = Empty

  def zipWith[B,C](list: MyList[B], zip: (Nothing, B)=> C): MyList[C] = {
    if (!list.isEmpty) throw new RuntimeException("The list don'tn have same length")
    else Empty

  }

  def fold[B](start: B)(operator:(B, Nothing) => B) : B = start

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

  def filter(predicate:  A=> Boolean): MyList[A]={
    if(predicate(h)) new Cons(h,t.filter(predicate))
    else t.filter(predicate)
  }
  def map[B](transformer: A =>B): MyList[B] =
    new Cons(transformer(h), t.map(transformer))

  def ++[B>:A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)

  def flatMap[B](transformer:A =>MyList[B]): MyList[B] =
    transformer(h) ++ t.flatMap(transformer)

  def foreach(f: A => Unit): Unit = {
    f(head)
    tail.foreach(f)
  }

  def sort(compare: (A,A) => Int ): MyList[A] = {
    def insert(x: A, sortedList: MyList[A]): MyList[A] = {
      if(sortedList.isEmpty) new Cons(x, Empty)
      else if(compare(x, sortedList.head) >= 0) new Cons(sortedList.head, insert(x, sortedList.tail))
      else new Cons(x, sortedList)
    }
    val sortedTail = t.sort(compare)
    insert(head, sortedTail)
  }

  def zipWith[B,C](list: MyList[B], zip: (A, B)=> C): MyList[C] = {
    if (list.isEmpty) throw new RuntimeException("The list don'tn have same length")
    else new Cons[C]( zip(head, list.head), tail.zipWith(list.tail, zip))
  }

  def fold[B](start: B)(operator:(B, A) => B) : B = {
    val newStart = operator(start, head)
    tail.fold(newStart)(operator)
  }


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
  val listOfAnotherIntegers: MyList[Int] = new Cons(4, new Cons(5, Empty))
  val listOfStrings: MyList[String] = new Cons("Hello", new Cons("Scala", Empty))
  println(listOfIntegers.toString)
  println(listOfStrings.toString)

  println(listOfIntegers.map(_ * 2).toString)

  println(listOfIntegers.filter(_ % 2 ==0).toString)

  println((listOfIntegers ++ listOfAnotherIntegers).toString)
  println(listOfIntegers.flatMap( elem => new Cons[Int](elem, new Cons[Int](elem + 1, Empty))))
  println(cloneListOfIntegers == listOfIntegers)
  listOfIntegers.foreach( println)
  println(listOfIntegers.sort((x: Int, y: Int) => x - y))
  println(listOfAnotherIntegers.zipWith(listOfStrings, _ + "-" + _))
  println(listOfIntegers.fold(0)(_ + _))

}
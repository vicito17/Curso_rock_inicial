//package clases.parte2oop
//
//abstract class MyList_or {
//  /*
//  head = first element of the list
//  tail = reminder of the list
//  isEmpti = is this list empty
//  add(int) => new list with this element added
//  toString => a string representation of the list
//   */
//  def head: Int
//  def tail: MyList
//  def isEmpty: Boolean
//  def add(n:Int): MyList
//  def printElements: String
//  override def toString: String = "[" + printElements + "]"
//
//}
//object Empty extends MyList{
//  def head: Int = throw new NoSuchMethodException()
//  def tail: MyList =  throw new NoSuchMethodException()
//  def isEmpty: Boolean =  throw new NoSuchMethodException()
//  def add(n:Int): MyList = new Cons(n, Empty)
//  def printElements: String = ""
//
//}
//class Cons(h: Int, t: MyList) extends MyList{
//  def head: Int = h
//  def tail: MyList = t
//  def isEmpty: Boolean = false
//  def add(n:Int): MyList = Cons(n, this)
//  def printElements: String = {
//    if(t.isEmpty) "" + h
//    else h + " " + t.printElements
//  }
//}
//object ListTest extends App{
//  val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
//  println(list.tail.head)
//  println((list add 4).head)
//  println(list.isEmpty)
//  println(list.toString())
//}
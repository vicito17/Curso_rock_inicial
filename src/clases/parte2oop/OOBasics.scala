package clases.parte2oop

import org.w3c.dom.css.Counter

object OOBasics extends App{

  val person = new Person("Johm", 26)
  println(person.x)
  person.greet("paco")

}

//constructor
class Person(val name: String, val age: Int){
  val x = 2
  println(4 )
  //metod
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")
  //overloading tenemos más de una funcion con el mismo nombre pero se diferencia el tipo de entrada
  def greet(): Unit = println(s"I am ${this.name}")
  //multple constructor

  def this(name: String)= this("name", 0)
  def this() = this("John Doe")
}

// class parameters are not fields

/* Exercices
Novel and a writer
writer: first name surname, year
- method fullname

Novel: name, year of realise, author
- author age
- isWriteBy(author)
- copy(new year of realese) = new instance of Novel

*/

class Writer(fistName: String, surname: String, val year: Int){
  def fullname(): String = this.fistName + " " + this.surname
}

class Novel(name: String, year: Int, author: Writer){
  def authorAge():Int = year - this.author.year
  def isWrittenBy(author:Writer): Boolean= this.author.equals(author)// se usa el equals en vez del porque equal compara la parte interna del objeto
  def copy(newYear: Int): Novel= Novel(this.name, year, this.author)
}

class Counter(var countValue: Int){
  //  def count(): Int = this.countValue
  def dec = new Counter( this.countValue - 1)
  def inc = new Counter( this.countValue + 1)
  def inc(incrementValue: Int): Counter= {
    if(incrementValue<1) this
    else inc.inc(incrementValue-1)
  }

  def dec(incrementValue: Int): Counter= {
    if(incrementValue<1) this
    else dec.dec(incrementValue-1)
  }

}
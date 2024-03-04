package lectures.part3fp

import scala.annotation.tailrec

/**
 * Created by Daniel.
 */
object TuplesAndMaps extends App {

  // tuples = finite ordered "lists"
  val aTuple = (2, "hello, Scala")  // Tuple2[Int, String] = (Int, String)

  println(aTuple._1)  // 2
  println(aTuple.copy(_2 = "goodbye Java"))
  println(aTuple.swap)  // ("hello, Scala", 2)

  // Maps - keys -> values
  val aMap: Map[String, Int] = Map()

  val phonebook = Map(("Jim", 555), "Daniel" -> 789, ("JIM", 9000)).withDefaultValue(-1)// si no esta devuelve un -1
  // a -> b is sugar for (a, b)
  println(phonebook)

  // map ops
  println(phonebook.contains("Jim"))
  println(phonebook("Mary"))
  println(phonebook.get("Mary"))

  // add a pairing
  val newPairing = "Mary" -> 678
  val newPhonebook = phonebook + newPairing
  println(newPhonebook)

  // functionals on maps
  // map, flatMap, filter
  println(phonebook.map(pair => pair._1.toLowerCase -> pair._2))

  // filterKeys
  println(phonebook.view.filterKeys(x => x.startsWith("J")))
  // mapValues
  println(phonebook.view.mapValues(number => "0245-" + number))

  // conversions to other collections
  println(phonebook.toList)
  println(List(("Daniel", 555)).toMap)
  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
  println(names.groupBy(name => name.charAt(0)))
  println(names.groupBy(name => name charAt 0))

  /*
    1.  What would happen if I had two original entries "Jim" -> 555 and "JIM" -> 900

        !!! careful with mapping keys.

    2.  Overly simplified social network based on maps
        Person = String
        - add a person to the network
        - remove
        - friend (mutual)
        - unfriend

        - number of friends of a person
        - person with most friends
        - how many people have NO friends
        - if there is a social connection between two people (direct or not)
   */


}
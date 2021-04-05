package clases.parte1basico

import scala.annotation.tailrec

object Recursion extends App {
  def factorial(n: Int): Int =
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need factorial of " + (n-1))
      val result = n * factorial(n-1)
      println("Computed factorial of " + n)

      result
    }

//  println(factorial(10))
  //  println(factorial(5000))

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator) // TAIL RECURSION = use recursive call as the LAST expression

    factHelper(n, 1)
  }

  /*
    anotherFactorial(10) = factHelper(10, 1)
    = factHelper(9, 10 * 1)
    = factHelper(8, 9 * 10 * 1)
    = factHelper(7, 8 * 9 * 10 * 1)
    = ...
    = factHelper(2, 3 * 4 * ... * 10 * 1)
    = factHelper(1, 1 * 2 * 3 * 4 * ... * 10)
    = 1 * 2 * 3 * 4 * ... * 10
   */

//  println(anotherFactorial(20000))

  // WHEN YOU NEED LOOPS, USE _TAIL_ RECURSION.

  /*
    1.  Concatenate a string n times
    2.  IsPrime function tail recursive
    3.  Fibonacci function, tail recursive.
   */
  def fun_con(str : String, n: Int, acum : String ): String={
  if(n == 0) acum
  else fun_con(str, n-1, str+ " " +acum)
  }
  println(fun_con("Hola",5,""))

  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailrec(t: Int, noesprimo: Boolean): Boolean = {
      println(noesprimo)
      if (!noesprimo) false
      else if (t <= 1) true
      else isPrimeTailrec(t - 1, n % t != 0 && noesprimo)
    }

    isPrimeTailrec(n / 2, true)
  }
  println(isPrime(7))
  def fibonacci(n: Int): Int = {
    def fiboTailrec(i: Int, last: Int, nextToLast: Int): Int =
      if(i >= n) last
      else fiboTailrec(i + 1, last + nextToLast, last)

    if (n <= 2) 1
    else fiboTailrec(2, 1, 1)
  }

  println(fibonacci(8)) // 1 1 2 3 5 8 13, 21

}

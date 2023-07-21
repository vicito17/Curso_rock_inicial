package clases.parte3Funciones

object HOFsCurries extends App{
  val superFunctions: (Int, (String, (Int => Boolean)) => Int) => (Int=> Int) = null
//  function that applies a function n times over a value x
//  nTimes(f,n,x)
//  ntime(f,3,x)= f(f(f(x)))
  def nTimes(f: Int => Int, n: Int, x:Int): Int = {
    if (n <= 0) x
    else nTimes(f,n-1,f(x))
  }
  val plusOne = (x: Int) => x +1
  println(nTimes(plusOne,10,1))
  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) =
    if (n <= 0)  (x: Int) => x
    else (x: Int) => nTimesBetter(f,n-1)(f(x))


  val plus10 = nTimesBetter(plusOne,10)
  println(plus10(1))

  val superAdder: Int=> (Int => Int) = (x: Int)=> (y: Int) => x + y
  val add3 = superAdder(3)
  println(add3(10))
  println(superAdder(3)(10))

  }

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

  def curriedFormatter(c: String) (x: Double): String = c.format(x)
  val  standardFormat: (Double => String) = curriedFormatter("%4.2f")
  val  preciseFormat: (Double => String) = curriedFormatter("%10.8f")

  println(standardFormat(Math.PI))
  println(preciseFormat(Math.PI))

  /*
  1 Expand MyList
  - foreach Metod A => Unit
  [1,2,3].foreach(x => println(x))

  - sort Fnction  ((A,A) => Int)
  [1,2,3].sort((x,y) => y - x) => [3,2,1]

  - zipWith (list, (A, A) => B) MyList[B]
    [1,2,3].zipWith([4,5,6] => x x y ) => [1 * 4, 2 * 5, 3 * 6]

  - fold(start)(function) => a value
  [1, 2, 3].fold(0)(x + y)

 2 toCurry(f:(Int, Int) => Int) => (Int => Int => Int)
   fromCurry(f:(Int => Int => Int)) => (Int, Int) => Int

 3 compose(f, g) => x: Int = f(g(x))
   andThen(f, g) => x: Int = g(f(x))
*/
  def  toCurry(f:(x:Int, y:Int) => Int): (Int => Int => Int) = x => y => f(x,y)
  def  fromCurry(f: (Int => Int => Int)): (Int, Int) => Int = (x, y) => f(x)(y)
  def compose[A,B, T]( f: A => B, g: T => A): T => B = x => f(g(x))
  def andThen[A, B, C]( f: A => B, g: B => C): A => C = x => g(f(x))
  }

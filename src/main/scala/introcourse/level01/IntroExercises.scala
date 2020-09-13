package introcourse.level01

/**
  * Level 1 focuses on basic Scala, including syntax and especially programming with functions.
  * We will go through a few exercises to familiarise ourselves with writing Scala.
  *
  * What's a function?
  *
  * A function takes inputs and returns an output.
  * It should always return the same output given the same inputs.
  */
object IntroExercises {

  /**
    * This function called `add` takes two Ints and return an Int.
    * You must specify the types of the inputs but the output return type is optional
    * and can be inferred by the compiler.
    * scala> add(1, 2)
    * > 3
    **/
  def add(x: Int, y: Int): Int = x + y


  /**
    * Let's write the curried version of the `add` function defined previously
    * scala> addCurried(1)(2)
    * > 3
    **/
  def addCurried(x: Int)(y: Int): Int = x + y


  /**
    * Reuse the `addCurried` function and partially apply it for adding 5 to anything.
    * scala> add5(4)
    * > 9
    *
    **/
  def add5(x: Int): Int = {
    val f: Int => Int = addCurried(x)
    f(5)
  }

  /**
    * Parametric types
    *
    * How many ways can you implement this function?
    * Just 1
    * Note: Square brackets (Types at compile time), round brackets (Values at run time)
    */
  def foo[A](a: A): A = a

  /**
    * How about this one?
    * As long as it returns an int, many ways to implement this
    */
  def bar(a: Int): Int = a + 1

  /**
    * What does the return type of this function tell us about
    * what it can do once implemented?
    * Unit equivalent to Void, usually make a side effect
    */
  def pandora(x: Int): Unit = {
    println("hi")
  }

  /**
    * scala> timesTwoIfEven(4)
    * > 8
    * scala> timesTwoIfEven(3)
    * > 3
    *
    * Important: Every `if` must have an `else`! Otherwise your function is not total.
    */
  def timesTwoIfEven(x: Int): Int = {
    if(x % 2 == 0) {
      x * 2
    } else {
      x
    }
  }

  /**
    * scala> showNumber(100)
    * > "The number is 100"
    *
    * Hint: Use string interpolation, e.g. s"$x"
    */
  def showNumber(x: Int): String = s"The number is $x"

  /**
    * Tuples
    *
    * How can we group together `name` and `age` in a pair?
    */
  def pair(name: String, age: Int): (String, Int) = (name, age)

  /**
    * How can we extract the first element of a pair?
    *
    * Hint 1: Check the getters on `pair`.
    * Hint 2: Read up on pattern matching on tuples.
    *
    * https://docs.scala-lang.org/tour/tuples.html
    */
  def first(pair: (String, Int)): String = pair._1

  /**
    * How can we extract the second element of a pair?
    */
  def second(pair: (String, Int)): Int = pair._2

}

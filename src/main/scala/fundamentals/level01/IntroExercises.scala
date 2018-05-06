package fundamentals.level01


/**
  * Level 1 focuses on basic Scala, including syntax and especially programming with functions.
  * We will go through a few exercises to familiarise ourselves with writing Scala.
  *
  * An object:
  * - An object is a class that has exactly one instance (a singleton). It is also a value.
  */
object IntroExercises {

  /**
    * What's a function?
    *
    * A function takes inputs and returns an output.
    * Question: should a function always return the same output given the same inputs?
    *
    */

  /**
    * This function called `add` takes two Ints and return an Int.
    * You must specify the types of the inputs but the output return type is optional
    * and can be inferred by the compiler.
    * scala> add(1, 2)
    * = 3
    **/
  def add(x: Int, y: Int): Int = ???

  /**
    * Parametric types
    *
    * How many ways can you implement this function?
    * Note: Square brackets (Types at compile time), round brackets (Values at run time)
    */
  def foo[A](a: A): A = ???

  /**
    * How about this one?
    */
  def bar(a: Int): Int = ???

  /**
    * scala> timesTwoIfEven(4)
    * = 8
    * scala> timesTwoIfEven(3)
    * = 3
    *
    * Important: Every `if` must have an `else`! Otherwise your function is not total.
    */
  def timesTwoIfEven(x: Int): Int = ???

  /**
    * scala> showNumber(100)
    * = "The number is 100"
    *
    * Hint: Use string interpolation, e.g. s"$x"
    */
  def showNumber(x: Int): String = ???

}

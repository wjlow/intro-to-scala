package fundamentals.level01


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
    * = 3
    **/
  def add(x: Int, y: Int): Int = ???


  /**
    * Let's write the curried version of the `add` function defined previously
    * scala> addCurried(1)(2)
    * = 3
    **/
  def addCurried(x: Int)(y: Int): Int = ???


  /**
    * Reuse the `addCurried` function and partially apply it for adding 5 to anything.
    * scala> add5(4)
    * = 9
    *
    **/
  def add5(x: Int): Int = ???

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

  /**
    * What does the return type of this function tell us about
    * what it can do once implemented?
    */
  def pandora(x: Int): Unit = ???

}

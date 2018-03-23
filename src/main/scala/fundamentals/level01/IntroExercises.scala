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
    * This function called `add` takes two Ints and return an Int
    * You must specify the types of the inputs but the output return type is optional
    * scala> add(1, 2)
    * = 3
    **/
  def add(x: Int, y: Int): Int = ???

  /**
    * Currying
    *
    * What if we want to define a function `add5` that adds 5 to any `Int`?
    *
    * scala> add5(10)
    * = 15
    *
    * scala> add5(7)
    * = 12
    *
    * Hint: Use curriedAdd
    */
  def curriedAdd(x: Int)(y: Int): Int = ???

  def add5(y: Int): Int = ???

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

package level02

object ADT {

  /**
    * Level 2 introduces data structures and operations that work on them.
    *
    * Concepts covered: algebraic data types, pattern matching, map, filter, fold
    */

  /**
    * A simple data type
    *
    * Here is an example of a `Person` type, which is a wrapper on `String` and `Int`.
    *
    * This is a "product type", i.e. a `Person` is a "product" of `String` and `Int`.
    */
  case class Person(name: String, age: Int)

  /**
    * scala> val person = Person("Bob", 50)
    * scala> printPerson(person)
    * = "Bob is 50 years old"
    **/
  def printPerson(person: Person): String = ???

  /**
    * scala> val person = Person("Bob", 50)
    * scala> changeName("Bobby", person)
    * = Person("Bobby", 50)
    *
    * Hint: Use the .copy method
    */
  def changeName(newName: String, person: Person): Person = ???

  /**
    * A "sum type" represents more than one possible value.
    *
    * You can read the following as a `TrafficLight` is either `Red` or `Yellow` or `Green`.
    */
  sealed trait TrafficLight

  case object Red extends TrafficLight

  case object Yellow extends TrafficLight

  case object Green extends TrafficLight

  /**
    * scala> printTrafficLight(Red)
    * = "The traffic light is red"
    *
    * scala> printTrafficLight(Yellow)
    * = "The traffic light is yellow"
    *
    * scala> printTrafficLight(Green)
    * = "The traffic light is green"
    **/
  def printTrafficLight(trafficLight: TrafficLight): String = ???

  /**
    * A `List` in Scala is a linked list.
    *
    * sealed trait List[A]
    * case class ::[A](head: A, tail: List[A]) extends List[A]
    * case object Nil extends List[Nothing]
    *
    * You can create a List using the `::` constructor as such:
    *
    * scala> 1 :: 2 :: 3 :: Nil
    * = List(1, 2, 3)
    *
    * Often times, the `List.apply` static method is more convenient:
    *
    * scala> List.apply(1, 2, 3)
    *
    * The `apply` method in any object is the default method, so you can leave it out when using it:
    *
    * scala> List(1, 2, 3)
    */

  def isEmptyList[A](xs: List[A]): Boolean = ???

  def prependToList[A](x: A, xs: List[A]): List[A] = ???

  def appendToList[A](x: A, xs: List[A]): List[A] = ???

  /**
    * Mapping a function over a List
    *
    * This is typically what you want if the initial List and the resulting List
    * are of the same size.
    */

  /**
    * scala> addNumToEach(10, List(1, 2, 3))
    * = List(11, 12, 13)
    **/
  def addNumToEach(num: Int, nums: List[Int]): List[Int] = ???

  /**
    * Filter a List
    *
    * This is typically what you want if the size of the resulting List is <= that of the initial.
    */
  def filterEven(nums: List[Int]): List[Int] = ???

  /**
    * Folds
    *
    * A fold is an operation over a data structure to yield a summary value.
    *
    * Examples: sum, product, min, max
    */

  /**
    * scala> product(List(2, 5, 3))
    * = 30
    * scala> product(Nil)
    * = 1
    */
  def product(nums: List[Int]): Int = ???

  /**
    * scala> min(List(4, 6, 1))
    * = 1
    **/
  def min(nums: List[Int]): Int = ???

}

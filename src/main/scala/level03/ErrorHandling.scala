package level03

import level02.ADT.{Person, TrafficLight}

object ErrorHandling {

  /**
    * scala> mean(List(1, 2, 10))
    * = 4.333333333333333
    *
    * What should the following return?
    *
    * scala> mean(Nil)
    * = ???
    **/
  def mean(nums: List[Int]): Double = ???

  /**
    * Option data type
    *
    * sealed trait Option[A]
    * case class Some[A](a: A) extends Option[A]
    * case object None extends Option[Nothing]
    */

  /**
    * Safe constructors
    *
    * Allows us to convert input from the real world (e.g. files, HTTP request, etc.) into ADTs
    */

  /**
    * scala> mkTrafficLight("red")
    * = Some(Red)
    *
    * scala> mkTrafficLight("bob")
    * = None
    **/
  def mkTrafficLight(str: String): Option[TrafficLight] = ???

  /**
    * scala> mkPerson("Bob", 20)
    * = Some(Person("Bob", 20))
    *
    * scala> mkPerson("", 20)
    * = None
    *
    * scala> mkPerson("Bob", -1)
    * = None
    **/
  def mkPerson(name: String, age: Int): Option[Person] = ???

  /**
    * scala> mkPersonAndThenChangeName("Bob", 20, "John")
    * = Some(Person("John", 20))
    *
    * scala> mkPersonAndThenChangeName("Bob", -1, "John")
    * = None
    *
    * For simplicity, let's allow changing to an empty name, like:
    *
    * scala> mkPersonAndThenChangeName("Bob", 20, "")
    * = Some(Person("", 20))
    */
  def mkPersonAndThenChangeName(oldName: String, age: Int, newName: String): Option[Person] = ???
}

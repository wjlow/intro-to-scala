package fundamentals.level03

import fundamentals.level02.TypesExercises._
import TrafficLight._

object OptionExercises1 {

  /**
    * Option data type
    *
    * sealed trait Option[+A]
    * case class Some[A](a: A) extends Option[A]
    * case object None extends Option[Nothing]
    */

  /**
    * scala> safeMean(List(1, 2, 10))
    * = Some(4.333333333333333)
    *
    * scala> safeMean(Nil)
    * = None
    **/
  def safeMean(nums: List[Int]): Option[Double] = ???

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
    * scala> mkTrafficLightThenShow("red")
    * = "Traffic light is red"
    *
    * scala> mkTrafficLightThenShow("bob")
    * = "Traffic light `bob` is invalid"
    *
    * Hint: Use `mkTrafficLight` and pattern matching.
    *
    * You can pattern match on `Option` using its two constructors `Some` and `None`:
    *
    * ```
    * optSomething match {
    *   case Some(a) => // do something with `a`
    *   case None => // do something else
    * }
    * ```
    */
  def mkTrafficLightThenShow(str: String): String = ???

  /**
    * scala> mkPerson("Bob", 20)
    * = Some(Person("Bob", 20))
    *
    * If `name` is blank:
    *
    * scala> mkPerson("", 20)
    * = None
    *
    * If `age` < 0:
    *
    * scala> mkPerson("Bob", -1)
    * = None
    *
    * You can solve this with standard if-statements, but let's try solve this using pattern matching.
    * We create a pair `(name, age)` and pattern match on the values.
    **/
  def mkPerson(name: String, age: Int): Option[Person] =
    (name, age) match {
      case (n, a) if n.isEmpty => ???
      case (n, a) if a < 0 => ???
      case (n, a) => ???
    }

  /**
    * scala> mkPersonThenChangeName("Bob", 20, "John")
    * = Some(Person("John", 20))
    *
    * scala> mkPersonThenChangeName("Bob", -1, "John")
    * = None
    *
    * For simplicity, let's allow changing to an empty name, like:
    *
    * scala> mkPersonThenChangeName("Bob", 20, "")
    * = Some(Person("", 20))
    *
    * Hint: Use `mkPerson` and `changeName`
    **/
  def mkPersonThenChangeName(oldName: String, age: Int, newName: String): Option[Person] = ???

}

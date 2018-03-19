package fundamentals.level03

import fundamentals.level02.TypesExercises.{Person, TrafficLight}

object NullExercises {

  /**
    * scala> mkTrafficLightOrNull("red")
    * = Red
    *
    * scala> mkTrafficLightOrNull("bob")
    * = null
    **/
  def mkTrafficLightOrNull(str: String): TrafficLight = ???

  /**
    * scala> mkTrafficLightOrNullThenShow("red")
    * = "Traffic light is red"
    *
    * scala> mkTrafficLightOrNullThenShow("bob")
    * = "Traffic light is invalid"
    *
    * Hint: Use `mkTrafficLightOrNull` and pattern matching
    */
  def mkTrafficLightOrNullThenShow(str: String): String = ???

  /**
    * scala> mkPerson("Bob", 20)
    * = Person("Bob", 20)
    *
    * scala> mkPerson("", 20)
    * = null
    *
    * scala> mkPerson("Bob", -1)
    * = null
    **/
  def mkPersonOrNull(name: String, age: Int): Person = ???

  /**
    * scala> mkPersonOrNullThenChangeName("Bob", 20, "John")
    * = Person("John", 20)
    *
    * scala> mkPersonOrNullThenChangeName("Bob", -1, "John")
    * = null
    *
    * For simplicity, let's allow changing to an empty name, like:
    *
    * scala> mkPersonOrNullThenChangeName("Bob", 20, "")
    * = Person("", 20)
    **/
  def mkPersonOrNullThenChangeName(oldName: String, age: Int, newName: String): Person = ???

  /**
    * Does the following function return a `null`?
    */
  def mean(nums: List[Int]): Double = ???

}

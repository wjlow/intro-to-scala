package introcourse.level04

import introcourse.level04

/**
  * These exercises are intended to show the problems that come with programming with `null`s.
  *
  * After these exercises, we will learn the alternative to using `null`s.
  */
@SuppressWarnings(Array("org.wartremover.warts.Null"))
object NullExercises {

  /**
    * From here on, we will work with a `TrafficLight` type that is defined in `package.scala`
    *
    * For simplicity, this type does not have a `Flashing` light.
    */

  /**
    * Let's start by converting `String`s from our nasty real world into our own `TrafficLight` ADT.
    * If given an unrecognised value, return `null`.
    *
    * scala> mkTrafficLightOrNull("red")
    * = Red
    *
    * scala> mkTrafficLightOrNull("green")
    * = Green
    *
    * scala> mkTrafficLightOrNull("yellow")
    * = Yellow
    *
    * scala> mkTrafficLightOrNull("bob")
    * = null
    **/
  def mkTrafficLightOrNull(str: String): TrafficLight =
    str match {
      case "red" => Red
      case "yellow" => Yellow
      case "green" => Green
      case _ => null
    }

  /**
    * Write a function that calls `mkTrafficLightOrNull` and then turn each `TrafficLight` into a readable `String`.
    *
    * scala> mkTrafficLightOrNullThenShow("red")
    * = "Traffic light is red"
    *
    * scala> mkTrafficLightOrNullThenShow("green")
    * = "Traffic light is green"
    *
    * scala> mkTrafficLightOrNullThenShow("yellow")
    * = "Traffic light is yellow"
    *
    * scala> mkTrafficLightOrNullThenShow("bob")
    * = "Traffic light is invalid"
    *
    * Hint: Use `mkTrafficLightOrNull` and pattern matching
    */
  def mkTrafficLightOrNullThenShow(str: String): String = mkTrafficLightOrNull(str) match {
    case level04.Red => "Traffic light is red"
    case level04.Yellow => "Traffic light is yellow"
    case level04.Green => "Traffic light is green"
    case _ => "Traffic light is invalid"
  }

  /**
    * Write a function that converts values from the real world into a `Person`.
    * If the `name` and `age` are invalid (as described below), return `null`.
    *
    * scala> mkPersonOrNull("Bob", 20)
    * = Person("Bob", 20)
    *
    * If `name` is blank:
    *
    * scala> mkPersonOrNull("", 20)
    * = null
    *
    * If `age` < 0:
    *
    * scala> mkPersonOrNull("Bob", -1)
    * = null
    **/
  def mkPersonOrNull(name: String, age: Int): Person = {
    if (name.isEmpty || age < 0) null
    else Person(name, age)
  }

  /**
    * scala> mkPersonOrNullThenChangeName("Bob", 20, "John")
    * = Person("John", 20)
    *
    * scala> mkPersonOrNullThenChangeName("Bob", -1, "John")
    * = null
    *
    * scala> mkPersonOrNullThenChangeName("Bob", 20, "")
    * = null
    *
    * Hint: Use `mkPersonOrNull` and `changeName` (already implemented below)
    **/
  def mkPersonOrNullThenChangeName(oldName: String, age: Int, newName: String): Person = {
    val p: Person = mkPersonOrNull(oldName, age)
    if (newName.isEmpty) null
    else if (p == null) null
    else changeName(newName, p)
  }

  def changeName(newName: String, person: Person): Person = person.copy(name = newName)

  /**
    * Thought exercise: Does the following function return a `null`?
    */
  def mean(nums: List[Int]): List[Int]  = null

}

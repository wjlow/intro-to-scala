package day1.level02

/**
  * Level 2 introduces data structures and operations that work on them.
  */
object ADT {

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
    *
    * Hint: Use string interpolation
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
    *
    * A sealed trait can only be extended in the same file that it is defined.
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
    * Now introduce a new type of `TrafficLight` called `Flashing` that has an additional parameter, `frequency: Int`
    *
    * What happens when you try to compile now?
    */

  /**
    * Bonus: How would you create an ADT that represents the commands from our Toy Robot code test?
    *
    * As a refresher, the possible commands are:
    *
    * PLACE X,Y,DIR (where X and Y are Ints and DIR is one of NORTH, SOUTH, EAST and WEST)
    * MOVE
    * LEFT
    * RIGHT
    * REPORT
    */

}

package fundamentals.level02

/**
  * Level 2 introduces data structures and operations that work on them.
  */
object TypesExercises {

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
    * scala> showPerson(person)
    * = "Bob is 50 years old"
    *
    * Hint: Use string interpolation
    **/
  def showPerson(person: Person): String = ???

  /**
    * scala> val person = Person("Bob", 50)
    * scala> changeName("Bobby", person)
    * = Person("Bobby", 50)
    *
    * `person` is immutable! This function returns a new instance of `Person` with the `name` changed.
    * Check out the corresponding test in `TypesExercisesTest` to understand why.
    *
    * Hint: Use the .copy method
    */
  def changeName(newName: String, person: Person): Person = ???

  /**
    * Let's look at another data type.
    *
    * `Wallet` is a tiny type on `Double` to represent the amount of money someone has.
    */

  case class Wallet(amount: Double)

  /**
    * Here is another example of working with immutable values.
    *
    * scala> val wallet = Wallet(100)
    * scala> purchase(80, wallet)
    * = Wallet(20)
    **/
  def purchase(cost: Double, wallet: Wallet): Wallet = ???

  /**
    * scala> showTrafficLightStr("red")
    * = "The traffic light is red"
    *
    * scala> showTrafficLightStr("yellow")
    * = "The traffic light is yellow"
    *
    * scala> showTrafficLightStr("green")
    * = "The traffic light is green"
    *
    * What if `trafficLight` is not "red", "yellow" or "green"?
    **/
  def showTrafficLightStr(trafficLight: String): String = ???

  /**
    * We have a new traffic light called Flashing, with a frequency, e.g. "flashing 20", "flashing 100"
    *
    * Extend `showTrafficLightStr` that you have just implemented above to support this new functionality.
    *
    * Use a test driven approach to implement this new functionality.
    *
    * scala> showTrafficLightStr("flashing 20")
    * = "The traffic light is flashing with a frequency of 20"
    *
    * scala> showTrafficLightStr("flashing 100")
    * = "The traffic light is flashing with a frequency of 100"
    **/

  /**
    * A "sum type" represents more than one possible value.
    *
    * You can read the following as a `TrafficLight` is either `Red` or `Yellow` or `Green`.
    *
    * A sealed trait can only be extended in the same file that it is defined.
    */
  sealed trait TrafficLight

  object TrafficLight {

    case object Red extends TrafficLight

    case object Yellow extends TrafficLight

    case object Green extends TrafficLight

  }

  /**
    * scala> showTrafficLight(Red)
    * = "The traffic light is red"
    *
    * scala> showTrafficLight(Yellow)
    * = "The traffic light is yellow"
    *
    * scala> showTrafficLight(Green)
    * = "The traffic light is green"
    *
    * It is impossible to get an invalid TrafficLight as input
    **/
  def showTrafficLight(trafficLight: TrafficLight): String = ???

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

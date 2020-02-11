package introcourse.level02

/**
  * These exercises introduce data types and also algebraic data types (ADTs). ADTs are a huge part of typed functional programming.
  * You will also be introduced to a very useful technique for working with ADTs, i.e. pattern matching.
  */
object TypesExercises {

  /**
    * *********************************
    * * Section 1 - People ************
    * *********************************
    */
  /**
    * A simple data type
    *
    * Here is an example of a `Person` type, which is a wrapper on `String` and `Int`.
    *
    * This is a "product type", i.e. a `Person` is a "product" of `String` and `Int`.
    *
    */
  case class Person(name: String, age: Int)

  /**
    * case class instances are immutable!
    *
    * scala> val person = Person(name = "John Kane", age = 35)
    *
    * scala> person.age = 25
    * <console>:18: error: reassignment to val
    * person.age = 25
    *
    * Notice as well how there is no need for using the `new` operator
    */
  val person = Person(name = "John Kane", age = 35)

  /**
    * scala> val person = Person("Bob", 50)
    * scala> showPerson1(person)
    * = "Bob is 50 years old"
    *
    * This uses a technique called pattern matching. You will see more of this later.
    *
    * You can read the following code as:
    * "If `person` matches the `Person` constructor, return the expression to the right hand side of the `=>`."
    *
    * The expression on the right hand side has access to the `name` and `age`
    * "extracted" out of `person`.
    **/
  def showPerson1(person: Person): String =
    person match {
      case Person(name, age) => s"${name} is ${age} years old"
    }

  /**
    * Same as `showPerson1`, but using string interpolation and accessors/getters only.
    *
    * Hint: Navigate the Person class' fields using the "." operator
    */
  def showPerson2(person: Person): String =
    s"${person.name} is ${person.age} years old"

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
  def changeName(newName: String, person: Person): Person = person.copy(name = newName)

  /**
    * Let's look at another data type.
    *
    * `Wallet` is a tiny type on `Double` to represent the amount of money someone has.
    */

  /**
    * *********************************
    * * Section 2 - Wallet ************
    * *********************************
    */

  case class Wallet(amount: Double)

  /**
    * scala> val wallet = Wallet(20.5)
    * scala> showWallet(wallet)
    * = "The wallet amount is 20.5"
    *
    * You can solve this like how you solved `showPerson1` or `showPerson2`.
    */
  def showWallet(wallet: Wallet): String = s"The wallet amount is ${wallet.amount}"

  /**
    * Here is another example of working with immutable values.
    *
    * scala> val wallet = Wallet(100)
    * scala> purchase(80, wallet)
    * = Wallet(20)
    *
    * Hint: You need to calculate the new amount first.
    **/
  def purchase(cost: Double, wallet: Wallet): Wallet = {
    wallet.copy(amount = wallet.amount - cost)
  }

  /**
    * *********************************************
    * * Section 3 - Test Driven Development *******
    * *********************************************
    */

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
    *
    * Go to `TypesExercisesTest.scala` and implement the test for this scenario: "should return a default on other inputs"
    *
    * return "The traffic light is invalid" for other inputs
    **/

  /**
    * **********************************************
    * * Section 4 - Traffic Light as String ********
    * **********************************************
    */

  /**
    * Implement the following showTrafficLightStr function to pass all your tests!
    */
  def showTrafficLightStr(trafficLight: String): String = trafficLight match {
    case "red" => "The traffic light is red"
    case "yellow" => "The traffic light is yellow"
    case "green" => "The traffic light is green"
    case "flashing" => "The traffic light is flashing"
    case _ => "The traffic light is invalid"
  }


  /**
    * ***************************************************************************
    * * Section 4.1 - Adding a new Traffic Light (using TDD) *****
    * ***************************************************************************
    */

  /**
    * We need to have a new traffic light called Flashing:
    *
    * 1. Implement the test for this scenario: "should show flashing"
    *    it should return "the traffic light is flashing"
    *
    * 2. Extend `showTrafficLightStr` that you have just implemented above to support this new flashing functionality.
    *
    *
    *
    * scala> showTrafficLightStr("flashing")
    * = "The traffic light is flashing"
    *
    **/

  /**
    * *********************************************
    * * Section 5 - Traffic Light as ADTs *********
    * *********************************************
    */

  /**
    * A "sum type" represents more than one possible value.
    *
    * You can read the following as a `TrafficLight` is either `Red` or `Yellow` or `Green`.
    *
    * A sealed trait can only be extended in the same file that it is defined.
    *
    * This technique helps you make invalid states/values irrepresentable in your programs
    */
  sealed trait TrafficLight

  case object Red extends TrafficLight

  case object Yellow extends TrafficLight

  case object Green extends TrafficLight

  case object Flashing extends TrafficLight

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
    *
    * Hint: Use pattern matching
    **/

  def showTrafficLight(trafficLight: TrafficLight): String = trafficLight match {
    case Red => "The traffic light is red"
    case Green => "The traffic light is green"
    case Yellow => "The traffic light is yellow"
    case Flashing => "The traffic light is flashing"
  }

  /**
    * *********************************************************
    * * Section 5.1 - Add a new Traffic Light *******
    * *********************************************************
    */

  /**
    * Now introduce a new type of `TrafficLight` called `Flashing`.
    *
    * 1. Add a new value Flashing to the `TrafficLight` Type
    *
    * 2. Try compile. What happens? How is this different than the previous String implementation?
    *
    * 3. Extend `showTrafficLight` to fix the compilation error.
    *
    * 4. Fill in the unit test for this new scenario: "showTrafficLight should show Flashing"
    *
    */
}

package fundamentals.level03

import fundamentals.level02.TypesExercises.Person
import fundamentals.level03.ExceptionExercises.personStringPairs

/**
  * These exercises show the alternative to throwing exceptions using the `Either` data type.
  * We will treat errors as values that our functions return.
  */
object Exceptions2EitherExercises {

  //ADT for representing errors as values
  sealed trait AppError

  case class EmptyName(message: String) extends AppError

  case class InvalidAgeValue(message: String) extends AppError

  case class InvalidAgeRange(message: String) extends AppError

  /**
    * In the ExceptionExcercises exercise we used Exceptions to handle validation and
    * flow control. We also came across some issues when using this type of solution
    * with Scala. Some other reasons why not to use Exceptions to model errors we can
    * recover from are:
    * 1. Creating a stacktrace for an Exception is expensive
    * 2. Throwing Exceptions violates Referential Transparency
    * 3. Exceptions can't be composed (combined together)
    * 4. Nested try/catch blocks may lead to madness
    *
    * We now look at how to handle validations with Eithers which return success and errors
    * as values. This means that Eithers are which are referentially transparent. Eithers
    * use a Left value to denote an error and a Right value to denote a success
    * (what is Right is correct, what is not Right is wrong).
    *
    * sealed trait Either[+E, +A]
    * case class Right[A](value: A) extends Either[?, A]
    * case class Left[E](error: E) extends Either[E, ?]
    */

  /**
    * Implement the function getName, so that it returns a Left with an EmptyName if the name supplied
    * is empty or a Right if the supplied name is not empty.
    *
    * scala> getName("Fred")
    * = Right("Fred")
    *
    * scala> getName("")
    * = Left(EmptyName(provided name is empty))
    *
    * scala> getName("   ")
    * = Left(EmptyName(provided name is empty))
    **/
  def getName(providedName: String): Either[AppError, String] = ???

  /**
    * Implement the function getAge that returns a Left with an InvalidAgeValue if the age provided can't
    * be converted to an Int or a Left with a InvalidAgeRange if the provided age is not between 1 and 120
    * and returns a Right with an Int age if the age is valid.
    *
    * scala> getAge("20")
    * = Right(20)
    *
    * scala> getAge("Fred")
    * = Left(InvalidAgeValue(provided age is invalid: Fred))
    *
    * scala> getAge("-1")
    * = Left(InvalidAgeRange(provided age should be between 1-120: -1))
    *
    * Hint: use the toInt method to convert a String to an Int. Be warned that it can throw a NumberFormatException.
    */
  def getAge(providedAge: String): Either[AppError, Int] = ???

  /**
    * Implement the function createPerson, so that it returns a Right with a Person
    * if the name and age are valid or returns a Left of AppError if either the name of age is invalid.
    *
    * scala> createPerson("Fred", "32")
    * = Right(Person(Fred,32))
    *
    * scala> createPerson("", "32")
    * = Left(EmptyName(provided name is empty))
    *
    * scala> createPerson("Fred", "ThirtyTwo")
    * = Left(InvalidAgeValue(provided age is invalid: ThirtyTwo))
    *
    * scala> createPerson("Fred", "150")
    * = Left(InvalidAgeRange(provided age should be between 1-120: 150))
    *
    * Hint: Use a for-comprehension to sequence the Eithers from getName and getAge
    */
  def createPerson(name: String, age: String): Either[AppError, Person] = ???

  /**
    * Implement the function createValidPeople that uses the personStringPairs List
    * to create a List of Person instances.
    *
    * scala> createValidPeople
    * = List(Person("Tokyo", 30), Person(" Berlin", 43))
    *
    * Hint: use the collect method on List
    *
    */
  def createValidPeople: List[Person] = ???

  /**
    * Implement the function collectErrors that collects all the errors
    * that occur while processing personStringPairs.
    *
    * scala> collectErrors
    * = List(InvalidAgeValue(provided age is invalid: 5o),
    * InvalidAgeRange(provided age should be between 1-120: 200),
    * InvalidAgeRange(provided age should be between 1-120: 0),
    * EmptyName(provided name is empty))
    *
    * Hint: use the collect method on List
    */
  def collectErrors: List[AppError] = ???
}

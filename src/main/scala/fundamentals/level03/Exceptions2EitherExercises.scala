package fundamentals.level03

import fundamentals.level02.TypesExercises.Person

/**
  * Complete ExceptionExcercises before this.
  */
object Exceptions2EitherExercises {

    sealed trait AppError
    case class EmptyName(message: String) extends AppError
    case class InvalidAgeValue(message: String) extends AppError
    case class InvalidAgeRange(message: String) extends AppError

  //test data of names and age pairs
  private val personStringPairs =
    List(("Tokyo", "30"),
         ("Moscow", "5o"),
         ("The Professor", "200"),
         ("Berlin", "43"),
         ("Arturo Roman", "0"),
         ("", "30"))

  /**
    * We now look at how to handle validations with Eithers which return success and errors
    * as values. This means that Eithers are which are referentially transparent unlike
    * throwing Exceptions.
    */

    /**
      * Implement the function getName, so that it returns a Left with an EmptyName if the name supplied
      * is empty or a Right if the supplied name is not empty.
      *
      * scala> getName("Fred")
      * = Right(Fred)
      *
      * scala> getName("")
      * = Left(EmptyName(provided name is empty))
      *
      * scala> getName("   ")
      * = Left(EmptyName(provided name is empty))
      */
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
      *        InvalidAgeValue(provided age should be between 1-120: 200),
      *        InvalidAgeValue(provided age should be between 1-120: 0),
      *        EmptyName(provided name is empty))
      *
      * Hint: use the collect method on List
      */
    def collectErrors: List[AppError] = ???

}

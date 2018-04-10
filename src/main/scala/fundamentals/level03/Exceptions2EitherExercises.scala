package fundamentals.level03

import fundamentals.level02.TypesExercises.Person

/**
  * Complete ExceptionExcercises before this.
  */
object Exceptions2EitherExercises {

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
      * Implement the function getName, so that it returns a Left if the name supplied
      * is empty or a Right if the supplied name is not empty.
      *
      * scala> getName("Fred")
      * = Left(provided name empty)
      *
      * scala> getName("")
      * = Right(Fred)
      *
      * scala> getName("   ")
      * = Left(provided name empty)
      */
    def getName(providedName: String): Either[String, String] = ???

    /**
      * Implement the function getAge that returns a Left if the age provided can't
      * be converted to an Int or the provided age is not between 1 and 120 and returns
      * a Right if the age is valid
      *
      * scala> getAge("Fred")
      * = Left(provided age is invalid: Fred)
      *
      * scala> getAge("20")
      * = Right(20)
      *
      * scala> getAge("-1")
      * = Left(provided age should be between 1-120: -1)
      *
      * Hint: use the toInt method to convert a String to an Int. Be warned that it can throw a NumberFormatException.
      */
    def getAge(providedAge: String): Either[String, Int] = ???

    /**
      * Implement the function createPerson, so that it returns a Right with a Person
      * or returns a Left if either the name of age is invalid.
      *
      * scala> createPerson("Fred", "32")
      * = Right(Person(Fred,32))
      *
      * scala> createPerson("", "32")
      * = Left(provided name is empty)
      *
      * scala> createPerson("Fred", "ThirtyTwo")
      * = Left(provided age is invalid: ThirtyTwo)
      *
      * scala> createPerson("Fred", "150")
      * = Left(provided age should be between 1-120: 150)
      *
      * Hint: Use a for-comprehension to sequence the Eithers from getName and getAge
      */
    def createPerson(name: String, age: String): Either[String, Person] = ???

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

}

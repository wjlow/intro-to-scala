package fundamentals.level02

import fundamentals.level02.TypesExercises.{Person, showPerson1, showPerson2}

/**
  * These exercises will teach you how to work with the `List` data structure in Scala in a declarative manner.
  * At the end of these exercises, you should have a good intuition on when to use `map`, `filter` or `fold`.
  */
object ListExercises {

  /**
    * A `List` in Scala is a linked list.
    *
    * sealed trait List[+A]
    * case class ::[A](head: A, tail: List[A]) extends List[A]
    * case object Nil extends List[Nothing]
    *
    * You can create a List using the `::` constructor as such:
    *
    * scala> ::(1, ::(2, ::(3, Nil)))
    * = List(1, 2, 3)
    *
    * scala> (1 :: (2 :: (3 :: Nil)))
    * = List(1, 2, 3)
    *
    * scala> 1 :: 2 :: 3 :: Nil
    * = List(1, 2, 3)
    *
    * Often times, the `List.apply` static method is more convenient:
    *
    * scala> List.apply(1, 2, 3)
    *
    * The `apply` method in any object is the default method, so you can leave it out when using it:
    *
    * scala> List(1, 2, 3)
    */

  /**
    * scala> prependToList(1, List(2, 3, 4))
    * = List(1,2,3,4)
    */
  def prependToList[A](x: A, xs: List[A]): List[A] = ???

  /**
    * scala> appendToList(1, List(2, 3, 4))
    * = List(2,3,4,1)
    *
    * Hint: Use the :+ operator
    */
  def appendToList[A](x: A, xs: List[A]): List[A] = ???

  /**
    * `List` has an `.isEmpty` method that you can call to know whether an instance is empty or not.
    *
    * For this exercise, let's build a version of `isEmpty` called `isEmptyList` without using `.isEmpty` (that would be cheating!).
    *
    * scala> isEmptyList(Nil)
    * = true
    *
    * scala> isEmptyList(List(1, 2, 3))
    * = false
    *
    * Hint: Use pattern matching. You can pattern match on `List` using its two constructors `::` and `Nil` as such:
    *
    * ```
    * list match {
    *   case head :: tail => // do something for non-empty list
    *   case Nil => // do something for empty list
    * }
    * ```
    */
  def isEmptyList[A](xs: List[A]): Boolean = ???

  /**
    * scala> showListSize(List(1, 2, 3))
    * = "This is a list of size 3"
    *
    * scala> showListSize(List("ABC"))
    * = "This is a list of size 1"
    *
    * scala> showListSize(Nil)
    * = "This is an empty list"
    *
    * Hint: Use pattern matching and string interpolation
    */
  def showListSize[A](xs: List[A]): String = ???

  /**
    * scala> val people = List(Person("Tokyo", 30), Person("Berlin", 43), Person("Moscow", 50), Person("The Professor", 80))
    * scala> sortByAgeDescending(people)
    * = List(Person("The Professor", 80), Person("Moscow", 50), Person("Berlin", 43), Person("Tokyo", 30))
    *
    * Hint: Use `sortBy` method on `List`.
    * `sortBy` takes a function from `Person` to the field that you want to sort by.
    * The field must have some sort of `Ordering` defined.
    * All common types, e.g. `Int`, `Long`, `Float`, `Double`, `String` have an `Ordering` defined.
    */
  def sortByAgeDescending(unsortedPeople: List[Person]): List[Person] =
    ???

  /**
    * Mapping a function over a List
    *
    * This is typically what you want if the initial List and the resulting List
    * are of the same size.
    *
    * scala> addNumToEach(10, List(1, 2, 3))
    * = List(11, 12, 13)
    *
    * Hint: Use .map
    **/
  def addNumToEach(num: Int, nums: List[Int]): List[Int] = ???

  /**
    * Filter a List
    *
    * This is typically what you want if the size of the resulting List is <= that of the initial.
    *
    * scala> filterEven(List(1, 2, 3, 4))
    * = List(2, 4)
    *
    * Hint: Use .filter
    */
  def filterEven(nums: List[Int]): List[Int] = ???

  /**
    * Folds
    *
    * A fold is an operation over a data structure to yield a summary value.
    *
    * The next 3 exercises are to practise folding.
    *
    * Examples: sum, product, min, max
    *
    * Hint: Use .foldLeft
    */

  /**
    * scala> product(List(2, 5, 3))
    * = 30
    *
    * https://en.wikipedia.org/wiki/Empty_product
    * scala> product(Nil)
    * = 1
    *
    * Hint: Use pattern matching and .foldLeft
    */
  def product(nums: List[Int]): Int = ???

  /**
    * scala> min(List(4, 6, 1))
    * = 1
    *
    * scala> min(Nil)
    * = Int.MinValue
    *
    * Hint: Use pattern matching and .foldLeft
    **/
  def min(nums: List[Int]): Int = ???

  /**
    * Return the person in the List that is the youngest. If there are more than one person with the youngest age,
    * return the first one.
    *
    * scala> val persons = List(Person("Bob", 22), Person("Sally", 21), Person("Jimmy", 21))
    * scala> youngestPerson(persons)
    * = Person("Sally", 21)
    *
    * scala> youngestPerson(Nil)
    * = Person("Nobody", 0)
    *
    * Hint: Use pattern matching and .foldLeft
    */
  def youngestPerson(persons: List[Person]): Person = ???

  /**
    * Typically in a data processing job, you would only want to log every
    * 100th or 1000th iteration so you do not clog up the logs.
    *
    * scala> val persons = List(Person("Person1", 21), Person("Person2", 21), Person("Person3", 21), Person("Person4", 21))
    * scala> showEveryNthPerson(2, persons)
    * = List("Person2 is 21 years old", "Person4 is 21 years old")
    *
    * Hint: Use .zipWithIndex and showPerson1/2
    */
  def showEveryNthPerson(n: Int, persons: List[Person]): List[String] = ???

  /**
    * Given a list of `Person`s ordered by age in ascending order. Return all of those that are under 18.
    *
    * scala> val persons = List(Person("Bob", 16), Person("Jimmy", 17), Person("Sally", 18))
    * = List(Person("Bob", 16), Person("Jimmy", 17))
    *
    * Hint: Use .takeWhile
    */
  def retrieveMinors(orderedPersons: List[Person]): List[Person] = ???

}

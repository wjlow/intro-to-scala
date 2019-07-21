package introcourse.level03

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
    * scala> `::`(1, `::`(2, `::`(3, Nil))) // backticks to use :: in prefix position
    * = List(1, 2, 3)
    *
    * scala> (1 :: (2 :: (3 :: Nil))) // no need for backticks to use :: in infix position
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
    *
    * Hint: Refer the construction of list
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
    * case head :: tail => // do something for non-empty list
    * case Nil => // do something for empty list
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
    * Hint: Use pattern matching, string interpolation and length
    */
  def showListSize[A](xs: List[A]): String = ???

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
    * Hint: Use .filter and '%' for mod operator
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
    * Hint: Use .foldLeft
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
  def min(nums: List[Int]): Int =
    nums match {
      case Nil => ???
      case head :: tail => ???
    }

  private[level03] val peopleList =
    List(Person("Matt Murdock", 30),
      Person("Karen Page", 27),
      Person("Franklin 'Foggy' Nelson", 31),
      Person("Claire Temple", 32),
      Person("Wilson Fisk", 42),
      Person("Elektra Natchios", 27)
    )

  /**
    * Return the person in the List that is the youngest. If there are more than one person with the youngest age,
    * return the first one.
    *
    * scala> youngestPerson(peopleList)
    * = Person("Karen Page", 27)
    *
    * scala> youngestPerson(Nil)
    * = Person("Nobody", 0)
    *
    * Hint: Use pattern matching and .foldLeft
    */
  def youngestPerson(persons: List[Person]): Person = ???

  /**
    * Return a list of pairs of a Person and their position in the `peopleList`.
    * The position should be a 1-based index.
    *
    * You can pattern match on pairs inside a lambda function, e.g.
    *
    * ```
    * List(("abc", 1), ("def", 2)).map {
    *   case (str, num) => // do something with `str` and `num`
    * }
    * ```
    *
    * Otherwise, you'll need to use `._1` and `._2` methods to access the fields in the pair, e.g.
    *
    * ```
    * List(("abc", 1), ("def", 2)).filter(pair => // do something with `pair._1` and `pair._2`)
    * ```
    *
    * Hint: Use `zipWithIndex`
    */
  def personWithIndex(people: List[Person]): List[(Person, Int)] = ???

  /**
    * Log every nth person from the `peopleList` given an index `n`.
    *
    * scala> showEveryNthPerson(2, peopleList)
    * = List("Karen Page is 27 years old", "Claire Temple is 32 years old", "Elektra Natchios is 27 years old")
    *
    * Validation rules:
    *
    * If `n` is zero or less then return the full List
    * If `n` is greater than the length of the list then return an empty List
    *
    * Hint: Use `personWithIndex`, `filter` and `showPerson`.
    *
    */
  def showEveryNthPerson(n: Int, persons: List[Person]): List[String] = ???

  private[level03] def showPerson(person: Person): String =
    person match {
      case Person(a, b) => s"$a is $b years old"
    }

  /**
    * Bonus exercises!
    */

  /**
    * Rewrite this function that uses a mutable variable and for-loop in an immutable fashion
    */
  @SuppressWarnings(Array("org.wartremover.warts.Var"))
  def getNames(persons: List[Person]): List[String] = {
    var names: List[String] = Nil
    for (person <- persons) {
      names = names :+ person.name
    }
    names
  }

  /**
    * Rewrite this function that uses a mutable variable and for-loop in an immutable fashion
    *
    * Return people aged >= 18
    */
  @SuppressWarnings(Array("org.wartremover.warts.Var"))
  def getAdults(persons: List[Person]): List[Person] = {
    var adults: List[Person] = Nil
    for (person <- persons) {
      if (person.age >= 18)
        adults = adults :+ person
    }
    adults
  }


  /**
    * Rewrite this function that uses mutable variables and for-loop in an immutable fashion
    *
    * Don't use `.reverse` because that's cheating ;)
    */
  @SuppressWarnings(Array("org.wartremover.warts.Var"))
  def reverseList[A](xs: List[A]): List[A] = {
    var result: List[A] = Nil
    for (x <- xs) {
      result = x :: result
    }
    result
  }

  /**
    * Pack consecutive duplicates of list elements into sublists.
    * If a list contains repeated elements they should be placed in separate sublists.
    *
    * Given: val l1 = List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e")
    * sublists(l1) == List(List("a", "a", "a", "a"), List("b"), List("c", "c"), List("a", "a"), List("d"), List("e", "e", "e", "e"))
    */
  def sublists[A](xs: List[A]): List[List[A]] = ???
}

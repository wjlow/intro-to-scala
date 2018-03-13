package day1.level03

import day1.level02.ADT.{Person, TrafficLight}

object OptionExercises {

  /**
    * Option data type
    *
    * sealed trait Option[A]
    * case class Some[A](a: A) extends Option[A]
    * case object None extends Option[Nothing]
    */

  /**
    * scala> safeMean(List(1, 2, 10))
    * = Some(4.333333333333333)
    *
    * scala> safeMean(Nil)
    * = None
    **/
  def safeMean(nums: List[Int]): Option[Double] = ???

  /**
    * Safe constructors
    *
    * Allows us to convert input from the real world (e.g. files, HTTP request, etc.) into ADTs
    */

  /**
    * scala> mkTrafficLight("red")
    * = Some(Red)
    *
    * scala> mkTrafficLight("bob")
    * = None
    **/
  def mkTrafficLight(str: String): Option[TrafficLight] = ???

  /**
    * scala> mkTrafficLightThenPrint("red")
    * = "Traffic light is red"
    *
    * scala> mkTrafficLightThenPrint("bob")
    * = "Traffic light is invalid"
    *
    * Hint: Use `mkTrafficLight` and pattern matching
    */
  def mkTrafficLightThenPrint(str: String): String = ???

  /**
    * scala> mkPerson("Bob", 20)
    * = Some(Person("Bob", 20))
    *
    * scala> mkPerson("", 20)
    * = None
    *
    * scala> mkPerson("Bob", -1)
    * = None
    **/
  def mkPerson(name: String, age: Int): Option[Person] = ???

  /**
    * scala> mkPersonThenChangeName("Bob", 20, "John")
    * = Some(Person("John", 20))
    *
    * scala> mkPersonThenChangeName("Bob", -1, "John")
    * = None
    *
    * For simplicity, let's allow changing to an empty name, like:
    *
    * scala> mkPersonThenChangeName("Bob", 20, "")
    * = Some(Person("", 20))
    **/
  def mkPersonThenChangeName(oldName: String, age: Int, newName: String): Option[Person] = ???

  /**
    * Working with Option types
    */

  type JobId = Int

  type HumanId = Int

  case class Job(name: String, description: String)

  case class Human(name: String, optJobId: Option[JobId])

  val jobsDatabase: Map[JobId, Job] = Map(
    1 -> Job("Teacher", "Expert in their field"),
    2 -> Job("Engineer", "Build things for people")
  )

  val humansDatabase: Map[HumanId, Human] = Map(
    1 -> Human("Sally", None),
    2 -> Human("Bobby", Some(1))
  )

  /**
    * scala> findHumanById(1)
    * = Some(Human(Sally, None))
    *
    * scala> findHumanById(100)
    * = None
    **/
  def findHumanById(humanId: HumanId): Option[Human] = ???

  /**
    * scala> findJobById(1)
    * = Some(Job("Teacher"))
    *
    * scala> findJobById(100")
    * = None
    **/
  def findJobById(jobId: JobId): Option[Job] = ???

  /**
    * scala> findJobDescriptionGivenJobId1(1)
    * = Some("Expert in their field")
    *
    * scala> findJobDescriptionGivenJobId1(100)
    * = None
    *
    * Hint: Use pattern matching
    */
  def findJobDescriptionGivenJobId1(jobId: JobId): Option[String] = ???

  /**
    * Same as above, but use .map instead
    */
  def findJobDescriptionGivenJobId2(jobId: JobId): Option[String] = ???

  /**
    * scala> findJobDescriptionGivenJobIdOrElse1(1)
    * = "Expert in their field"
    *
    * scala> findJobDescriptionGivenJobIdOrElse1(100)
    * = "Job with id 100 does not exist"
    *
    * Hint: Use pattern matching
    */
  def findJobDescriptionGivenJobIdOrElse1(jobId: JobId): String = ???

  /**
    * Same as above, but use .map then .getOrElse
    */
  def findJobDescriptionGivenJobIdOrElse2(jobId: JobId): String = ???

  /**
    * scala> findJobIdByHumanId(1)
    * = None
    *
    * scala> findJobIdByHumanId(2)
    * = Some(1)
    *
    * Hint: Use .map
    */
  def findJobIdByHumanId(humanId: HumanId): Option[JobId] = ???

  /**
    * scala> findJobByHumanId(2)
    * = Some(Job("Teacher", "Expert in their field"))
    *
    * Hint: Use findJobIdByHumanId
    */
  def findJobByHumanId(humanId: HumanId): Option[Job] = ???

}

package level03

import level02.ADT.{Person, TrafficLight}

object ErrorHandling {

  /**
    * scala> mean(List(1, 2, 10))
    * = 4.333333333333333
    *
    * What should the following return?
    *
    * scala> mean(Nil)
    * = ???
    **/
  def mean(nums: List[Int]): Double = ???

  /**
    * Option data type
    *
    * sealed trait Option[A]
    * case class Some[A](a: A) extends Option[A]
    * case object None extends Option[Nothing]
    */

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
    * scala> mkPersonAndThenChangeName("Bob", 20, "John")
    * = Some(Person("John", 20))
    *
    * scala> mkPersonAndThenChangeName("Bob", -1, "John")
    * = None
    *
    * For simplicity, let's allow changing to an empty name, like:
    *
    * scala> mkPersonAndThenChangeName("Bob", 20, "")
    * = Some(Person("", 20))
    */
  def mkPersonAndThenChangeName(oldName: String, age: Int, newName: String): Option[Person] = ???

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
    */
  def findHumanById(humanId: HumanId): Option[Human] = ???

  /**
    * scala> findJobById(1)
    * = Some(Job("Teacher"))
    * 
    * scala> findJobById(100")
    * = None
    */
  def findJobById(jobId: JobId): Option[Job] = ???

  /**
    * scala> findJobDescriptionGivenJobId(1)
    * = Some("Expert in their field")
    *
    * scala> findJobDescriptionGivenJobId(100)
    * = None
    */
  def findJobDescriptionGivenJobId(jobId: JobId): Option[String] = ???

  /**
    * scala> findJobDescriptionGivenJobIdOrElse(1)
    * = "Expert in their field"
    *
    * scala> findJobDescriptionGivenJobIdOrElse(100)
    * = "Job with id 100 does not exist"
    */
  def findJobDescriptionGivenJobIdOrElse(jobId: JobId): String = ???

  def findJobByHumanId(humanId: HumanId): Option[Job] = ???

}

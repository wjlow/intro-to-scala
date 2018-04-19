package fundamentals.level03

object OptionExercises2 {

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
    2 -> Human("Jenny", Some(1)),
    3 -> Human("Timmy", Some(1024)) // jobId doesn't exist in jobsDatabase
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
    * = Some(Job("Teacher", "Expert in their field"))
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
    *
    * What's the type that you get after using .map? What's different between that and what the function return type is?
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

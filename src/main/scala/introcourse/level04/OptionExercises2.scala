package introcourse.level04

/**
  * These exercises simulate the "real-world" problem of retrieving records from a data store. You will learn to use `Option`s to represent
  * values that may or may not exist in the data store and also techniques to work with the `Option` type.
  */
object OptionExercises2 {

  /**
    * The keyword `type` creates a type alias.
    * This means we have created an alias for the type `Int` called `JobId`.
    * It serves as a light-weight way to give your types more meaning and have better documentation in code.
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
    * = Some(Human("Sally", None))
    *
    * scala> findHumanById(100)
    * = None
    *
    * Hint: Use `get` method on `humansDatabase` Map
    **/
  def findHumanById(humanId: HumanId): Option[Human] = {
    humansDatabase.get(humanId)
  }

  /**
    * scala> findJobById(1)
    * = Some(Job("Teacher", "Expert in their field"))
    *
    * scala> findJobById(100)
    * = None
    *
    * Hint: Use `get` method on `jobsDatabase` Map
    **/
  def findJobById(jobId: JobId): Option[Job] = jobsDatabase.get(jobId)

  /**
    * scala> findJobDescriptionGivenJobId1(1)
    * = Some("Expert in their field")
    *
    * scala> findJobDescriptionGivenJobId1(100)
    * = None
    *
    * Hint: Use `findJobById` and then pattern match
    */
  def findJobDescriptionGivenJobId1(jobId: JobId): Option[String] = {
    val maybeJob: Option[Job] = findJobById(jobId)
    maybeJob match {
      case Some(value) => Some(value.description)
      case None => None
    }
  }

  /**
    * Same as above, but use .map instead
    *
    * If you see a `case None => None` in a pattern matching block,
    * you can always refactor it:
    *
    * ```
    * optSomething match {
    *   case Some(a) => Some(s"Got some $a")
    *   case None => None
    * }
    * ```
    *
    * becomes
    *
    * ```
    * optSomething.map(a => s"Got some $a")
    * ```
    */
  def findJobDescriptionGivenJobId2(jobId: JobId): Option[String] = {
    findJobById(jobId).map(_.description)
  }

  /**
    * scala> findJobDescriptionGivenJobIdOrElse1(1)
    * = "Expert in their field"
    *
    * scala> findJobDescriptionGivenJobIdOrElse1(100)
    * = "Job with id 100 does not exist"
    *
    * Hint: Use `findJobDescriptionGivenJobId1` then pattern match
    */
  def findJobDescriptionGivenJobIdOrElse1(jobId: JobId): String = {
    findJobDescriptionGivenJobId1(jobId) match {
      case Some(description) => description
      case None => s"Job with id $jobId does not exist"
    }
  }

  /**
    * Same as above, but use `findJobDescriptionGivenJobId1` then `getOrElse`
    */
  def findJobDescriptionGivenJobIdOrElse2(jobId: JobId): String = {
    findJobDescriptionGivenJobId1(jobId).getOrElse(s"Job with id $jobId does not exist")
  }

  /**
    * scala> findJobIdByHumanId(1)
    * = None
    *
    * scala> findJobIdByHumanId(2)
    * = Some(1)
    *
    * Hint: Use `findHumanById` and try `map`, `flatten`
    *
    * What's the type that you get after using `map`? What's different between that and the function's return type?
    */
  def findJobIdByHumanId(humanId: HumanId): Option[JobId] = {
    val jobId: Option[JobId] = findHumanById(humanId).map(human => human.optJobId).flatten

    findHumanById(humanId).flatMap(human => human.optJobId)
  }

  /**
    * scala> findJobByHumanId(2)
    * = Some(Job("Teacher", "Expert in their field"))
    *
    * Hint: Use `findJobIdByHumanId` and `findJobById`
    */
  def findJobByHumanId(humanId: HumanId): Option[Job] = {
    val maybeJobId: Option[JobId] = findJobIdByHumanId(humanId)

    val maybeJob: Option[Job] = maybeJobId match {
      case Some(jobId) => findJobById(jobId)
      case None => None
    }

    findJobIdByHumanId(humanId).flatMap(findJobById)
  }

  /**
    * Find the name of the `Job` that this `humanId` has
    *
    * scala> findJobNameByHumanId(2)
    * = Some("Teacher")
    *
    * scala> findJobNameByHumanId(1)
    * = None
    *
    * Hint: Use `findJobByHumanId`
    */
  def findJobNameByHumanId(humanId: HumanId): Option[String] = {
    val maybeJob = findJobByHumanId(humanId)

    maybeJob.map(job => job.name)
  }

}

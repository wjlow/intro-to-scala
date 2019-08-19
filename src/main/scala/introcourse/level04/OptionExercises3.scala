package introcourse.level04

import introcourse.level04.OptionExercises2.{HumanId, Job, JobId, findHumanById, findJobById}

/**
  * These exercises mirror the ones from `OptionExercises2.scala`,
  * they are for the purpose of teaching for-comprehension, which is very useful for working with `Option`.
  */
object OptionExercises3 {

  /**
    * scala> findJobIdByHumanIdUsingFor(1)
    * = None
    *
    * scala> findJobIdByHumanIdUsingFor(2)
    * = Some(1)
    **/
  def findJobIdByHumanIdUsingFor(humanId: HumanId): Option[JobId] =
    for {
      human <- findHumanById(humanId)
      jobId <- human.optJobId
    } yield jobId

  // Same as above
  def findJobIdByHumanId(humanId: HumanId): Option[JobId] = {
    findHumanById(humanId).flatMap(human => human.optJobId.map(jobId => jobId))
  }

  /**
    * scala> findJobByHumanIdUsingFor(2)
    * = Some(Job("Teacher", "Expert in their field"))
    *
    * Hint: Use findJobIdByHumanIdUsingFor
    */
  def findJobByHumanIdUsingFor(humanId: HumanId): Option[Job] =
    for {
      jobId <- findJobIdByHumanId(humanId)
      job <- findJobById(jobId)
    } yield job

  // Same as above
  def findJobByHumanId(humanId: HumanId): Option[Job] = {
    findJobIdByHumanId(humanId)
      .flatMap(jobId => findJobById(jobId)
        .map(job => job))
  }

  /**
    * scala> findJobNameByHumanIdUsingFor(2)
    * = Some("Teacher")
    *
    * scala> findJobNameByHumanIdUsingFor(1)
    * = None
    *
    * Hint: Use `findJobByHumanIdUsingFor` and for comprehension
    */
  def findJobNameByHumanIdUsingFor(humanId: HumanId): Option[String] =
    for {
      human <- findHumanById(humanId)
      jobId <- human.optJobId
      job <- findJobById(jobId)
    } yield job.name

  // Same as above
  def findJobNameByHumanId(humanId: HumanId): Option[String] = {
    findJobByHumanId(humanId).map(job => job.name)
  }

}

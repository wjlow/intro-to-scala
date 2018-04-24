package fundamentals.level03

import fundamentals.level03.OptionExercises2.{HumanId, Job, JobId, findHumanById, findJobById}

/**
  * These exercises mirror the ones from `OptionExercises2.scala`,
  * they are for the purpose of teaching for-comprehension
  */
object OptionExercises3 {

  /**
    * scala> findJobIdByHumanId(1)
    * = None
    *
    * scala> findJobIdByHumanId(2)
    * = Some(1)
    */
  def findJobIdByHumanId(humanId: HumanId): Option[JobId] =
    for {
      human <- ??? // Option[Human]
      jobId <- ??? // Option[JobId]
    } yield jobId

  /**
    * scala> findJobByHumanId(2)
    * = Some(Job("Teacher", "Expert in their field"))
    *
    * Hint: Use findJobIdByHumanId
    */
  def findJobByHumanId(humanId: HumanId): Option[Job] =
    for {
      jobId <- ??? // Option[JobId]
      job <- ???   // Option[Job]
    } yield job

}

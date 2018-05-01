package fundamentals.level04

import scala.util.Try

/**
  * The exercises here are adapted from: http://www.cis.upenn.edu/~cis194/spring13/hw/02-ADTs.pdf
  *
  * Let's finish off this course by building a CLI program!
  * We will build a program to parse a log file (containing Info, Warn and Error messagea) and print out errors over a severity level.
  *
  * Finish each exercise and we will head over to `Main.scala` to hook it all up with the CLI.
  */
object LogParser {

  /**
    * Here is how a log file may look.
    *
    * The `|` at the start of each line can be ignored. This is how Scala represents a multi-line String.
    */
  val logFile: String =
    """|I,147,mice in the air
       |W,149,could've been bad
       |E,5,158,some strange error
       |E,2,148,istereadea""".stripMargin

  /**
    * Let's define an ADT to represent all possible log messages.
    *
    * Hint: Add `sealed` in front of the `trait`s below to make sure you can only extend them from within this file.
    */

  /**
    * Start with all the possible log levels
    * - Info
    * - Warning
    * - Error with (severity: Int)
    */
  sealed trait LogLevel

  case object Info extends LogLevel

  case object Warning extends LogLevel

  case class Error(severity: Int) extends LogLevel

  /**
    * Now create an ADT for `LogMessage`, where `LogMessage` can be one of two possibilities:
    * - KnownLog with (logLevel, timestamp, message)
    * - UnknownLog with (message)
    */
  type Timestamp = Int

  sealed trait LogMessage

  case class KnownLog(logLevel: LogLevel, timestamp: Timestamp, message: String) extends LogMessage

  case class UnknownLog(message: String) extends LogMessage

  /**
    * Once you have defined your data types:
    * 1. Remove `import Types._` from [LogParserTest.scala](src/test/scala/fundamentals/level04/LogParserTest.scala).
    * 2. Comment out the contents of `Types.scala`
    */

  /**
    * Define a function to parse an individual log message.
    *
    * scala> parseLog("I,147,mice in the air")
    * = KnownLog(Info, 147, "mice in the air")
    *
    * scala> parseLog("E,2,148,weird")
    * = KnownLog(Error(2), 148, "weird")
    *
    * scala> parseLog("X blblbaaaaa")
    * = UnknownLog("X blblbaaaaa")
    **/
  def parseLog(str: String): LogMessage = {
    val optLogMessage = str.split(",") match {
      case Array("I", tstamp, msg) => parseIntOpt(tstamp).map(validTstamp => KnownLog(Info, validTstamp, msg))
      case Array("W", tstamp, msg) => parseIntOpt(tstamp).map(validTstamp => KnownLog(Warning, validTstamp, msg))
      case Array("E", sev, tstamp, msg) =>
        for {
          validSeverity <- parseIntOpt(sev)
          validTstamp <- parseIntOpt(tstamp)
        } yield KnownLog(Error(validSeverity), validTstamp, msg)
      case _ => None
    }
    optLogMessage.getOrElse(UnknownLog(str))
  }

  private def parseIntOpt(str: String): Option[Int] = Try(str.toInt).toOption

  /**
    * scala> parseLogFile("I,147,mice in the air\nX blblbaaaaa")
    * = List(KnownLog(Info, 147, "mice in the air"), UnknownLog("X blblbaaaaa"))
    *
    * Hint: Use `parseLog`
    */
  def parseLogFile(fileContent: String): List[LogMessage] =
    fileContent.split("\n").filter(_.nonEmpty).toList.map(parseLog)

  /**
    * Define a function that returns only logs that are unknown
    *
    * scala> getUnknowns(List(KnownLog(Info, 147, "mice in the air"), UnknownLog("blblbaaaaa")))
    * = List(UnknownLog("blblbaaaaa"))
    **/
  def getUnknowns(logs: List[LogMessage]): List[LogMessage] =
    logs.filter {
      case _: UnknownLog => true
      case _ => false
    }

  /**
    * Define a function that returns the error log with the most recent (highest) timestamp.
    *
    * What if we cannot find any error logs in the input?
    */
  def findLatestError(logs: List[LogMessage]): Option[LogMessage] =
    logs.collect {
      case k@KnownLog(Error(_), _, _) => k
    }.sortBy(log => -log.timestamp).headOption

  /**
    * Write a function to convert a `LogMessage` to a readable `String`.
    *
    * scala> showLogMessage(KnownLog(Info, 147, "mice in the air"))
    * = "Info (147) mice in the air"
    *
    * scala> showLogMessage(KnownLog(Error(2), 147, "weird"))
    * = "Error 2 (147) weird"
    *
    * scala> showLogMessage(UnknownLog("message"))
    * = "Unknown log: message"
    *
    * Hint: Pattern match and use string interpolation
    **/
  def showLogMessage(log: LogMessage): String =
    log match {
      case KnownLog(Info, tstamp, msg) => s"Info ($tstamp) $msg"
      case KnownLog(Warning, tstamp, msg) => s"Warning ($tstamp) $msg"
      case KnownLog(Error(severity), tstamp, msg) => s"Error $severity ($tstamp) $msg"
      case UnknownLog(msg) => s"Unknown log: $msg"
    }

  /**
    * Use `showLogMessage` on error logs with severity greater than the given `severity`.
    *
    * scala> showErrorsOverSeverity(logFile, 2)
    * = List("Error 5 (158) some strange error")
    *
    * Hint: Use `parseLogFile` and `showLogMessage`
    **/
  def showErrorsOverSeverity(fileContent: String, severity: Int): List[String] =
    parseLogFile(fileContent).filter {
      case KnownLog(Error(sev), _, _) => if (sev > severity) true else false
      case _ => false
    }.map(showLogMessage)

  /**
    * Now head over to `Main.scala` in the same package to complete the rest of the program.
    */

}

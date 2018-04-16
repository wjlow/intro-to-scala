package fundamentals.level04

/**
  * The exercises here are adapted from: http://www.cis.upenn.edu/~cis194/spring13/hw/02-ADTs.pdf
  */
object LogParser {

  /**
    * Let's try and build a program to understand some logs! Here is how a log file may look.
    */
  val logFile: String =
    """|I,147,mice in the air
       |W,149,could've been bad
       |E,5,158,some strange error
       |E,2,148,istereadea""".stripMargin

  /**
    * Let's define an ADT to represent all possible log messages.
    */

  /**
    * Start with all the possible log levels
    * - Info
    * - Warning
    * - Error with (severity: Int)
    */
  trait LogLevel

  /**
    * Now create an ADT for `LogMessage`, where `LogMessage` can be one of two possibilities:
    * - KnownLog with (logLevel, timestamp, message)
    * - UnknownLog with (message)
    */
  type Timestamp = Int

  trait LogMessage

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
  def parseLog(str: String): LogMessage = ???

  /**
    * scala> parseLogFile("I,147,mice in the air\nX blblbaaaaa")
    * = List(KnownLog(Info, 147, "mice in the air"), UnknownLog("X blblbaaaaa"))
    *
    * Hint: Use `parseLog`
    */
  def parseLogFile(fileContent: String): List[LogMessage] = ???

  /**
    * Define a function that returns only logs that are unknown
    *
    * scala> getUnknowns(List(KnownLog(Info, 147, "mice in the air"), UnknownLog("blblbaaaaa")))
    * = List(UnknownLog("blblbaaaaa"))
    **/
  def getUnknowns(logs: List[LogMessage]): List[LogMessage] = ???

  /**
    * Define a function that returns the error log with the most recent (highest) timestamp.
    *
    * What if we cannot find any error logs in the input?
    */
  def findLatestError(logs: List[LogMessage]): Option[LogMessage] = ???

  /**
    * Write a function to convert a `LogMessage` to a readable `String`.
    *
    * scala> showLogMessage(KnownLog(Info, 147, "mice in the air"))
    * = "Info (147) mice in the air"
    *
    * scala> showLogMessage(KnownLog(Error(2), 147, "weird"))
    * = "Error 2 (147) weird"
    *
    * Hint: Pattern match and use string interpolation
    **/
  def showLogMessage(log: LogMessage): String = ???

  /**
    * Use `showError` on error logs with severity greater than the given `severity`.
    *
    * scala> showErrorsOverSeverity(logFile, 2)
    * = List(KnownLog(Error(5), 158, "some strange error"))
    *
    * Hint: Use `parseLogFile` and `showError`
    **/
  def showErrorsOverSeverity(fileContent: String, severity: Int): List[String] = ???

}

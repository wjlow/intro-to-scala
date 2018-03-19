package fundamentals.level04

/**
  * The exercises here are adapted from: http://www.cis.upenn.edu/~cis194/spring13/hw/02-ADTs.pdf
  */
object LogParser extends App {

  /**
    * Let's try and build a program to understand some logs! Here is how a log file may look.
    */
  val logFile: String =
    """|I,147,mice in the air
       |W,could've been bad
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
  sealed trait LogLevel

  /**
    * Now create an ADT for `LogMessage`, where `LogMessage` can be one of two possibilities:
    * - KnownLog with (logLevel, timestamp, message)
    * - UnknownLog with (message)
    */
  type Timestamp = Int

  sealed trait LogMessage

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
    * Hint: Use `parseLog`
    */
  def parseLogFile(logFile: String): List[LogMessage] = ???

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
    * scala> showError(KnownLog(Info, 147, "mice in the air"))
    * = "mice in the air"
    **/
  def showError(log: LogMessage): String = ???

  /**
    * Use `showError` on error logs with severity greater than the given `severity`.
    *
    * scala> showErrorsOverSeverity(logFile, 2)
    * = List(KnownLog(Error(5), 158, "some strange error"))
    *
    * Hint: Use `parseLogFile` and `showError`
    **/
  def showErrorsOverSeverity(logFile: String, severity: Int): List[String] = ???

  /**
    * Note that at no point have we printed anything out to the user.
    * By pushing side-effects like printing to stdout to the very end of our program,
    * we are able to unit test the majority of our program.
    *
    * Now, using `showErrorsOverSeverity`, let's print out the results to stdout.
    */
  def printErrorsOverSeverity(logFile: String, severity: Int): Unit = ???

}

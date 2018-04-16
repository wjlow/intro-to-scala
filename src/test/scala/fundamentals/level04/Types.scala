package fundamentals.level04

import LogParser.{LogMessage, LogLevel, Timestamp}

object Types {

  case object Info extends LogLevel

  case object Warning extends LogLevel

  case class Error(severity: Int) extends LogLevel

  case class KnownLog(logLevel: LogLevel, timestamp: Timestamp, message: String) extends LogMessage

  case class UnknownLog(message: String) extends LogMessage

}

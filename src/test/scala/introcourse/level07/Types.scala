//package introcourse.level07
//
//import introcourse.level07.LogParser._
//
///**
//  * This file exists just to get the type-safe tests in `LogParserTests.scala` to compile.
//  * Once the ADTs are defined in `LogParser.scala`, remove `import Types._` from `LogParserTests.scala`.
//  */
//object Types {
//
//  case object Info extends LogLevel
//
//  case object Warning extends LogLevel
//
//  case class Error(severity: Int) extends LogLevel
//
//  case class KnownLog(logLevel: LogLevel, timestamp: Timestamp, message: String) extends LogMessage
//
//  case class UnknownLog(message: String) extends LogMessage
//
//}

package introcourse.level07

/**
  * This file exists just to get the type-safe tests in `LogParserTests.scala` to compile.
  * Once the ADTs are defined in `LogParser.scala`, remove `import Types.*` from `LogParserTests.scala`.
  */
object Types {
  private def undefinedInLogParser: Nothing =
    throw new RuntimeException("Please remove `import Types.*` from `LogParserTests.scala`")

  def Info: Nothing = undefinedInLogParser
  def Warning: Nothing = undefinedInLogParser
  def Error(args: Any*): Nothing = undefinedInLogParser

  def KnownLog(args: Any*): Nothing = undefinedInLogParser
  def UnknownLog(args: Any*): Nothing = undefinedInLogParser
}

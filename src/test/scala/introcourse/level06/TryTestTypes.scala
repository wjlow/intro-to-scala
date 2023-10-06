package introcourse.level06

/**
  * This file exists just to get the type-safe tests in `TryExercisesTest.scala` to compile.
  * Once you have defined the `Employee` type in `TryExercises.scala`, remove `import TryTestTypes.*`
  * from `TryExercisesTest.scala`.
  */
object TryTestTypes {
  private def undefinedInTry: Nothing =
    throw new RuntimeException("Please remove `import TryTestTypes.*` from `TryExercisesTest.scala`")

  def Employee(args: Any*): Nothing = undefinedInTry
}

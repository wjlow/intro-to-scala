package introcourse.level06

/**
  * This file exists just to get the type-safe tests in `TryExercisesTest.scala` to compile.
  * Once you have defined the `Employee` type in `TryExercises.scala`, remove `import TryTestTypes._`
  * from `TryExercisesTest.scala`.
  */
object TryTestTypes {

  case class Employee(name: String, age: Int, hasDirectReports: Boolean)

}

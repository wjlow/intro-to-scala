lazy val root = (project in file("."))
  .settings(projectSettings: _*)
  .settings(libraryDependencies ++= dependencies)
  .settings(scalacOptions ++= options)
  .settings(testFrameworks += TestFrameworks.ScalaTest)

lazy val projectSettings = Seq(
  name := "intro-to-scala",
  version := "0.1",
  scalaVersion := "3.3.0"
)

lazy val dependencies = Seq(
  "org.scalatest" %% "scalatest" % "3.2.12" % Test
)

lazy val options = Seq(
  "-Werror"
)

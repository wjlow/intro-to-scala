name := "intro-to-scala"

version := "0.1"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % Test

scalaVersion := "2.12.6"

scalacOptions ++= Seq(
  "-Xfatal-warnings"
)

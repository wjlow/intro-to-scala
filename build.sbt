name := "intro-to-scala"

version := "0.1"

val http4sVersion = "0.18.1"

libraryDependencies ++= Seq(
  "org.http4s" %% "http4s-circe" % http4sVersion,
  // Optional for auto-derivation of JSON codecs
  "io.circe" %% "circe-generic" % "0.9.1",
  // Optional for string interpolation to JSON model
  "io.circe" %% "circe-literal" % "0.9.1",
  "org.http4s" %% "http4s-dsl" % http4sVersion,
  "org.http4s" %% "http4s-blaze-server" % http4sVersion,
  "org.http4s" %% "http4s-blaze-client" % http4sVersion
)

scalaVersion := "2.12.4"
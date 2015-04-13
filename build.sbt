name := "Scalamata"

version := "1.0"

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.11" % "2.0" % "test",
  "org.scalacheck" %% "scalacheck" % "1.12.2" % "test",
  "org.processing" % "core" % "2.2.1",
  "junit" % "junit" % "4.10" % "test",
  "org.spire-math" %% "spire" % "0.9.0"
)
    
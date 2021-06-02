name := "SwiftVis2"

version := "1.0"

scalaVersion := "2.12.14"
//scalaVersion := "2.13.6" // May 2021: swiftvis2 works for scala 2.12

scalacOptions ++= Seq(
  "-deprecation",
  "-encoding", "UTF-8", // UTF-8, ISO-8859-1
  "-feature",
  "-unchecked"
)

val sparkVersion = "3.1.1"

libraryDependencies ++= Seq(
  "com.novocode" % "junit-interface" % "0.11" % "test",
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion,
  "org.apache.spark" %% "spark-mllib" % sparkVersion,
  "org.apache.spark" %% "spark-graphx" % sparkVersion
)
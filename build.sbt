name := "SwiftVis2"

version := "0.1"

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
  "org.apache.spark" %% "spark-graphx" % sparkVersion,
  //  "org.scalafx" %% "scalafx" % "16.0.0-R24" // nope
  //  "org.scalafx" %% "scalafx" % "16.0.0-R23" // nope
  //  "org.scalafx" %% "scalafx" % "16.0.0-R22" // nope
  //  "org.scalafx" %% "scalafx" % "15.0.1-R21" // nope
  //  "org.scalafx" %% "scalafx" % "15.0.1-R20" // nope
  //  "org.scalafx" %% "scalafx" % "14-R19" // yep: from sbt, but NOT from ide

  "org.scalafx" %% "scalafx" % "12.0.2-R18" // yep: from sbt and from ide

  //  "org.scalafx" %% "scalafx" % "12.0.1-R17" // yep: from sbt and from ide
  //  "org.scalafx" %% "scalafx" % "11-R16" // yep: from sbt and from ide
  //  "org.scalafx" %% "scalafx" % "10.0.2-R15" // nope
  //  "org.scalafx" %% "scalafx" % "8.0.192-R14" // yep: from sbt and from ide
  //  "org.scalafx" %% "scalafx" % "8.0.181-R13" // nope
  //  "org.scalafx" %% "scalafx" % "8.0.144-R12" // nope
  //  "org.scalafx" %% "scalafx" % "8.0.102-R11" // nope
)

// Fork a new JVM for 'run' and 'test:run', to avoid JavaFX double initialization problems
fork := true

// Determine OS version of JavaFX binaries
lazy val osName = System.getProperty("os.name") match {
  case n if n.startsWith("Linux") => "linux"
  case n if n.startsWith("Mac") => "mac"
  case n if n.startsWith("Windows") => "win"
  case _ => throw new Exception("Unknown platform!")
}

// Add JavaFX dependencies
lazy val javaFXModules = Seq("base", "controls", "fxml", "graphics", "media", "swing", "web")
libraryDependencies ++= javaFXModules.map(m =>
  "org.openjfx" % s"javafx-$m" % "15.0.1" classifier osName
)

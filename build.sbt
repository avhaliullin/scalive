organization := "tv.cntt"

name         := "scalive"

version      := "1.1-SNAPSHOT"

autoScalaLibrary := false

javacOptions ++= Seq("-Xlint:deprecation")

//Ensure scalive's scala files can be run on Java 1.6
scalacOptions += "-target:jvm-1.6"

//Ensure scalive's java files can be run on Java 1.6
javacOptions ++= Seq("-source", "1.6", "-target", "1.6")

// Add tools.jar to classpath
// https://blogs.oracle.com/CoreJavaTechTips/entry/the_attach_api
unmanagedJars in Compile := (file(System.getProperty("java.home")) / ".." / "lib" * "tools.jar").classpath

libraryDependencies += "org.scala-lang" % "scala-compiler" % "2.10.3"

packageOptions in (Compile, packageBin) += Package.ManifestAttributes(
  "Main-Class"  -> "scalive.AgentLoader",
  "Agent-Class" -> "scalive.Agent"
)
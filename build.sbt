name := "welt"

version := "0.1"

scalaVersion := "2.13.1"

libraryDependencies ++= Seq(
  // http client
  "org.dispatchhttp" %% "dispatch-core" % "1.1.2",
  
  // json
  "org.json4s" %% "json4s-native" % "3.6.7",
  "org.json4s" %% "json4s-jackson" % "3.6.7"
)
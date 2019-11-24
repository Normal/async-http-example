
name := "http-async"

version := "0.1"

scalaVersion := "2.13.1"

libraryDependencies ++= Seq(
  // http client
  "org.dispatchhttp" %% "dispatch-core" % "1.1.2",

  // json
  "org.json4s" %% "json4s-native" % "3.6.7",
  "org.json4s" %% "json4s-jackson" % "3.6.7",
  
  // logger
  "ch.qos.logback" % "logback-classic" % "1.1.3" % Runtime
)

assemblyJarName in assembly := s"${name.value}.jar"
assemblyMergeStrategy in assembly := {
  case PathList("META-INF",  xs @ _*) =>
    xs map {_.toLowerCase} match {
      case "services" :: _ :: Nil =>
        MergeStrategy.concat
      case _ => MergeStrategy.discard
    }
  case "application.conf" =>
    MergeStrategy.concat
  case _ =>
    MergeStrategy.first
}
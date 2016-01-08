name := "StudentData"

version := "1.0-SNAPSHOT"



libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  "mysql" % "mysql-connector-java" % "5.1.26")

play.Project.playJavaSettings

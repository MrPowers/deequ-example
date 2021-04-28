name := "deequ-example"

version := "0.0.1"

scalaVersion := "2.12.12"

libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.0.1" % "provided"

// https://mvnrepository.com/artifact/com.amazon.deequ/deequ
libraryDependencies += "com.amazon.deequ" % "deequ" % "1.2.2-spark-3.0"

libraryDependencies += "com.github.mrpowers" %% "spark-daria" % "0.38.2"
libraryDependencies += "com.github.mrpowers" %% "spark-fast-tests" % "0.21.3" % "test"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

fork in Test := true
javaOptions ++= Seq("-Xms512M", "-Xmx2048M", "-XX:MaxPermSize=2048M", "-XX:+CMSClassUnloadingEnabled")
testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-oD")

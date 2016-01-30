name := "scalautil"

version := "1.1"

scalaVersion := "2.10.4"

ivyScala := ivyScala.value map { _.copy(overrideScalaVersion = true) }

resolvers += "Kunyan Repo" at "http://222.73.34.92:8081/nexus/content/groups/public/"

libraryDependencies += "org.scala-lang" % "scala-compiler" % "2.10.4"

libraryDependencies ++= Seq(
  "org.apache.hadoop" % "hadoop-client" % "2.7.1",
  "org.apache.hadoop" % "hadoop-hdfs" % "2.7.1"
)

libraryDependencies += "org.scalactic" %% "scalactic" % "2.2.5"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.5" % "test"

assemblyMergeStrategy in assembly := {
  case PathList("javax", "servlet", xs @ _*) => MergeStrategy.last
  case PathList("javax", "activation", xs @ _*) => MergeStrategy.last
  case PathList("javax", "el", xs @ _*) => MergeStrategy.last
  case PathList("org", "apache", xs @ _*) => MergeStrategy.last
  case PathList("com", "google", xs @ _*) => MergeStrategy.last
  case PathList("com", "esotericsoftware", xs @ _*) => MergeStrategy.last
  case PathList("com", "codahale", xs @ _*) => MergeStrategy.last
  case PathList("com", "yammer", xs @ _*) => MergeStrategy.last
  case "about.html" => MergeStrategy.rename
  case "META-INF/ECLIPSEF.RSA" => MergeStrategy.last
  case "META-INF/mailcap" => MergeStrategy.last
  case "META-INF/mimetypes.default" => MergeStrategy.last
  case "plugin.properties" => MergeStrategy.last
  case "log4j.properties" => MergeStrategy.last
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}

test in assembly := {}
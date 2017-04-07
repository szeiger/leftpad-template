scalaVersion := "2.12.1"

libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test"

// groupId
organization := "com.novocode"

// forms artifactId, together with scalaBinaryVersion
name := "leftpad"

version := "0.1-SNAPSHOT"

pomIncludeRepository := { _ => false }

licenses += ("Apache-2.0", url("https://www.apache.org/licenses/LICENSE-2.0.html"))

homepage := Some(url("http://github.com/szeiger/leftpad/"))

scmInfo := Some(
  ScmInfo(
    url("https://github.com/szeiger/leftpad"),
    "scm:git@github.com:szeiger/leftpad.git"
  )
)

developers := List(
  Developer(
    id    = "szeiger",
    name  = "Stefan Zeiger",
    email = "szeiger@novocode.com",
    url   = url("http://szeiger.de")
  )
)

publishMavenStyle := true

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

publishArtifact in Test := false

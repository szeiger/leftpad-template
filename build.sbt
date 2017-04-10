publishTo in ThisBuild := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

inThisBuild(Seq(
  organization := "com.novocode",
  version := "0.1-SNAPSHOT",
  pomIncludeRepository := { _ => false },
  licenses += ("Apache-2.0", url("https://www.apache.org/licenses/LICENSE-2.0.html")),
  homepage := Some(url("http://github.com/szeiger/leftpad/")),
  scmInfo := Some(ScmInfo(url("https://github.com/szeiger/leftpad"), "scm:git@github.com:szeiger/leftpad.git")),
  developers := List(Developer("szeiger", "Stefan Zeiger", "szeiger@novocode.com", url("http://szeiger.de"))),
  publishMavenStyle := true,
  publishArtifact in Test := false
))

lazy val root = project.in(file("."))
  .aggregate(core, plugin)
  .enablePlugins(CrossPerProjectPlugin)

lazy val core = project.in(file("core")).settings(
  crossScalaVersions := Seq("2.10.6", "2.12.1"),
  scalaVersion := crossScalaVersions.value.head,
  name := "leftpad",
  libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test"
)

lazy val plugin = project.in(file("plugin")).settings(
  name := "sbt-leftpad",
  sbtPlugin := true,
  scalaVersion := "2.10.6"
).dependsOn(core)

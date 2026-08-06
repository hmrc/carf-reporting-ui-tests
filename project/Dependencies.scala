import sbt.*

object Dependencies {

  val test: Seq[ModuleID] = Seq(
    "uk.gov.hmrc"         %% "ui-test-runner"  % "0.55.0" % Test,
    "ch.qos.logback"       % "logback-classic" % "1.6.1"  % Test,
    "com.vladsch.flexmark" % "flexmark-all"    % "0.64.8" % Test,
    "org.scalatest"       %% "scalatest"       % "3.2.20" % Test,
    "uk.gov.hmrc"         %% "domain-play-30"  % "12.1.0" % Test
  )

}

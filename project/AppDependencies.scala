import play.core.PlayVersion.current
import play.sbt.PlayImport._
import sbt.Keys.libraryDependencies
import sbt._

object AppDependencies {

  val compile = Seq(

    "uk.gov.hmrc"             %% "bootstrap-play-26"        % "1.1.0",
    "uk.gov.hmrc"             %% "play-frontend-govuk"      % "0.19.0-play-26",
    "uk.gov.hmrc"             %% "play-nunjucks"            % "0.15.0-play-26",
    "org.webjars.npm"         %  "govuk-frontend"           % "3.3.0",
    "org.webjars.npm"         %  "hmrc-frontend"            % "1.3.0"
  )

  val test = Seq(
    "uk.gov.hmrc"             %% "bootstrap-play-26"        % "1.1.0" % Test classifier "tests",
    "org.scalatest"           %% "scalatest"                % "3.0.8"                 % "test",
    "com.typesafe.play"       %% "play-test"                % current                 % "test",
    "org.pegdown"             %  "pegdown"                  % "1.6.0"                 % "test, it",
    "org.scalatestplus.play"  %% "scalatestplus-play"       % "3.1.2"                 % "test, it"
  )

}

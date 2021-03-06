// *****************************************************************************
// Projects
// *****************************************************************************

lazy val `pugna-player` =
  project
    .in(file("."))
    .enablePlugins(AutomateHeaderPlugin, JavaAppPackaging)
    .settings(settings)
    .settings(
      libraryDependencies ++= Seq(
        library.akkaHttp,
        library.akkaHttpCirce,
        library.akkaLog4j,
        library.akkaStream,
        library.akkaTyped,
        library.circeGeneric,
        library.disruptor,
        library.log4jApiScala,
        library.log4jCore,
        library.pureConfig,
        library.akkaHttpTestkit  % Test,
        library.akkaTestkit      % Test,
        library.akkaTypedTestkit % Test,
        library.scalaCheck       % Test,
        library.scalaTest        % Test
      )
    )

// *****************************************************************************
// Library dependencies
// *****************************************************************************

lazy val library =
  new {
    object Version {
      val akka                     = "2.5.8"
      val akkaHttp                 = "10.0.11"
      val akkaHttpJson             = "1.18.1"
      val akkaLog4j                = "1.6.0"
      val akkaManagement           = "0.6"
      val akkaPersistenceCassandra = "0.59"
      val circe                    = "0.8.0"
      val disruptor                = "3.3.7"
      val log4j                    = "2.10.0"
      val log4jApiScala            = "11.0"
      val pureConfig               = "0.8.0"
      val scalaCheck               = "1.13.5"
      val scalaTest                = "3.0.4"
    }
    val akkaClusterSharding      = "com.typesafe.akka"        %% "akka-cluster-sharding"        % Version.akka
    val akkaClusterTools         = "com.typesafe.akka"        %% "akka-cluster-tools"           % Version.akka
    val akkaDistributedData      = "com.typesafe.akka"        %% "akka-distributed-data"        % Version.akka
    val akkaHttp                 = "com.typesafe.akka"        %% "akka-http"                    % Version.akkaHttp
    val akkaHttpTestkit          = "com.typesafe.akka"        %% "akka-http-testkit"            % Version.akkaHttp
    val akkaHttpCirce            = "de.heikoseeberger"        %% "akka-http-circe"              % Version.akkaHttpJson
    val akkaLog4j                = "de.heikoseeberger"        %% "akka-log4j"                   % Version.akkaLog4j
    val akkaStream               = "com.typesafe.akka"        %% "akka-stream"                  % Version.akka
    val akkaTestkit              = "com.typesafe.akka"        %% "akka-testkit"                 % Version.akka
    val akkaTyped                = "com.typesafe.akka"        %% "akka-typed"                   % Version.akka
    val akkaTypedTestkit         = "com.typesafe.akka"        %% "akka-typed-testkit"           % Version.akka
    val circeGeneric             = "io.circe"                 %% "circe-generic"                % Version.circe
    val disruptor                = "com.lmax"                 %  "disruptor"                    % Version.disruptor
    val log4jApiScala            = "org.apache.logging.log4j" %% "log4j-api-scala"              % Version.log4jApiScala
    val log4jCore                = "org.apache.logging.log4j" %  "log4j-core"                   % Version.log4j
    val log4jSlf4jImpl           = "org.apache.logging.log4j" %  "log4j-slf4j-impl"             % Version.log4j
    val pureConfig               = "com.github.pureconfig"    %% "pureconfig"                   % Version.pureConfig
    val scalaCheck               = "org.scalacheck"           %% "scalacheck"                   % Version.scalaCheck
    val scalaTest                = "org.scalatest"            %% "scalatest"                    % Version.scalaTest
  }

// *****************************************************************************
// Settings
// *****************************************************************************

lazy val settings =
  commonSettings ++
    scalafmtSettings ++
    commandAliases

lazy val commonSettings =
  Seq(
     scalaVersion := "2.12.4",
    organization := "org.craftycoder",
    organizationName := "Carlos Peña",
    startYear := Some(2017),
    licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0")),
    scalacOptions ++= Seq(
      "-unchecked",
      "-deprecation",
      "-language:_",
      "-target:jvm-1.8",
      "-encoding", "UTF-8"
    ),
    unmanagedSourceDirectories.in(Compile) := Seq(scalaSource.in(Compile).value),
    unmanagedSourceDirectories.in(Test) := Seq(scalaSource.in(Test).value),
    publishArtifact.in(Compile, packageDoc) := false,
    publishArtifact.in(Compile, packageSrc) := false
  )


lazy val scalafmtSettings =
  Seq(
    scalafmtOnCompile := true,
    scalafmtOnCompile.in(Sbt) := false,
    scalafmtVersion := "1.3.0"
  )


lazy val commandAliases =
  addCommandAlias(
    "r1",
    """|reStart
       |---
       |-Dpugna.player.api.port=8081
       |-Dpugna.player.api.name=carlos""".stripMargin
  ) ++
  addCommandAlias(
    "r2",
    """|reStart
       |---
       |-Dpugna.player.api.port=8082
       |-Dpugna.player.api.name=darko""".stripMargin
  )++
    addCommandAlias(
      "r3",
      """|reStart
         |---
         |-Dpugna.player.api.port=8083
         |-Dpugna.player.api.name=andy""".stripMargin
    )++
    addCommandAlias(
      "r4",
      """|reStart
         |---
         |-Dpugna.player.api.port=8084
         |-Dpugna.player.api.name=michael""".stripMargin
    )

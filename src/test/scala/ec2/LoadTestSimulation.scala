package ec2

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

class LoadTestSimulation extends Simulation {

  var baseUrl = "http://localhost:8080/"

  val httpProtocol: HttpProtocolBuilder = http
    .baseUrl(baseUrl)
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")

  val loadTestScenario: ScenarioBuilder = scenario("EC-2 load test")
  .exec(http("Request - 1: Factorial calculation for argument 2")
    .get("/calculate?argument=" + 2))

    .exec(http("Request - 1: Factorial calculation for argument 4")
      .get("/calculate?argument=" + 4))

    .exec(http("Request - 1: Factorial calculation for argument 8")
      .get("/calculate?argument=" + 8))

    .exec(http("Request - 1: Factorial calculation for argument 16")
      .get("/calculate?argument=" + 16))

    .exec(http("Request - 1: Factorial calculation for argument 32")
      .get("/calculate?argument=" + 32))

    .exec(http("Request - 1: Factorial calculation for argument 64")
      .get("/calculate?argument=" + 64))

    .exec(http("Request - 1: Factorial calculation for argument 156")
      .get("/calculate?argument=" + 128))

    .exec(http("Request - 1: Factorial calculation for argument 128")
      .get("/calculate?argument=" + 256))

    .exec(http("Request - 1: Factorial calculation for argument 512")
      .get("/calculate?argument=" + 512))

    .exec(http("Request - 1: Factorial calculation for argument 1024")
      .get("/calculate?argument=" + 1024))

    .exec(http("Request - 1: Factorial calculation for argument 2048")
      .get("/calculate?argument=" + 2048))


  setUp(loadTestScenario.inject(atOnceUsers(1)).protocols(httpProtocol))
}

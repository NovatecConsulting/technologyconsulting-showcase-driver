import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class Supplier extends Simulation {

	val httpProtocol = http
		.baseUrl("http://supplierdomain-tc-showcase-prod.trafficmanager.net")
		.inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*"""), WhiteList())
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en,de-DE;q=0.9,de;q=0.8,en-US;q=0.7")
		.upgradeInsecureRequestsHeader("1")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.116 Safari/537.36")

	val scn = scenario("Supplier")
		.exec(http("Supplier_0")
			.get("/supplierdomain/supplier/")
			.basicAuth("testuser","pwd"))

	setUp(
	     scn.inject(
    nothingFor(5 seconds),
    atOnceUsers(130),
    rampUsers(350000) during (200 second)
  ).protocols(httpProtocol)
).maxDuration(10 minute)


}

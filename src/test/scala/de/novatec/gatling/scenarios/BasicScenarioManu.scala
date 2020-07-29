package de.novatec.gatling.scenarios

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._

object BasicScenarioManu extends Simulation {


  val basicScenarioManu: ScenarioBuilder = scenario("BasicSimulationManu")
    .exec(http("request_1_Manu")
    .get("/manufacturedomain/assembly/ids")
		.basicAuth("testuser","pwd"))
    .pause(5)
    //TODO add more complex get scenarios!
}

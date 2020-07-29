package de.novatec.gatling.scenarios

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._

object BasicScenarioOrder extends Simulation {


  val basicScenarioOrder: ScenarioBuilder = scenario("BasicSimulationOrder")
    .exec(http("request_1_Order")
    .get("/orderdomain/item/count/")
		.basicAuth("testuser","pwd"))
    .pause(5)
    //TODO add more complex get scenarios!
}

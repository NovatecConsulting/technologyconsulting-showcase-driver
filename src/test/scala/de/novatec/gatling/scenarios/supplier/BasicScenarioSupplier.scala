package de.novatec.gatling.scenarios

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._

object BasicScenarioSupplier extends Simulation {

  val basicScenarioSupplier: ScenarioBuilder = scenario("BasicSimulationSupplier")
    .exec(http("request_1")
    .get("/supplierdomain/supplier/")
		.basicAuth("testuser","pwd"))
    .pause(5)
    //TODO add more complex get scenarios!
}

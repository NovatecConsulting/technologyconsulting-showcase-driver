package de.novatec.gatling.scenarios

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._

object PutScenarioOrder extends Simulation {


  val putScenarioOrder: ScenarioBuilder = scenario("PutSimulationOrder")
    .exec(http("PUT_order_1")
    .put("/orderdomain/customer/sell_inventory/1/2/1")
    .header("Content-Type", "application/json")
		.basicAuth("admin","adminpwd"))
    .pause(5)
  
}

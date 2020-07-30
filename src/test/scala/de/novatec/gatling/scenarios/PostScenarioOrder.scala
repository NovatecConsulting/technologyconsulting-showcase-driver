package de.novatec.gatling.scenarios

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._

object PostScenarioOrder extends Simulation {


  val postScenarioOrder: ScenarioBuilder = scenario("PostSimulationOrder")
    .exec(http("POST_order_create-customer-1")
    .post("/orderdomain/customer/")
    .header("Content-Type", "application/json")
    .body(RawFileBody("bodies/order/customer.json"))
		.basicAuth("admin","adminpwd"))
    .pause(5)
    //TODO Add some logic
}

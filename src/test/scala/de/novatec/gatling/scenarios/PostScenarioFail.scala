package de.novatec.gatling.scenarios

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._

object PostScenarioFail extends Simulation {

  val postScenarioFail: ScenarioBuilder = scenario("PostSimulationFail")
    .exec(http("POST_purchase_component-2")
    .post("/supplierdomain/supplier/purchase")
    .header("Content-Type", "application/json")
    .body(RawFileBody("bodies/supplier/component_demands_non_existing_supplier.json"))
		.basicAuth("admin","adminpwd"))
    .pause(5)
    .exec(http("POST_deliver_component-1")
    .post("/supplierdomain/supplier/process_delivery/1")
    .header("Content-Type", "application/json")
		.basicAuth("admin","adminpwd"))

}

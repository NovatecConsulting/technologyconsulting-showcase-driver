package de.novatec.gatling.scenarios

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._

object PostScenario extends Simulation {

  val postScenario: ScenarioBuilder = scenario("PostSimulation")
    .exec(http("POST_supplier_1")
    .post("/supplierdomain/supplier/")
    .header("Content-Type", "application/json")
    .body(RawFileBody("bodies/supplier_1.json"))
		.basicAuth("admin","adminpwd"))
    .pause(5)
    .exec(http("POST_supplier_2")
    .post("/supplierdomain/supplier/")
    .header("Content-Type", "application/json")
    .body(RawFileBody("bodies/supplier_2.json"))
		.basicAuth("admin","adminpwd"))
    .pause(5)
    .exec(http("POST_supplier_3")
    .post("/supplierdomain/supplier/")
    .header("Content-Type", "application/json")
    .body(RawFileBody("bodies/supplier_3.json"))
		.basicAuth("admin","adminpwd"))
    .pause(5)
    .exec(http("POST_purchase_component-1")
    .post("/supplierdomain/supplier/purchase")
    .header("Content-Type", "application/json")
    .body(RawFileBody("bodies/component_demands.json"))
		.basicAuth("admin","adminpwd"))
    .pause(5)
  
}

package de.novatec.gatling.scenarios

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._

object PostScenario extends Simulation {

  val postScenario: ScenarioBuilder = scenario("PostSimulation")
    .exec(http("POSTrequest_1")
    .post("/supplierdomain/supplier/")
    .header("Content-Type", "application/json")
    .body(RawFileBody("bodies/supplier_1.json"))
		.basicAuth("admin","adminpwd"))
    .pause(5)
    .exec(http("POSTrequest_2")
    .post("/supplierdomain/supplier/")
    .header("Content-Type", "application/json")
    .body(RawFileBody("bodies/supplier_2.json"))
		.basicAuth("admin","adminpwd"))
    .pause(5)
    .exec(http("POSTrequest_3")
    .post("/supplierdomain/supplier/")
    .header("Content-Type", "application/json")
    .body(RawFileBody("bodies/supplier_3.json"))
		.basicAuth("admin","adminpwd"))
}

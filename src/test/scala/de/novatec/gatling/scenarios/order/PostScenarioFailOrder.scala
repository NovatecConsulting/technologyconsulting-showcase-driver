package de.novatec.gatling.scenarios

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._

object PostScenarioFailOrder extends Simulation {

  val postScenarioFailOrder: ScenarioBuilder = scenario("PostSimulationFailOrder")
   .exec(http("POST_order_Fail_1")
    .post("/orderdomain/order/100")
    .header("Content-Type", "application/json")
    .body(RawFileBody("bodies/order/items_quantity_pairs.json"))
		.basicAuth("admin","adminpwd"))
    .pause(5)
    .exec(http("POST_order_Fail_2") //I don't know why this test is failing! It should work! 
    .post("/orderdomain/order/1")
    .header("Content-Type", "application/json")
    .body(RawFileBody("bodies/order/items_quantity_pairs.json"))
		.basicAuth("admin","adminpwd"))
    .pause(5)
    .exec(http("POST_order_inventory_Fail_1")
    .post("/orderdomain/customer/add_inventory/1")
    .header("Content-Type", "application/json")
		.basicAuth("testuser","pwd"))
    .pause(5)

}


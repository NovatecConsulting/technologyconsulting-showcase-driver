package de.novatec.gatling.scenarios

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._

object PostScenarioSupplier extends Simulation {

  val postScenarioSupplier: ScenarioBuilder = scenario("PostSimulationSupplier")
    .exec(http("POST_supplier_1")
    .post("/supplierdomain/supplier/")
    .header("Content-Type", "application/json")
    .body(RawFileBody("bodies/supplier/supplier_1.json"))
    .check(bodyString.saveAs( "RESPONSE_DATA" )) 
    .check(jsonPath("$.id").saveAs("postItemId"))
		.basicAuth("admin","adminpwd"))
    .pause(5)
    .exec( session => {
      println("Response Body for supplier creation is:")
      println(session("RESPONSE_DATA").as[String])
      session 
    })
    .pause(5)
    .exec(http("DELETE_order-item-1")
    .delete("/supplierdomain/supplier/${postItemId}")
    .header("Content-Type", "application/json")
    .basicAuth("admin","adminpwd"))
    .pause(5)
    
    .exec(http("POST_purchase_component-1")
    .post("/supplierdomain/supplier/purchase")
    .header("Content-Type", "application/json")
    .body(RawFileBody("bodies/supplier/component_demands.json"))
		.basicAuth("admin","adminpwd"))
    .pause(5)
  
}

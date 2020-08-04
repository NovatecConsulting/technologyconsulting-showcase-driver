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
    .check(bodyString.saveAs( "RESPONSE_DATA" )) 
    .check(jsonPath("$.id").saveAs("postId"))
    .basicAuth("admin","adminpwd"))
    .pause(5)
    .exec( session => {
      println("Response Body for customer creation is:")
      println(session("RESPONSE_DATA").as[String])
      session 
    })
    .pause(5)
    .exec(http("DELETE_order_delete-customer-1")
    .delete("/orderdomain/customer/${postId}")
    .header("Content-Type", "application/json")
    .basicAuth("admin","adminpwd"))
    .pause(5)
    //TODO loop instead only one call! 
    /* es wäre gut gleich mehrere calls zu sammeln und am ende dann durch ein call array den delete zu machen*/
    .exec(http("POST_order_create-item-1")
    .post("/orderdomain/item/")
    .header("Content-Type", "application/json")
    .body(RawFileBody("bodies/order/item_1.json"))
    .check(bodyString.saveAs( "RESPONSE_DATA_ITEM" )) 
    .check(jsonPath("$.id").saveAs("postItemId"))
    .basicAuth("admin","adminpwd"))
    .pause(5)
    .exec( session => {
      println("Response Body for item creation is:")
      println(session("RESPONSE_DATA_ITEM").as[String])
      session 
    })
    .pause(5)
    .exec(http("DELETE_order-item-1")
    .delete("/orderdomain/item/${postItemId}")
    .header("Content-Type", "application/json")
    .basicAuth("admin","adminpwd"))
    .pause(5)
}


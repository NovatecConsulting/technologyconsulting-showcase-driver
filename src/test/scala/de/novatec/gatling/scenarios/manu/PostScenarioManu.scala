package de.novatec.gatling.scenarios

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._

object PostScenarioManu extends Simulation {


  val postScenarioManu: ScenarioBuilder = scenario("PostSimulationManu")
    .exec(http("POST_manu_Workorder")
    .post("/manufacturedomain/workorder")
    .header("Content-Type", "application/json")
    .body(RawFileBody("bodies/manu/workorder.json"))
		.basicAuth("admin","adminpwd"))
    .pause(5)
    .exec(http("POST_manu_DoDelivery")
    .post("/manufacturedomain/component/deliver")
    .header("Content-Type", "application/json")
    .body(RawFileBody("bodies/manu/component_demands.json"))
		.basicAuth("admin","adminpwd"))
    .pause(5)
    .exec(http("POST_manu_CancelWorkorder_1")
    .post("/manufacturedomain/workorder")
    .header("Content-Type", "application/json")
    .body(RawFileBody("bodies/manu/workorder.json"))
		.basicAuth("admin","adminpwd"))
    .pause(5)
    .exec(http("POST_manu_CancelWorkorder_2")
    .delete("/manufacturedomain/workorder/2")
    .header("Content-Type", "application/json")
    .body(RawFileBody("bodies/manu/workorder.json"))
		.basicAuth("admin","adminpwd"))
    .pause(5)
    
    /*
        DONE # create/schedule workorder
        curl -u admin:adminpwd --header "Content-Type: application/json" --request POST --data @data/workorder.json http://$HOST:$PORT/manufacturedomain/workorder

        DONE # do a delivery
        curl -u admin:adminpwd --header "Content-Type: application/json" --request POST --data @data/component_demands.json http://$HOST:$PORT/manufacturedomain/component/deliver
        
        DONE # cancel a workorder
        curl -u admin:adminpwd --header "Content-Type: application/json" --request POST --data @data/workorder.json http://$HOST:$PORT/manufacturedomain/workorder
        curl -u admin:adminpwd --header "Content-Type: application/json" --request DELETE --data @data/workorder.json http://$HOST:$PORT/manufacturedomain/workorder/2
    */
}

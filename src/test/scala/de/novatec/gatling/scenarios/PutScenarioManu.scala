package de.novatec.gatling.scenarios

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._

object PutScenarioManu extends Simulation {


  val putScenarioManu: ScenarioBuilder = scenario("PutSimulationManu")
    .exec(http("PUT_manu_OpenToStage1")
    .put("/manufacturedomain/workorder/advance_status/1")
    .header("Content-Type", "application/json")
		.basicAuth("admin","adminpwd"))
    .pause(5)
    .exec(http("PUT_manu_Stage1ToStage2")
    .put("/manufacturedomain/workorder/advance_status/1")
    .header("Content-Type", "application/json")
		.basicAuth("admin","adminpwd"))
    .pause(5)
    .exec(http("PUT_manu_Stage2ToStage3")
    .put("/manufacturedomain/workorder/advance_status/1")
    .header("Content-Type", "application/json")
		.basicAuth("admin","adminpwd"))
    .pause(5)
    .exec(http("PUT_manu_CompleteWorkorder")
    .put("/manufacturedomain/workorder/1/2")
    .header("Content-Type", "application/json")
		.basicAuth("admin","adminpwd"))
    .pause(5)
  
  
}
/*
        #set workorder with id 1 in different states
        #from OPEN to STAGE1
        curl -u admin:adminpwd --header "Content-Type: application/json" --request PUT --data @data/workorder.json http://$HOST:$PORT/manufacturedomain/workorder/advance_status/1
        #from STAGE1 to STAGE2
        curl -u admin:adminpwd --header "Content-Type: application/json" --request PUT --data @data/workorder.json http://$HOST:$PORT/manufacturedomain/workorder/advance_status/1
        #from STAGE3 to STAGE3
        curl -u admin:adminpwd --header "Content-Type: application/json" --request PUT --data @data/workorder.json http://$HOST:$PORT/manufacturedomain/workorder/advance_status/1
        #complete with id 1 workorder
        curl -u admin:adminpwd --header "Content-Type: application/json" --request PUT --data @data/workorder.json http://$HOST:$PORT/manufacturedomain/workorder/1/2
*/
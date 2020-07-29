package de.novatec.gatling.scenarios

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._

object PostScenarioOrder extends Simulation {


  val postScenarioOrder: ScenarioBuilder = scenario("PostSimulationOrder")
    .exec(http("POST_order_1")
    .post("/orderdomain/order/1")
    .header("Content-Type", "application/json")
    .body(RawFileBody("bodies/order/items_quantity_pairs.json"))
		.basicAuth("admin","adminpwd"))
    .pause(5)
    /*
 # create a new order (large order) for customer with id 1
      

        # create a new order for customer with id 1
       DONE  curl -u admin:adminpwd --header "Content-Type: application/json" --request POST --data @data/items_quantity_pairs.json http://$HOST:$PORT/orderdomain/order/1

        

        # add inventory for customer with id 1
       DONE curl -u testuser:pwd --header "Content-Type: application/json" --request PUT http://$HOST:$PORT/orderdomain/customer/add_inventory/1

        # sell inventory for customer with id 1, item with id 2 and the quantity 1
        curl -u testuser:pwd --header "Content-Type: application/json" --request PUT http://$HOST:$PORT/orderdomain/customer/sell_inventory/1/2/1
    

     DONE  curl -u admin:adminpwd --header "Content-Type: application/json" --request POST --data @data/items_quantity_pairs_large_order.json http://$HOST:$PORT/orderdomain/order/1
    # try to create a new order for a non existing customer with id 100
    
    */
}

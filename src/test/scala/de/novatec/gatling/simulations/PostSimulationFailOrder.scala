package de.novatec.gatling.simulations

import io.gatling.core.Predef._
import de.novatec.gatling.scenarios.PostScenarioFailOrder.postScenarioFailOrder
import de.novatec.gatling.config.ConfigOrder._

import scala.language.postfixOps

class PostSimulationFailOrder extends Simulation {

  println("Configuration:")
  println("BaseURL: " + baseUrl)
  println("Nr atOnce users: " + usersAtOnce)
  println("Nr ramp users: " + users)
  println("Max duration: " + maxDuration)
  println("RampUp time: " + rampUpTime)

  setUp(
    postScenarioFailOrder.inject(atOnceUsers(usersAtOnce),rampUsers(users) during rampUpTime)).maxDuration(maxDuration).protocols(httpProtocol)
    .assertions(
      global.failedRequests.count.gte(2)
    )
}

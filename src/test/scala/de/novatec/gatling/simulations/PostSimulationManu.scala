package de.novatec.gatling.simulations

import io.gatling.core.Predef._
import de.novatec.gatling.scenarios.PostScenarioManu.postScenarioManu
import de.novatec.gatling.config.ConfigManu._

import scala.language.postfixOps

class PostSimulationManu extends Simulation {

  println("Configuration for MANU Post-Simu:")
  println("BaseURL: " + baseUrl)
  println("Nr atOnce users: " + usersAtOnce)
  println("Nr ramp users: " + users)
  println("Max duration: " + maxDuration)
  println("RampUp time: " + rampUpTime)

  setUp(
    postScenarioManu.inject(atOnceUsers(usersAtOnce),rampUsers(users) during rampUpTime)).maxDuration(maxDuration).protocols(httpProtocol)
    .assertions(
      global.failedRequests.count.is(0)
    )
}

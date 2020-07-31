package de.novatec.gatling.simulations

import io.gatling.core.Predef._
import de.novatec.gatling.scenarios.PutScenarioManu.putScenarioManu
import de.novatec.gatling.config.ConfigManu._

import scala.language.postfixOps

class PutSimulationManu extends Simulation {

  println("Configuration for Manu:")
  println("BaseURL: " + baseUrl)
  println("Nr atOnce users: " + usersAtOnce)
  println("Nr ramp users: " + users)
  println("Max duration: " + maxDuration)
  println("RampUp time: " + rampUpTime)

  setUp(
    putScenarioManu.inject(atOnceUsers(usersAtOnce),rampUsers(users) during rampUpTime)).maxDuration(maxDuration).protocols(httpProtocol)
    .assertions(
      global.failedRequests.count.is(0)
    )
}

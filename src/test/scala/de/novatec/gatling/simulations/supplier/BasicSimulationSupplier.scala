package de.novatec.gatling.simulations

import io.gatling.core.Predef._
import de.novatec.gatling.scenarios.BasicScenarioSupplier.basicScenarioSupplier
import de.novatec.gatling.config.ConfigSupplier._

import scala.language.postfixOps

class BasicSimulationSupplier extends Simulation {

  println("Configuration:")
  println("BaseURL: " + baseUrl)
  println("Nr atOnce users: " + usersAtOnce)
  println("Nr ramp users: " + users)
  println("Max duration: " + maxDuration)
  println("RampUp time: " + rampUpTime)

  setUp(
    basicScenarioSupplier.inject(atOnceUsers(usersAtOnce),rampUsers(users) during rampUpTime)).maxDuration(maxDuration).protocols(httpProtocol)
    .assertions(
      global.failedRequests.count.is(0)
    )
}

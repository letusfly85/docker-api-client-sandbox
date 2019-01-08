package io.wonder.soft.sandbox.route

import io.wonder.soft.sandbox.controller.ContainerController
import javax.inject.Inject
import play.api.routing.Router.Routes
import play.api.routing.SimpleRouter
import play.api.routing.sird._

class ApiRouter @Inject()
(
  containerController: ContainerController
) extends SimpleRouter {

  override def routes: Routes = {
    case POST(p"/containers/pull") =>
      containerController.pull

    case POST(p"/containers/push") =>
      containerController.push
  }

}

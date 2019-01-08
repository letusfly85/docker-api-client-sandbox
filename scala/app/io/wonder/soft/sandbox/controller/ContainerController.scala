package io.wonder.soft.sandbox.controller

import io.wonder.soft.sandbox.service.DockerService
import javax.inject._
import play.api.libs.json._
import play.api.mvc._

/**
  * This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
@Singleton
class ContainerController @Inject()
(
  dockerService: DockerService,
  cc: ControllerComponents
) extends AbstractController(cc) {

  def pull = Action { implicit request =>
    Ok
  }

  def push = Action { implicit request =>
    Ok
  }

}

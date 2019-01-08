package io.wonder.soft.sandbox.service

import akka.actor.ActorRef
import com.spotify.docker.client.ProgressHandler
import com.spotify.docker.client.messages.ProgressMessage
import play.api.Logger

class DockerEventProgressHandler(actorRef: ActorRef) extends ProgressHandler {

  override def progress(message: ProgressMessage): Unit = {
    Logger.info(message.toString)
  }

}

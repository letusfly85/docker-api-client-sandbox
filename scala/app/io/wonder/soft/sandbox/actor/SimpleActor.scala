package io.wonder.soft.sandbox.actor

import akka.actor.Actor

class SimpleActor extends Actor {

  def receive = {
    case _ =>
      // do nothing on sandbox
  }

}

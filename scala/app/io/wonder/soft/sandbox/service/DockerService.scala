package io.wonder.soft.sandbox.service

import java.net.URI

import akka.actor.ActorRef
import com.spotify.docker.client.DefaultDockerClient
import com.spotify.docker.client.messages.ContainerConfig

class DockerService {

  private var client: DefaultDockerClient = _

  def generateClient(host: String = "0.0.0.0", port: Int = 2375) = {
    val docker = DefaultDockerClient
      .builder
      .uri(URI.create(s"http://${host}:${port}"))
      // .dockerCertificates(new DockerCertificates(Paths.get("/Users/rohan/.docker/boot2docker-vm/")))
      .build

    this.client = docker
    docker
  }

  /**
    *
    * @param imageName
    * @param actorRef
    */
  def pullImage(imageName: String, actorRef: ActorRef) = {
    val progressHandler = new DockerEventProgressHandler(actorRef)

    this.client.pull(imageName, progressHandler)
  }

  /**
    *
    * @param imageName
    * @param actorRef
    */
  def pushImage(imageName: String, actorRef: ActorRef) = {
    val progressHandler = new DockerEventProgressHandler(actorRef)

    this.client.push(imageName, progressHandler)
  }

}

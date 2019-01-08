import docker


class DockerService:

    def __init__(self):
        self.docker_client = docker.from_env()

    def pull(self, image_name):
        for line in self.docker_client.images.pull(image_name, stream=True):
            print(line)

    def push(self, image_name):
        for line in self.docker_client.images.push(image_name, stream=True):
            print(line)

import docker


class DockerService:

    def __init__(self):
        self.docker_client = docker.from_env()

    def pull(self, image_name):
        self.docker_client.images.pull(image_name, stream=True)

    def push(self, image_name):
        self.docker_client.images.push(image_name, stream=True)

    def show_events(self):
        for line in self.docker_client.events():
            print(line)

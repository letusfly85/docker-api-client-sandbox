import pykka

from app.service.docker_service import DockerService


class DockerEventActor(pykka.ThreadingActor):

    docker_service = DockerService()

    def __init__(self):
        super().__init__()

    @staticmethod
    def on_start():
        try:
            print('start an actor')

        except Exception as e:
            print(e)

    def on_receive(self, message):
        if 'show_image' in message:
            print(message)
            self.docker_service.show_events()

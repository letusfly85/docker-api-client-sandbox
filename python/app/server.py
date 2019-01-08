from flask import Flask, session, request, jsonify, make_response
from flask_restplus import Api, Resource, fields
from flask_cors import CORS
from flask_session import Session
from flask import redirect
import requests

import json
import sys
import os

from app.service.docker_service import DockerService


args = sys.argv
env = os.getenv("APP_ENV", "local")

app = Flask(__name__)
app.config.from_pyfile("config/{}.properties".format(env))
api = Api(app, version='0.0.1', title='sandbox API', description='sandbox API')

app.secret_key = app.config['SECRET_KEY']
app.supports_credentials = True
Session(app)
CORS(app, resources={r"/*": {"origins": "*"}})

ns = api.namespace('api')
pns = api.namespace('')

docker_service = DockerService()


@ns.route('/containers/push')
class ContainersPush(Resource):

    @staticmethod
    def post():
        docker_service.push("nginx")
        result = {}
        return jsonify(result)


@ns.route('/containers/pull')
class ContainersPull(Resource):

    @staticmethod
    def post():
        docker_service.pull("nginx")
        result = {}
        return jsonify(result)


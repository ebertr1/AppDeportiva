from flask import Flask

def create_app():
    app = Flask(__name__, instance_relative_config=False)
    with app.app_context():
        from routes.router import router
        from routes.routerDirigente import routerDirigente
        from routes.routerEquipo import routerEquipo
        from routes.routerJugador import routerJugador
        app.register_blueprint(router)
        app.register_blueprint(routerDirigente)
        app.register_blueprint(routerEquipo)
        app.register_blueprint(routerJugador)
    return app
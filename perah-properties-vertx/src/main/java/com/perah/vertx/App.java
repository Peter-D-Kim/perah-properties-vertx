package com.perah.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

public class App extends AbstractVerticle {

    @Override
    public void start(Promise<Void> startPromise) {
        Router router = Router.router(vertx);

        router.get("/").handler(ctx ->
            ctx.response()
                .putHeader("content-type", "text/plain")
                .end("Hello from Perah Properties Vert.x!")
        );

        vertx.createHttpServer()
            .requestHandler(router)
            .listen(8888, result -> {
                if (result.succeeded()) {
                    System.out.println("HTTP server started on http://localhost:8888");
                    startPromise.complete();
                } else {
                    startPromise.fail(result.cause());
                }
            });
    }

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new App(), deploy -> {
            if (deploy.succeeded()) {
                System.out.println("Verticle deployed successfully.");
            } else {
                System.err.println("Failed to deploy verticle: " + deploy.cause());
            }
        });
    }
}

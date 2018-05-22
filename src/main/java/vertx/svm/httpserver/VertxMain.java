package vertx.svm.httpserver;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerOptions;

public class VertxMain {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.createHttpServer(new HttpServerOptions().setSsl(false)).requestHandler(req -> req.response().end("Hello World")).listen(8080);
    }
}

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;

public class App {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        HttpServer httpServer = vertx.createHttpServer();
        Router router = Router.router(vertx);
        router.route("/hello").handler(routingContext -> {
            HttpServerResponse response = routingContext.response();
            response.putHeader("content-type", "text/html")
                    .end("Hello World!");

        });

        httpServer.requestHandler(router).listen(8091);



        vertx.createHttpClient().getNow(80, "vertx.io", "", response -> {
            response.bodyHandler(System.out::println);
        });


    }
}

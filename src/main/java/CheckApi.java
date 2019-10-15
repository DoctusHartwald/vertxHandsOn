import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.client.HttpResponse;
import io.vertx.ext.web.client.WebClient;

public class CheckApi extends AbstractVerticle {
    private final Logger logger = LoggerFactory.getLogger(CheckApi.class);

    @Override
    public void start() {
        WebClient client = WebClient.create(vertx);

// Send a GET request
        client
                .get("toto.fr", "/")
                .send(ar -> {
                    if (ar.succeeded()) {
                        // Obtain response
                        HttpResponse<Buffer> response = ar.result();

                        System.out.println("Received response with status code" + response.statusCode());
                    } else {
                        System.out.println("Something went wrong " + ar.cause().getMessage());
                    }
                });
    }


    public static void main(String[] args) {
        int i = 0;


        Vertx
                .vertx()
                .deployVerticle(new CheckApi());

    }

}
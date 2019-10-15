import io.vertx.core.AbstractVerticle;

public class HttpVerticle extends AbstractVerticle {
    @Override
    public void start() {
        vertx.deployVerticle("demo.inventory.InventoryApi");

    }
}

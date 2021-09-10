import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {

    public static void main(String[] args) throws IOException {
	int serverPort = 8000;
    ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
    HttpServer server = HttpServer.create(new InetSocketAddress("localhost", serverPort), 0);
    server.createContext("/test", new MyHttpHandler());
    server.setExecutor(threadPoolExecutor);
    server.start();
    }
}

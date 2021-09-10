import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class MyHttpHandler implements HttpHandler {


    public void handle(HttpExchange httpExchange) throws IOException {
        String requestParamValue=null;

        if("GET".equals(httpExchange.getRequestMethod())) {
            handleGetResponse(httpExchange);
        }
    }



    private void handleGetResponse(HttpExchange httpExchange)  throws  IOException {
        OutputStream outputStream = httpExchange.getResponseBody();
        String response = "help";


        httpExchange.sendResponseHeaders(200, response.length());

        outputStream.write(response.getBytes());
        outputStream.flush();
        outputStream.close();
    }
}
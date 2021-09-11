import Responses.GetDefault;
import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class MyHttpHandler implements HttpHandler {

    public void handle(HttpExchange httpExchange) throws IOException {

        if("GET".equals(httpExchange.getRequestMethod())) {
            handleGetResponse(httpExchange);
        }
    }

    private void handleGetResponse(HttpExchange httpExchange)  throws  IOException {
        try (OutputStream outputStream = httpExchange.getResponseBody()) {
            Gson gson = new Gson();

            GetDefault response = new GetDefault("Success", (long) System.currentTimeMillis(), "Hello");
            String JSONresponse = (String)gson.toJson(response);
            httpExchange.sendResponseHeaders(200, JSONresponse.length());

            outputStream.write(JSONresponse.getBytes());
            outputStream.flush();
            outputStream.close();
        }
    }
}
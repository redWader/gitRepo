package Responses;

public class GetDefault {
    String status;
    String actualTimeStamp;
    String message;

    public GetDefault() {}

    public GetDefault(String status, String actualTimeStamp, String message) {
        this.status = status;
        this.actualTimeStamp = actualTimeStamp;
        this.message = message;
    }
}

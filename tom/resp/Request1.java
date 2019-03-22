package tom.resp;


import java.io.IOException;
import java.io.InputStream;

public class Request1 {


    private String requestMethod;
    private String requestUrl;

    public Request1(String requestMethod, String requestUrl) {
        this.requestMethod = requestMethod;
        this.requestUrl = requestUrl;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    @Override
    public String toString() {
        return "Request1{" +
                "requestMethod='" + requestMethod + '\'' +
                ", requestUrl='" + requestUrl + '\'' +
                '}';
    }
}

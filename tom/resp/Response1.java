package tom.resp;


import java.io.IOException;
import java.io.OutputStream;

public class Response1 {

    private String content;

    public Response1(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

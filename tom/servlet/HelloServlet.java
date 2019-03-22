package tom.servlet;


import tom.resp.Request1;
import tom.resp.Response1;

public class HelloServlet extends MainServlet {

    @Override
    public void doGet(Request1 request1, Response1 response1){
        response1.setContent("Hello get!");
    }

    @Override
    public void doPost(Request1 request1, Response1 response1) {
        response1.setContent("Hello post!");
    }


}

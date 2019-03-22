package tom.servlet;


import tom.resp.Request1;
import tom.resp.Response1;

public abstract class MainServlet {

    public abstract void doGet(Request1 request1, Response1 response1);

    public abstract void  doPost(Request1 request1, Response1 response1);


    public void service(Request1 request1, Response1 response1){

        if (request1.getRequestMethod().equalsIgnoreCase("POST")){
            doPost(request1,response1);
        }else if (request1.getRequestMethod().equalsIgnoreCase("GET")){
            doGet(request1,response1);
        }

    }
}

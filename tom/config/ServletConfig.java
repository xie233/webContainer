package tom.config;


import java.util.ArrayList;
import java.util.List;

public class ServletConfig {

    public static List<ServletMapping> servletConfig = new ArrayList<>();

    //web.xml 的servlet映射
    static {
        servletConfig.add(new ServletMapping("hello","/hello","tom.servlet.HelloServlet"));
    }
}

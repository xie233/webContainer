package tom.config;



public class ServletMapping {

    private String servletName;
    private String servletUrl;
    private String servletClazz;

    public ServletMapping(String servletName, String servletUrl, String servletClazz) {
        this.servletName = servletName;
        this.servletUrl = servletUrl;
        this.servletClazz = servletClazz;
    }

    public String getServletName() {
        return servletName;
    }

    public void setServletName(String servletName) {
        this.servletName = servletName;
    }

    public String getServletUrl() {
        return servletUrl;
    }

    public void setServletUrl(String servletUrl) {
        this.servletUrl = servletUrl;
    }

    public String getServletClazz() {
        return servletClazz;
    }

    public void setServletClazz(String servletClazz) {
        this.servletClazz = servletClazz;
    }
}

package ua.bondarenkojek.homework.jdbc.web;

import java.util.Map;
import java.util.Objects;

public class Request {
    private String uri;
    private RequestMethod method;
    private Map<String, String[]> params;

    public enum RequestMethod {
        GET,
        POST
    }

    public Request(String uri, RequestMethod method, Map<String, String[]> params) {
        this.uri = uri;
        this.method = method;
        this.params = params;
    }

    public static Request of(String url, RequestMethod method) {
        return of(url, method, null);
    }

    public static Request of(String url, RequestMethod method, Map<String, String[]> params) {
        return new Request(url, method, params);
    }

    public static RequestMethod ofRequestMethod(String method) {
        return RequestMethod.valueOf(method);
    }

    public String getParamByName(String name) {
        return params.get(name)[0];
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return Objects.equals(uri, request.uri) &&
                method == request.method;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uri, method);
    }
}

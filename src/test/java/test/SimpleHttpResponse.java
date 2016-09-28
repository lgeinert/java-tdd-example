package test;

public final class SimpleHttpResponse {
    public final int code;
    public final String body;

    SimpleHttpResponse(final int code, final String body) {
        this.code = code;
        this.body = body;
    }
}

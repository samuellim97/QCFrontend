package com.help.quickcard.api;

import com.android.volley.RequestQueue;

/**
 * Created by shath on 20/02/18.
 */

public class WebAPI {
    private String url;
    private int port;

    protected RequestQueue queue;

    public WebAPI(RequestQueue queue) {
        this.queue = queue;
    }

    public RequestQueue getQueue() {
        return queue;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getPort() {
        return port;
    }
}

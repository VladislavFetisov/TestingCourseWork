package core;

import java.net.MalformedURLException;

public enum URL {
    OK("https://ok.ru/");

    private java.net.URL link;

    URL(String link) {
        this.link = null;
        try {
            this.link = new java.net.URL(link);
        } catch (MalformedURLException e) {
            System.err.println("Link is wrong");
        }
    }

    public java.net.URL getLink() {
        return link;
    }
}

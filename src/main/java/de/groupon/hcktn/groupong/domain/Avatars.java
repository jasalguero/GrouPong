package de.groupon.hcktn.groupong.domain;

import java.util.LinkedList;
import java.util.List;

public class Avatars {

    private List<String> urls = new LinkedList<String>();

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }
}

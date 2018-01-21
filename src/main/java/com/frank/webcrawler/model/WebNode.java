package com.frank.webcrawler.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "url")
public class WebNode implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty
    private String url;
    @JsonProperty
    private String title;
    @JsonProperty
    private List<WebNode> nodes;

    public WebNode(String url, String title) {
        this.url = url;
        this.title = title;
        this.nodes = new ArrayList<>();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<WebNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<WebNode> nodes) {
        this.nodes = nodes;
    }

    @JsonValue
    @Override
    public String toString() {
        return "{" +
                "\"url\":\"" + url + '\"' +
                ", \"title\":\"" + title + '\"' +
                ", \"nodes\":" + nodes +
                '}';
    }

    public void addSubNode(WebNode node) {
        if (null != node) {
            this.nodes.add(node);
        }
    }
}

package com.frank.webcrawler.service;

import com.frank.webcrawler.model.WebNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Component
@Scope("prototype")
public class WebCrawlerWithDepthService {
    public static final Logger logger = LoggerFactory.getLogger(WebCrawlerWithDepthService.class);

    private int MAX_DEPTH = 3;
    private HashSet<String> links;

    public WebCrawlerWithDepthService() {
        links = new HashSet<>();
    }

    private WebNode getPageLinks(String URL, int depth) {
        WebNode node = null;
        if ((!links.contains(URL) && (depth < MAX_DEPTH))) {
            logger.info(">> Depth: " + depth + " [" + URL + "]");
            try {
                links.add(URL);

                Document document = Jsoup.connect(URL).get();
                node = new WebNode(URL, document.title());
                Elements linksOnPage = document.select("a[href]");

                depth++;
                if (depth  < MAX_DEPTH){
                    for (Element page : linksOnPage) {
                        node.addSubNode(getPageLinks(page.attr("abs:href"), depth));
                    }
                }
            } catch (IOException e) {
                logger.error("For '" + URL + "': " + e.getMessage());
            }
        }

        return node;
    }

    public List<WebNode> getWebNodeList(String url) {
        List<WebNode> webNodeList = new ArrayList<>();
        WebNode rootNode = getPageLinks(url, 0);
        webNodeList.add(rootNode);

        return webNodeList;
    }

    public List<WebNode> getWebNodeList(String url, int maxDepth) {
        this.MAX_DEPTH = maxDepth;
        return getWebNodeList(url);
    }
}

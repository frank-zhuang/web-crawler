package com.frank.webcrawler.controller;

import com.frank.webcrawler.service.WebCrawlerWithDepthService;
import com.frank.webcrawler.model.WebNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "/")
@RequestMapping
public class CrawlerController {
    public static final Logger logger = LoggerFactory.getLogger(CrawlerController.class);

    @Autowired
    WebCrawlerWithDepthService webCrawlerWithDepth;

    @RequestMapping(value = "/node-tree", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<WebNode> getNodeTree(@RequestParam String url) {
        return webCrawlerWithDepth.getWebNodeList(url);
    }
}

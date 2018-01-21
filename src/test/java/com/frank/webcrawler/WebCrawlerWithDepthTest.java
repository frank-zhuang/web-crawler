package com.frank.webcrawler;

import com.frank.webcrawler.model.WebNode;
import com.frank.webcrawler.service.WebCrawlerWithDepthService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebCrawlerWithDepthTest {

    @Autowired
    WebCrawlerWithDepthService webCrawlerWithDepth;

    @Test
    public void getNodeList() {
        List<WebNode> webNodeList = webCrawlerWithDepth.getWebNodeList("http://www.qantasloyalty.com", 2);

        assert webNodeList.size() >0 ;
    }

    }

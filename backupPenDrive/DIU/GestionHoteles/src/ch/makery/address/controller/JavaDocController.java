package ch.makery.address.controller;

import javafx.fxml.FXML;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;

public class JavaDocController {
    @FXML
    WebView webView;

    /**
     *
     */
    @FXML
    private void initialize() {
        webView.getEngine();
        WebEngine webEngine = webView.getEngine();


        URL url = this.getClass().getResource("/res/javadoc/index.html");
        webEngine.load(url.toString());


        /*
        webEngine.load("http://google.com");
         */

//        String content = "Hello World!";
  //      webEngine.loadContent(content, "text/html");
    }

}

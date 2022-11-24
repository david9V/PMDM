package ch.makery.address.controller;

import javafx.fxml.FXML;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

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

    }

}

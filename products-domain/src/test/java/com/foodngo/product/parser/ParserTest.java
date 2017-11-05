package com.foodngo.product.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;

public class ParserTest {


    @Test
    public void test() throws Exception {

        String fullAddress = "http://szopi.pl/catalogue/?partner=%d&page=%d";

        for (int i = 1; i < 162; i++) {
            String format = String.format(fullAddress, 78, i);

            FetchProduct fetchProduct = new FetchProduct(format);

            fetchProduct.run();
        }

        ProductHtmlParser php = new ProductHtmlParser();


    }


    public static class FetchProduct implements Runnable {

        private final String urlToFetch;

        public FetchProduct(String urlToFetch) {
            this.urlToFetch = urlToFetch;
        }

        @Override
        public void run() {
            Document doc = null;
            try {
                doc = Jsoup.connect(urlToFetch).get();
            } catch (IOException e) {


            }

            Elements elements = doc.getElementsByTag("article");

            elements.forEach(
                    e -> {
                        String productName = e.attr("data-product-name");
                        String productPrice = e.attr("data-product-price");
                        System.out.println(productName + "  " + productPrice);
                    }
            );
        }
    }

}

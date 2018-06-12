package com.jsoup.example;

import java.io.IOException;
import java.util.logging.Logger;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class JsoupExample {
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("JsoupExample.java");

		try {

			String url = "https://www.teknosa.com/urunler/125076594/apple-iphone-x-64-gb-akilli-telefon-uzay-grisi";
			logger.info("Url: " + url);
			Response response = Jsoup.connect(url).timeout(30000).execute();

			Document doc = response.parse();

			Elements elements = doc.select("div.new-price");

			logger.info("Price: " + elements.first().text());

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
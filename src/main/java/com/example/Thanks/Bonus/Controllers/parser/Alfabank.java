package com.example.Thanks.Bonus.Controllers.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Alfabank {
	private static Document getPageRenCredit() throws IOException {
		String url = "https://alfabank.ru/get-money/credit-cards/";
		Document page = Jsoup.parse(new URL(url),3000);
		return page;
}
	public static void main(String [] arg) throws IOException {
		Document doc = Jsoup.connect("https://alfabank.ru/get-money/credit-cards/").get();
		Elements oneElements = doc.getElementsByAttributeValue("class", "a3Dntr f3Dntr Y23Qzr");
		for ( int i=0; i<8; i++)  //Две первые кредитные карты Альфы
		{
			Element oneElement = oneElements.get(i);
			Element cardInfo = oneElement.child(1).attr("class", "k3Dntr l3Dntr");
			Elements divs = cardInfo.select("span > a > img");
			//Elements divv = divs.select("img[alt]").first().ownText();

			String text = cardInfo.text();
			//zeroElement = oneElement.child(1);
			System.out.println(divs.attr("alt"));
		}
	}
}
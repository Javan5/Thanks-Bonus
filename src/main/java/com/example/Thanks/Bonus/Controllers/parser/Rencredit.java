package com.example.Thanks.Bonus.Controllers.parser;

import com.example.Thanks.Bonus.service.CardService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.example.Thanks.Bonus.service.CardService;

public class Rencredit {
	private static Document getPageRenCredit() throws IOException {
		String url = "https://rencredit.ru/cards/";
		Document page = Jsoup.parse(new URL(url),3000);
		return page;
	}

	public static void main(String [] args) throws IOException, SQLException {
		Document page = getPageRenCredit();
		List<creditCard> sberList = new ArrayList<>();
		Document doc = Jsoup.connect("https://rencredit.ru/cards/").get();
		Elements oneElements = doc.getElementsByAttributeValue("class", "card-detail__content");
		for ( int i=0; i<2; i++)  //Две первые кредитные карты ренкредита
		{
			Element oneElement = oneElements.get(i);
			Element zeroElement = oneElement.child(0);
			Element cardInfo = zeroElement.child(0).attr("class", "card-detail__heading");
			Elements cardName = cardInfo.select("h3");
			zeroElement = oneElement.child(1);
			cardInfo = zeroElement.child(0).attr("class", "card-detail__value card-detail__value--special");
			Element cardInfoz = cardInfo.child(0).child(1).child(1);
			Element cardInfozz = cardInfo.child(1).child(1).child(1);
			creditCard rencr = new creditCard(i+1, cardName.text(), Integer.parseInt(cardInfoz.text().split(" ")[0]), Integer.parseInt(cardInfozz.text().replaceAll("\\s+","")), 0);
			System.out.println(rencr.ToString());
			CardService cardService = new CardService();
			cardService.addCreditCard(rencr);

		}
		//addCreditCard()

	}

}
package com.example.Thanks.Bonus.Controllers.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Sber {

	private static Document getPageRenCredit() throws IOException {
		String url = "https://rencredit.ru/cards/";
		Document page = Jsoup.parse(new URL(url),3000);
		return page;
	}

 public static void main(String [] arg) throws IOException {
		Document page = getPageRenCredit();
	 //System.out.println(page);
		//Elements table = page.select("body>div.bp-area --area pageContainer>div.bp-container bp-ui-dragRoot bp-manageableArea --area bp-area>div.bp-widget  widget-chrome-none>div.scd-products-card__type");

	 Elements table = page.select("h3");
	 String cardss = table.text();
	 System.out.println(table);
	 System.out.println(cardss+"/n");
	 //Elements oneElements = doc.getElementsByAttributeValue("class", "scd-products-card__type");






	 List<creditCard> sberList = new ArrayList<>();
	 Document doc = Jsoup.connect("https://rencredit.ru/cards/").get();
	 Elements oneElements = doc.getElementsByAttributeValue("class", "card-detail__content");
	 //System.out.println(oneElements);
	 //for(Element oneElement = oneElements.get(i); i<2;i++ )
	 for ( int i=0; i<2; i++)  //Две первые кредитные карты ренкредита
	 	//oneElements.forEach(oneElement ->
	 {
		 Element oneElement = oneElements.get(i);
		Element zeroElement = oneElement.child(0);
		Element cardInfo = zeroElement.child(0).attr("class", "card-detail__heading");
		System.out.println(i);
		Elements cardName = cardInfo.select("h3");


		//Elements cardgrPer = cardInfo.select("");
		 //Element cardgrPer = cardInfo.attr("class","card-detail__value-big");

		 //Element cardInfo = zeroElement.child(0).attr("class", "card-detail__heading");

		 zeroElement = oneElement.child(1);
		 cardInfo = zeroElement.child(0).attr("class", "card-detail__value card-detail__value--special");
		 Element cardInfoz = cardInfo.child(0).child(1).child(1);
		 Element cardInfozz = cardInfo.child(1).child(1).child(1);
		// Element cardgrPer = cardInfo.attr("class","card-detail__value-big");



		 //String texTT = cardName.text();
		 String texTT = cardName.text();
		System.out.println(texTT);
		  texTT = cardInfoz.text();
		 texTT = texTT.split(" ")[0];
		 System.out.println("KYKY");
		 creditCard rencr = new creditCard(cardName.text(), Integer.parseInt(cardInfoz.text().split(" ")[0]), Integer.parseInt(cardInfozz.text().replaceAll("\\s+","")), 0);
		 System.out.println(rencr.ToString());
		 System.out.println(texTT);

		 //texTT = texTT.substring(0, texTT.indexOf(' '));
		 texTT = cardInfozz.text();
		 System.out.println(texTT);
		//sberList.add(new banks(text));
	 }//);
	 //sberList.forEach(System.out::println);
 }
}

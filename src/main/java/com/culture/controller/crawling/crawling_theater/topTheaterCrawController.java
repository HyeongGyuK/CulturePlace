package com.culture.controller.crawling.crawling_theater;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import lombok.Getter;
import lombok.Setter;

public class topTheaterCrawController {
	final static int topCount = 5;
	
	@Getter @Setter
	private static LinkedHashMap<String, String> theaterTopFiveCodeNImg;
	@Getter @Setter
	private static LinkedHashMap<String, String> theaterTopFiveCodeNTitle;
	@Getter @Setter
	private static List<String> theaterTopFiveCode;
	@Getter @Setter
	private static LinkedHashMap<String, String> musicalTopFiveCodeNImg;
	@Getter @Setter
	private static LinkedHashMap<String, String> musicalTopFiveCodeNTitle;
	@Getter @Setter
	private static List<String> musicalTopFiveCode;
	
	public static void getTheaterTopFiveList() {
		theaterTopFiveCodeNImg = new LinkedHashMap<String, String>();
		theaterTopFiveCodeNTitle = new LinkedHashMap<String, String>();
		theaterTopFiveCode = new ArrayList<String>();
		
		musicalTopFiveCodeNImg = new LinkedHashMap<String, String>();
		musicalTopFiveCodeNTitle = new LinkedHashMap<String, String>();
		musicalTopFiveCode = new ArrayList<String>();
		
		String theaterUrl = "http://ticket.interpark.com/contents/Ranking/RankList?pKind=01009&pType=D";
		String musicalUrl = "http://ticket.interpark.com/contents/Ranking/RankList?pKind=01011&pType=D";
		
		Connection theaterConn = Jsoup.connect(theaterUrl);
		Connection musicalConn = Jsoup.connect(musicalUrl);
		
		try {
			Document theaterDocument = theaterConn.get();
			Document musicalDocument = musicalConn.get();
			
			theaterTopFiveCodeNImg = getTopFiveImg(theaterDocument);
			musicalTopFiveCodeNImg = getTopFiveImg(musicalDocument);
			
			for (String key : theaterTopFiveCodeNImg.keySet()) {
				theaterTopFiveCode.add(key);
			}
			
			for (String key : musicalTopFiveCodeNImg.keySet()) {
				musicalTopFiveCode.add(key);
			}
			
			theaterTopFiveCodeNTitle = getTopFiveTitle(theaterDocument);
			musicalTopFiveCodeNTitle = getTopFiveTitle(musicalDocument);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static LinkedHashMap<String, String> getTopFiveImg(Document document) {
		LinkedHashMap<String, String> topFiveImgList = new LinkedHashMap<String, String>();
		Elements topFiveImgTag = document.select("body > div.rankingDetailBody > div:nth-child(n+2) > table > tbody > tr:nth-child(1) > td:nth-child(1) > a > img");
		
		try {
			for(int i = 0; i < topCount; i++) {
				int imgCodeIdx = topFiveImgTag.get(i) .attr("src").lastIndexOf("/");
				int imgCodeIdx2 = topFiveImgTag.get(i).attr("src").indexOf("_");
				String imgCode = topFiveImgTag.get(i).attr("src").substring(imgCodeIdx+1, imgCodeIdx2);
//				System.out.println(imgCode);
				
				String imgUrl = topFiveImgTag.get(i).attr("src");
//				System.out.println(imgUrl);
				
				topFiveImgList.put(imgCode, imgUrl);
			}			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return topFiveImgList;
	}
	
	public static LinkedHashMap<String, String> getTopFiveTitle(Document document) {
		LinkedHashMap<String, String> topFIveTitleList = new LinkedHashMap<String, String>();
		Elements topFiveTitleTag = document.select("body > div.rankingDetailBody > div:nth-child(n+2) > table > tbody > tr > td.prds > div.prdInfo > a > b");
		
		try {
			for(int i = 0; i < topCount; i++) {
				String topFiveTitle = topFiveTitleTag.get(i).text().trim();
//				System.out.println(topFiveTitle);
				
//				System.out.println("aadsaf" + musicalTopFiveCode.get(i));
				topFIveTitleList.put(theaterTopFiveCode.get(i), topFiveTitle);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return topFIveTitleList;
	}
	
    public static void main(String[] args) {
    	getTheaterTopFiveList();
    }
}

























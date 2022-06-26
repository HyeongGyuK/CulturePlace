package com.culture.controller.crawling.crawling_theater;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Getter;
import lombok.Setter;

@Controller
@ResponseBody
@RequestMapping(value = "/culturePlace/allTheaterList", method = RequestMethod.POST)
public class allListTheaterCrawController {

	@Getter @Setter
	private static LinkedHashMap<String, String> theaterCodeNImg;
	
	@Getter @Setter
	private static LinkedHashMap<String, String> theaterCodeNTitle;
	
	@Getter @Setter
	private static LinkedHashMap<String, String> theaterCodeNPlace;
	
	private static List<String> codeList = new ArrayList<String>();
	
	@Getter @Setter
	private static String result = "" ;
	
	private static String htmlCode = "";
	private static int cnt = 0;
	
	@ResponseBody
	@GetMapping(value = "/allList")
	public static String getTheaterAllList(@RequestParam("theaterUrl") String theaterUrl) {
//		System.out.println("---------------------------------------------" + theaterUrl);

//		String url = "http://www.playdb.co.kr/playdb/playdblist.asp?sReqMainCategory=000002";
		String url = theaterUrl;
		result = "";
		theaterCodeNImg  = new LinkedHashMap<String, String>();
		theaterCodeNTitle = new LinkedHashMap<String, String>();
		theaterCodeNPlace  = new LinkedHashMap<String, String>();
//		System.out.println("result1 : " + result);
//		System.out.println(url);
		Connection conn = Jsoup.connect(url);
		
		try {
			Document document = conn.get();
			String pageNum = "";
			if(url == "http://www.playdb.co.kr/playdb/playdblist.asp?sReqMainCategory=000005" || url.equals("http://www.playdb.co.kr/playdb/playdblist.asp?sReqMainCategory=000005")) {
				Connection connClassic = Jsoup.connect("http://www.playdb.co.kr/playdb/playdblist.asp?sReqMainCategory=000005&sReqSubCategory=&sReqDistrict=&sReqTab=2&sPlayType=2&sStartYear=&sSelectType=1");
				Document documentClassic = connClassic.get();
				pageNum = getPageNum(documentClassic).trim();
			}else {
				pageNum = getPageNum(document).trim();
			}
//			System.out.println("aaaaaa");
//			System.out.println(pageNum);
//			System.out.println("bbbbbbb");
			
			int pNum = Integer.parseInt(pageNum);
			
			if(url == "http://www.playdb.co.kr/playdb/playdblist.asp?sReqMainCategory=000002" || url.equals("http://www.playdb.co.kr/playdb/playdblist.asp?sReqMainCategory=000002")) {
//				System.out.println("aaaaaaaaaaaaaaa");
				for(int i = 1; i <= pNum; i++) {
					String theaterListUrl = "http://www.playdb.co.kr/playdb/playdblist.asp?Page=" + i + "&sReqMainCategory=000002&sReqSubCategory=&sReqDistrict=&sReqTab=2&sPlayType=2&sStartYear=&sSelectType=";
//					System.out.println(theaterListUrl);
					
					Connection conn2 = Jsoup.connect(theaterListUrl.trim());
					Document document2 = conn2.get();
					
					getTheaterImgTag(document2);
					getTheaterTitleTag(document2);
					getTheaterPlace(document2);
					
//					for(String key : theaterCodeNTitle.keySet()) {
//						String value = (String) theaterCodeNTitle.get(key);
//						System.out.println(key + " : " + value);
//					}
				}
				result = getPagingHtml();
				
//				System.out.println("result2 : " + result);
			}else if(url == "http://www.playdb.co.kr/playdb/playdblist.asp?sReqMainCategory=000001" || url.equals("http://www.playdb.co.kr/playdb/playdblist.asp?sReqMainCategory=000001")){
				for(int i = 1; i <= pNum; i++) {
					String theaterListUrl = "http://www.playdb.co.kr/playdb/playdblist.asp?Page=" + i + "&sReqMainCategory=000001&sReqSubCategory=&sReqDistrict=&sReqTab=2&sPlayType=2&sStartYear=&sSelectType=";
//					System.out.println(theaterListUrl);
					
					Connection conn2 = Jsoup.connect(theaterListUrl.trim());
					Document document2 = conn2.get();
//					System.out.println(document2.baseUri());
					
					getTheaterImgTag(document2);
					getTheaterTitleTag(document2);
					getTheaterPlace(document2);
					
//					for(String key : theaterCodeNTitle.keySet()) {
//						String value = (String) theaterCodeNTitle.get(key);
//						System.out.println(key + " : " + value);
//					}
				}
				result = getPagingHtml();
				
//				System.out.println("result3 : " + result);
			}else if(url == "http://www.playdb.co.kr/playdb/playdblist.asp?sReqMainCategory=000003&sReqSubCategory=&sReqDistrict=&sReqTab=2&sPlayType=2&sStartYear=&sSelectType=1" || url.equals("http://www.playdb.co.kr/playdb/playdblist.asp?sReqMainCategory=000003&sReqSubCategory=&sReqDistrict=&sReqTab=2&sPlayType=2&sStartYear=&sSelectType=1")){
				for(int i = 1; i <= pNum; i++) {
					String theaterListUrl = "http://www.playdb.co.kr/playdb/playdblist.asp?Page=" + i + "&sReqMainCategory=000003&sReqSubCategory=&sReqDistrict=&sReqTab=2&sPlayType=2&sStartYear=&sSelectType=";
					
					Connection conn2 = Jsoup.connect(theaterListUrl.trim());
					Document document2 = conn2.get();
					
					getTheaterImgTag(document2);
					getTheaterTitleTag(document2);
					getTheaterPlace(document2);
				}
//				for(String key : theaterCodeNTitle.keySet()) {
//					String value = (String) theaterCodeNTitle.get(key);
//					System.out.println(key + " : " + value);
//				}
				result = getPagingHtml();
				
			}else if(url == "http://www.playdb.co.kr/playdb/playdblist.asp?sReqMainCategory=000004" || url.equals("http://www.playdb.co.kr/playdb/playdblist.asp?sReqMainCategory=000004")){
				for(int i = 1; i <= pNum; i++) {
					String theaterListUrl = "http://www.playdb.co.kr/playdb/playdblist.asp?Page=" + i + "&sReqMainCategory=000004&sReqSubCategory=&sReqDistrict=&sReqTab=2&sPlayType=2&sStartYear=&sSelectType=";
//					System.out.println("aaa");
					
					Connection conn2 = Jsoup.connect(theaterListUrl.trim());
					Document document2 = conn2.get();
//					System.out.println(document2.baseUri());
					
					getTheaterImgTag(document2);
					getTheaterTitleTag(document2);
					getTheaterPlace(document2);
				}
//				for(String key : theaterCodeNTitle.keySet()) {
//					String value = (String) theaterCodeNTitle.get(key);
//					System.out.println(key + " : " + value);
//				}
				result = getPagingHtml();
				
			}else if(url == "http://www.playdb.co.kr/playdb/playdblist.asp?sReqMainCategory=000005" || url.equals("http://www.playdb.co.kr/playdb/playdblist.asp?sReqMainCategory=000005")){
				for(int i = 1; i <= pNum; i++) {
					String theaterListUrl = "http://www.playdb.co.kr/playdb/playdblist.asp?Page=" + i + "&sReqMainCategory=000005&sReqSubCategory=&sReqDistrict=&sReqTab=2&sPlayType=2&sStartYear=&sSelectType=";
//					System.out.println("aaa");
					
					Connection conn2 = Jsoup.connect(theaterListUrl.trim());
					Document document2 = conn2.get();
//					System.out.println(document2.baseUri());
					
					getTheaterImgTag(document2);
					getTheaterTitleTag(document2);
					getTheaterPlace(document2);
				}
//				for(String key : theaterCodeNTitle.keySet()) {
//					String value = (String) theaterCodeNTitle.get(key);
//					System.out.println(key + " : " + value);
//				}
				result = getPagingHtml();
				
			}else if(url == "http://www.playdb.co.kr/playdb/playdblist.asp?sReqMainCategory=000007" || url.equals("http://www.playdb.co.kr/playdb/playdblist.asp?sReqMainCategory=000007")){
				for(int i = 1; i <= pNum; i++) {
					String theaterListUrl = "http://www.playdb.co.kr/playdb/playdblist.asp?Page=" + i + "&sReqMainCategory=000007&sReqSubCategory=&sReqDistrict=&sReqTab=2&sPlayType=2&sStartYear=&sSelectType=";
//					System.out.println("aaa");
					
					Connection conn2 = Jsoup.connect(theaterListUrl.trim());
					Document document2 = conn2.get();
//					System.out.println(document2.baseUri());
					
					getTheaterImgTag(document2);
					getTheaterTitleTag(document2);
					getTheaterPlace(document2);
				}
				for(String key : theaterCodeNTitle.keySet()) {
					String value = (String) theaterCodeNTitle.get(key);
//					System.out.println(key + " : " + value);
				}
				result = getPagingHtml();
				
			}
			
//			System.out.println("result4 : " + result);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	
	public static String getPageNum(Document document) {
		int dancingIdx = document.baseUri().indexOf("sReqMainCategory=");
//		System.out.println("dancingIdx : " + dancingIdx);
		String dancingSub = document.baseUri().substring(dancingIdx+17, dancingIdx+23);
		Elements pnEle = null;
		StringBuilder sb = new StringBuilder();
		
//		System.out.println(dancingSub);
//		System.out.println(document.baseUri());
//		System.out.println(document.html());
		
		if(dancingSub == "000005" || dancingSub.equals("000005")) {
			pnEle = document.select("#contents > div.container1 > table > tbody > tr:nth-last-of-type(1) > td > table > tbody > tr:nth-last-of-type(1) > td");
//			for(Element element : pnEle) {
//				for(Element td : element.select("b")) {
//					sb.append(td.text());
//					System.out.println(td.text());
//					sb.append(" ");
//				}
//			}
			String classPageNum = pnEle.text();
			
			int pNumIdx = classPageNum.indexOf("/");
			String pNumSub = classPageNum.substring(pNumIdx+1, pNumIdx+2);
			sb.append(classPageNum.substring(pNumIdx+1, pNumIdx+2));
//			System.out.println(pNumSub);
		}else {
			pnEle = document.select("div.container1 > table > tbody > tr:nth-last-of-type(1) > td > table > tbody > tr:nth-last-of-type(1) > td > a:nth-last-of-type(1)");
			for(Element element : pnEle) {
				for(Element td : element.select("font")) {
//					System.out.println("td.text : " + td.text());
					sb.append(td.text());
					sb.append(" ");
				}
			}
		}
		
		
		
		return sb.toString();
	}
	
	public static void getTheaterImgTag(Document document){
//		System.out.println(document.baseUri());
		int dancingIdx = document.baseUri().indexOf("sReqMainCategory=");
		int dancingIdx2 = document.baseUri().indexOf("&sReqSubCategory");
		String dancingSub = document.baseUri().substring(dancingIdx+17, dancingIdx2);
//		System.out.println(dancingSub);
		Elements theaterImgTag;
		if(dancingSub == "000004" || dancingSub.equals("000004") || dancingSub == "000007" || dancingSub.equals("000007")) {
			theaterImgTag = document.select("#contents > div.container1 > table > tbody > tr:nth-child(9) > td > table > tbody > tr:nth-child(2n+3) > td > table > tbody > tr > td:nth-child(1) > table > tbody > tr > td:nth-child(1) > table > tbody > tr > td > div > img");
		}else {
			theaterImgTag = document.select("#contents > div.container1 > table > tbody > tr:nth-child(11) > td > table > tbody > tr:nth-child(2n+3) > td > table > tbody > tr > td:nth-child(1) > table > tbody > tr > td:nth-child(1) > table > tbody > tr > td > div > img");
		}
		
		try {
			for(int i = 0; i < theaterImgTag.size(); i++) {
				int idx = theaterImgTag.get(i).attr("onclick").indexOf("'");
				int idx2 = theaterImgTag.get(i).attr("onclick").lastIndexOf("'");
				
				String allCode = theaterImgTag.get(i).attr("onclick").substring(idx+1, idx2);
//				System.out.println(allCode);
				
				String allImgUrl = theaterImgTag.get(i).attr("src");
//				System.out.println(allImgUrl);
				
				theaterCodeNImg.put(allCode, allImgUrl);
			}
			
//			for(String key : theaterCodeNImg.keySet()) {
//	            String value = (String) theaterCodeNImg.get(key);
//	            System.out.println(key + " : " + value);
//	        }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public static void getTheaterTitleTag(Document document) {
		int dancingIdx = document.baseUri().indexOf("sReqMainCategory=");
		int dancingIdx2 = document.baseUri().indexOf("&sReqSubCategory");
		String dancingSub = document.baseUri().substring(dancingIdx+17, dancingIdx2);
		Elements theaterTitleTag;
		if(dancingSub == "000004" || dancingSub.equals("000004") || dancingSub == "000007" || dancingSub.equals("000007")) {
			theaterTitleTag = document.select("#contents > div.container1 > table > tbody > tr:nth-child(9) > td > table > tbody > tr:nth-child(2n+3) > td > table > tbody > tr > td:nth-child(1) > table > tbody > tr > td:nth-child(3) > table > tbody > tr:nth-child(1) > td > b > font");
		}else {
			theaterTitleTag = document.select("#contents > div.container1 > table > tbody > tr:nth-child(11) > td > table > tbody > tr:nth-child(2n+3) > td > table > tbody > tr > td:nth-child(1) > table > tbody > tr > td:nth-child(3) > table > tbody > tr:nth-child(1) > td > b > font");
			
		}
		try {
				for(Element element : theaterTitleTag) {
					for(Element tag : element.select("a")) {
						int idx = tag.attr("onclick").indexOf("'");
						int idx2 = tag.attr("onclick").lastIndexOf("'");
						
						String allCode = tag.attr("onclick").substring(idx+1, idx2);
//						System.out.println(allCode);
						
						String allTitle = tag.text();
						
						theaterCodeNTitle.put(allCode, allTitle);
					}
				}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void getTheaterPlace(Document document) {
		int dancingIdx = document.baseUri().indexOf("sReqMainCategory=");
		int dancingIdx2 = document.baseUri().indexOf("&sReqSubCategory");
		String dancingSub = document.baseUri().substring(dancingIdx+17, dancingIdx2);
		Elements theaterPlaceTag;
		Elements theaterCodeTag;
		if(dancingSub == "000004" || dancingSub.equals("000004") || dancingSub == "000007" || dancingSub.equals("000007")) {
			theaterPlaceTag = document.select("#contents > div.container1 > table > tbody > tr:nth-child(9) > td > table > tbody > tr:nth-child(2n+3) > td > table > tbody > tr > td:nth-child(1) > table > tbody > tr > td:nth-child(3) > table > tbody > tr:nth-child(2) > td");
			theaterCodeTag = document.select("#contents > div.container1 > table > tbody > tr:nth-child(9) > td > table > tbody > tr:nth-child(2n+3) > td > table > tbody > tr > td:nth-child(1) > table > tbody > tr > td:nth-child(3) > table > tbody > tr:nth-child(1) > td > b > font");
		}else {
			theaterPlaceTag = document.select("#contents > div.container1 > table > tbody > tr:nth-child(11) > td > table > tbody > tr:nth-child(2n+3) > td > table > tbody > tr > td:nth-child(1) > table > tbody > tr > td:nth-child(3) > table > tbody > tr:nth-child(2) > td");
			theaterCodeTag = document.select("#contents > div.container1 > table > tbody > tr:nth-child(11) > td > table > tbody > tr:nth-child(2n+3) > td > table > tbody > tr > td:nth-child(1) > table > tbody > tr > td:nth-child(3) > table > tbody > tr:nth-child(1) > td > b > font");			
		}
		try {
			codeList = new ArrayList<String>();
			for(Element element : theaterCodeTag) {
				for(Element tag : element.select("a")) {
					int idx = tag.attr("onclick").indexOf("'");
					int idx2 = tag.attr("onclick").lastIndexOf("'");
					
					String allCode = tag.attr("onclick").substring(idx+1, idx2);
					codeList.add(allCode);
				}
			}
//			System.out.println(codeList);
			
			int codeCount = 0;
			String allTitle = "";
			for(Element element : theaterPlaceTag) {
				for(Element tag : element.select("a:nth-child(3)")) {
					
					allTitle = tag.text();
//					System.out.println(allTitle);
					
				}
				theaterCodeNPlace.put(codeList.get(codeCount), allTitle);
				codeCount += 1;
				
//				System.out.println(theaterCodeNPlace);
//				System.out.println(allTitle);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static String getPagingHtml(){
		cnt = 1;
		htmlCode = "" ;
		
		htmlCode += "<div class=\"list_wrap\" style=\"margin-top: 50px;\">";
//		htmlCode += "<ul style=\"width:98%\">";
//		<a href="/detailPage?playCode=${topFiveTheaterImg.key }&imgUrl=${topFiveTheaterImg.value}&theaterTopFiveTitle=<%=topTheaterList.get(theaterImgCnt) %>">
		theaterCodeNImg.forEach((key, value) -> {
//			System.out.println(value);
			if(cnt == 0) {
				htmlCode += "<ul style=\"width:100%\">";
			}else if(cnt == theaterCodeNImg.size()+1) {
				htmlCode += "</ul>";
			}else if(cnt % 7 == 0) {
				htmlCode += "<li class=\"item item1\">";
				htmlCode += "<a href=\"/culturePlace/detailPage?playCode=" + key + "&imgUrl=" + value + "&theaterTopFiveTitle=" + theaterCodeNTitle.get(key) + "\">";
				htmlCode += "<div class=\"image\" style=\"background-image: url('" + value + "');\">사진</div>";
				htmlCode += "<p class=\"item_p\">바로가기<p>";
				htmlCode += "</a>";
				htmlCode += "<div class=\"cont\">";
				htmlCode += "<strong>" + theaterCodeNTitle.get(key) + "</strong>";
				htmlCode += "</div>";
				htmlCode += "</li>";
				htmlCode += "</ul>";
				htmlCode += "<ul style=\"width:100%\">";
			}else {
				htmlCode += "<li class=\"item item1\">";
				htmlCode += "<a href=\"/culturePlace/detailPage?playCode=" + key + "&imgUrl=" + value + "&theaterTopFiveTitle=" + theaterCodeNTitle.get(key) + "\">";
				htmlCode += "<div class=\"image\" style=\"background-image: url('" + value + "');\">사진</div>";
				htmlCode += "<p class=\"item_p\">바로가기<p>";
				htmlCode += "</a>";
				htmlCode += "<div class=\"cont\">";
				htmlCode += "<strong>" + theaterCodeNTitle.get(key) + "</strong>";
				htmlCode += "</div>";
				htmlCode += "</li>";
			}
			
			cnt++;
		});
//		htmlCode += "</ul>";
//		System.out.println(result);
		
		return htmlCode ;
	}
	
	public static void main(String[] args) {
		getTheaterAllList(null);
	}
}






































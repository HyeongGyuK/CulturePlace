package com.culture.controller.crawling.detail_crawling_theater;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Getter;
import lombok.Setter;

@Controller
public class topListDetailController {
	
	@Getter @Setter
	private static Map<String, String> detailList;
	
	@GetMapping(value = "/culturePlace/detailPage")
	public static String getDetailCraw(@RequestParam(value = "playCode", required = false) String playCode, @RequestParam(value = "imgUrl", required = false) String imgUrl, @RequestParam(value = "theaterTopFiveTitle", required = false) String theaterTopFiveTitle, Model model) {
		detailList = new HashMap<String, String>();
//		System.out.println(playCode);
//		String playCode = "22005131";
		String url = "http://www.playdb.co.kr/playdb/e_brochure_iframe.asp?PlayNo=" + playCode;
		
		Connection conn = Jsoup.connect(url);
		
		try {
			Document document = conn.get();
			
			getIntroduction(document);
			getDate(document);
			getSpectatorRating(document);
			getVisitingHour(document);
			getPlace(document);
			getImg(document, imgUrl);
			getCasting(document);
			getTitle(document, playCode, theaterTopFiveTitle);
			getAddress(document);
			
			model.addAttribute("detailList", detailList);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return "CulturePlace/Detail/main_detail";
	}
	
	public static void getIntroduction(Document document) {
		Elements introductionTag = document.select("#Content1 > table > tbody > tr:nth-child(2) > td");
//		System.out.println(document.baseUri());
		
		String introduction = introductionTag.text();
//		System.out.println(introduction);
		
		if(introduction == "" || introduction.equals("")) {
			introduction = "세부 내용 준비중";
		}
		detailList.put("introduction", introduction);
	}
	
	public static void getDate(Document document) {
		Elements dateTag = document.select("body > table > tbody > tr > td > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(3) > table > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(1) > td:nth-child(2)");
		String date = dateTag.text();
//		System.out.println(date);
		
		if(date == "" || date.equals("")) {
			date = "상영 일자 정보 준비중";
		}
		
		detailList.put("date", date);
	}
	
	public static void getSpectatorRating(Document document) {
		Elements spectatorRatingTag = document.select("body > table > tbody > tr > td > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(3) > table > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(3) > td:nth-child(2)");
		String spectatorRaging = spectatorRatingTag.text();
//		System.out.println(spectatorRaging);
		
		if(spectatorRaging == "" || spectatorRaging.equals("")) {
			spectatorRaging = "관람 등급 정보 준비중";
		}
		
		detailList.put("spectatorRating", spectatorRaging);
	}
	
	public static void getVisitingHour(Document document) {
		Elements visitingHourTag = document.select("body > table > tbody > tr > td > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(3) > table > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(4) > td:nth-child(2)");
		String visitingHour = visitingHourTag.text();
//		System.out.println(visitingHour);
		
		if(visitingHour == "" || visitingHour.equals("")) {
			visitingHour = "관람 시간 정보 준비중";
		}
		
		detailList.put("visitingHour", visitingHour);
	}
	
	public static void getPlace(Document document) {
		Elements placeTag = document.select("body > table > tbody > tr > td > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(3) > table > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(2) > td:nth-child(2)");
		String place = placeTag.text();
//		System.out.println(place);
		
		if(place == "" || place.equals("")) {
			place = "장소 정보 준비중";
		}
		
		detailList.put("place", place);
	}
	
	public static void getImg(Document document, String imgUrl) {
		Elements imgTag = document.select("body > table > tbody > tr > td > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(1) > img");
		String img = imgTag.attr("src");
//		System.out.println(img);
		
		if(img == "" || img.equals("")) {
			img = imgUrl;
		}
		
		detailList.put("img", img);
	}
	
	public static void getCasting(Document document) {
		Elements castingTag = document.select("#Content5 > table > tbody > tr:nth-child(2) > td");
		String casting = castingTag.html();
//		System.out.println(casting);
		
		if(casting == "" || casting.equals("")) {
			casting = "출연진 정보 준비중";
		}
		
		detailList.put("casting", casting);
	}
	
	public static void getTitle(Document document, String playCode, String theaterTopFiveTitle) {
		Elements titleTag = document.select("body > table > tbody > tr > td > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(3) > table > tbody > tr:nth-child(1) > td > font");
		String title = titleTag.text();
//		System.out.println(title);
		
		if(title == "" || title.equals("")) {
			title = theaterTopFiveTitle;
		}
		detailList.put("title", title);
	}
	
	public static void getAddress(Document document) {
		Elements addressTag = document.select("#Content7 > table > tbody > tr:nth-child(2) > td > table:nth-child(1) > tbody > tr:nth-child(2) > td");
		
		String address = addressTag.text();
		int addressIdx = address.indexOf(":");
		String addressSub = address.substring(addressIdx+1).trim();
		
//		System.out.println(addressSub);
		
		if(addressSub == "" || addressSub.equals("")) {
			addressSub = "주소 정보 준비중";
		}
		
		detailList.put("address", addressSub);
	}
	
	public static void main(String[] args) {
//		getDetailCraw();
	}
}




































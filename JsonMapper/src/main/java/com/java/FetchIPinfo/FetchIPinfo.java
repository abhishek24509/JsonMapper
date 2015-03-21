package com.java.FetchIPinfo;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import JsonMapper.JsonMapper.ResultO;
import JsonMapper.JsonMapper.TraceComplete;

public class FetchIPinfo {

	public static void getRoute(TraceComplete tc) {

		String descAddr = tc.getDst_addr();
		String srcAddr = tc.getSrc_addr();
		ArrayList<ResultO> ro = tc.getResult();
		String html = "";
		String[] cityar = new String[ro.size()+2];
		cityar[0]=srcAddr;
		int count=1;
		for(int i=0;i<ro.size();i++){
			cityar[count]= ro.get(i).getResult().get(0).getFrom();
			count++;
		}
		cityar[count]=descAddr;
		System.out.println(" inside getRoute cityar size "+cityar.length);
		try {
			
			for(int x=0;x<cityar.length;x++){
				
				String ip = cityar[x];
			html = "http://geoipinfo.org/?ip=" + ip;
			Document doc = Jsoup.connect(html).get();
			Elements tableElements = doc.select("table");

			Elements tableRowElements = tableElements.select(":not(thead) tr");

			for (int i = 0; i < tableRowElements.size(); i++) {
				Element row = tableRowElements.get(i);
				Elements rowItems = row.select("td");
				for (int j = 1; j < rowItems.size()&&i==4; j+=2) {
					cityar[x]=rowItems.get(j).text();
				}
			}
			}
			
			System.out.println("Source City :  "+cityar[0]+" Destination city :  "+cityar[cityar.length-1]+"  via following");
			System.out.println(" inside getRoute cityar size "+cityar.length);
			for(int i=1;i<cityar.length-1;i++){
				System.out.print(cityar[i]+" ");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}


	}    



}
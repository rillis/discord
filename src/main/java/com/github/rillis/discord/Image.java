package com.github.rillis.discord;

import org.json.JSONObject;

public class Image {
	JSONObject json = new JSONObject();
	private String url;
	
	public Image(String url) {
		this.url = url;
	}


	public JSONObject getJSON() {
		if(url != null && !url.equals("")) {
			json.put("url", url);
		}
		
		return json;
	}
}

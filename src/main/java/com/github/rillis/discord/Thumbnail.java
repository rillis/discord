package com.github.rillis.discord;

import org.json.JSONObject;

public class Thumbnail {
	JSONObject json = new JSONObject();
	private String url;
	
	public Thumbnail(String url) {
		this.url = url;
	}


	public JSONObject getJSON() {
		if(url != null && !url.equals("")) {
			json.put("url", url);
		}
		
		return json;
	}
}

package com.github.rillis.discord;

import org.json.JSONObject;

public class Footer {
	JSONObject json = new JSONObject();
	private String text;
	private String icon_url;
	
	public Footer(String text, String icon_url) {
		this.text = text;
		this.icon_url = icon_url;
	}

	public JSONObject getJSON() {
		if(text != null && !text.equals("")) {
			json.put("text", text);
		}
		
		if(icon_url != null && !icon_url.equals("")) {
			json.put("icon_url", icon_url);
		}
		
		if(json.toString().equals("{}")) {
			return null;
		}
		
		return json;
	}
}

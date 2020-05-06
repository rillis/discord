package com.github.rillis.discord;

import org.json.JSONObject;

public class Author {
	JSONObject json = new JSONObject();
	private String name;
	private String url;
	private String icon_url;
	
	public Author(String name, String url, String icon_url) {
		this.name = name;
		this.url = url;
		this.icon_url = icon_url;
	}

	public JSONObject getJSON() {
		if(name != null && !name.equals("")) {
			json.put("name", name);
		}
		if(url != null && !url.equals("")) {
			json.put("url", url);
		}
		if(icon_url != null && !icon_url.equals("")) {
			json.put("icon_url", icon_url);
		}
		return json;
	}
	
	
}

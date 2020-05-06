package com.github.rillis.discord;

import org.json.JSONObject;

public class Field {
	JSONObject json = new JSONObject();
	private String name;
	private String value;
	private boolean inline;

	public Field(String name, String value, boolean inline) {
		this.name = name;
		this.value = value;
		this.inline = inline;
	}
	public JSONObject getJSON() {
		if(name != null && !name.equals("")) {
			json.put("name", name);
		}
		if(value != null && !value.equals("")) {
			json.put("value", value);
		}
		
		if(inline) {
			json.put("inline", inline);
		}
		
		return json;
	}
}

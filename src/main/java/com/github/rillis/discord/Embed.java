package com.github.rillis.discord;

import org.json.JSONArray;
import org.json.JSONObject;

public class Embed {
	private Author author;
	private String title;
	private String url;
	private String description;
	private long color;
	private Field[] fields;
	private Thumbnail thumbnail;
	private Image image;
	private Footer footer;
	
	public Embed(Author author, String title, String url, String description, long color, Field[] fields,
			Thumbnail thumbnail, Image image, Footer footer) {
		this.author = author;
		this.title = title;
		this.url = url;
		this.description = description;
		this.color = color;
		this.fields = fields;
		this.thumbnail = thumbnail;
		this.image = image;
		this.footer = footer;
	}

	public JSONObject getJSON() {
		JSONObject json = new JSONObject();
		
		if(author != null) {
			json.put("author", author.getJSON());
		}
		if(title != null && !title.equals("")) {
			json.put("title", title);
		}
		if(url != null && !url.equals("")) {
			json.put("url", url);
		}
		if(description != null && !description.equals("")) {
			json.put("description", description);
		}
		if(color > 0) {
			json.put("color", color);
		}
		
		if(fields != null && fields.length>0) {
			JSONArray f = new JSONArray();
			
			for(Field fi : fields) {
				f.put(fi.getJSON());
			}
			
			json.put("fields", f);
		}
		
		if(thumbnail != null) {
			json.put("thumbnail", thumbnail.getJSON());
		}
		if(image != null) {
			json.put("image", image.getJSON());
		}
		if(footer != null) {
			json.put("footer", footer.getJSON());
		}
		
		return json;
	}
}

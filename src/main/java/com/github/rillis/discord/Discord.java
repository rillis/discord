package com.github.rillis.discord;

import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

public class Discord {
	private String url;
	private String avatar;
	private String username;
	
	public Discord(String webhookURL, String username, String avatar) {
		if(!webhookURL.startsWith("https://discordapp.com/api/webhooks/")) {
			throw new IllegalArgumentException();
		}
		this.url = webhookURL;
		this.username = username;
		this.avatar = avatar;
	}
	
	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void sendMessage(String content) throws MalformedURLException, IOException {
		if(content == null || content.equals("")) {
			throw new IllegalArgumentException("Content can't be null or empty.");
		}
		
		JSONObject json = new JSONObject();
		
		json.put("username", username);
		json.put("avatar_url", avatar);
		
		json.put("content", content);
		
		
		send(json.toString());
	}
	
	public void sendMessage(String content, Embed embed) throws MalformedURLException, IOException {
		if((content == null || content.equals("")) && embed == null) {
			throw new IllegalArgumentException("You must fill at least content or/and embed.");
		}
		
		JSONObject json = new JSONObject();
		
		json.put("username", username);
		json.put("avatar_url", avatar);
		
		json.put("content", content);
		
		
		JSONArray embeds = new JSONArray();
		embeds.put(embed.getJSON());
		
		json.put("embeds", embeds);
		
		
		send(json.toString());
	}
	
	public void sendMessage(String content, Embed[] embed) throws MalformedURLException, IOException {
		if((content == null || content.equals("")) && embed == null) {
			throw new IllegalArgumentException("You must fill at least content or/and embed.");
		}
		
		JSONObject json = new JSONObject();
		
		json.put("username", username);
		json.put("avatar_url", avatar);
		
		json.put("content", content);
		
		
		JSONArray embeds = new JSONArray();
		
		for(Embed emb : embed) {
			embeds.put(emb.getJSON());
		}
		
		json.put("embeds", embeds);
		
		
		send(json.toString());
	}
	
	
	private void send(String json) throws MalformedURLException, IOException {		
		
		
		URL url = new URL(this.url);
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.addRequestProperty("Content-Type", "application/json");
        connection.addRequestProperty("User-Agent", "Java-DiscordWebhook-By-Rillis");
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");

        OutputStream stream = connection.getOutputStream();
        stream.write(json.toString().getBytes());
        stream.flush();
        stream.close();

        connection.getInputStream().close();
        connection.disconnect();
	}
	
}

package com.lumbu.tradingsignalparser.pojo.child;

import java.util.List;

public class Entities {
	private List<String> hashtags;

	private List<String> symbols;

	private List<User_mentions> user_mentions;

	private List<String> urls;

	private Description description;

	public void setHashtags(List<String> hashtags) {
		this.hashtags = hashtags;
	}

	public List<String> getHashtags() {
		return this.hashtags;
	}

	public void setSymbols(List<String> symbols) {
		this.symbols = symbols;
	}

	public List<String> getSymbols() {
		return this.symbols;
	}

	public void setUser_mentions(List<User_mentions> user_mentions) {
		this.user_mentions = user_mentions;
	}

	public List<User_mentions> getUser_mentions() {
		return this.user_mentions;
	}

	public void setUrls(List<String> urls) {
		this.urls = urls;
	}

	public List<String> getUrls() {
		return this.urls;
	}

	public void setDescription(Description description) {
		this.description = description;
	}

	public Description getDescription() {
		return this.description;
	}
}

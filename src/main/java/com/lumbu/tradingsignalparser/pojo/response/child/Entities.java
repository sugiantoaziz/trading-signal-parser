package com.lumbu.tradingsignalparser.pojo.response.child;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Entities {
	private List<HashTags> hashtags;

	private List<String> symbols;

	private List<User_mentions> user_mentions;

	private List<Urls> urls;

	@JsonIgnore
	private Object url;

	private Description description;

	public void setHashtags(List<HashTags> hashtags) {
		this.hashtags = hashtags;
	}

	public List<HashTags> getHashtags() {
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

	public void setUrls(List<Urls> urls) {
		this.urls = urls;
	}

	public List<Urls> getUrls() {
		return this.urls;
	}

	@JsonIgnore
	public Object getUrl() {
		return url;
	}

	@JsonProperty
	public void setUrl(Object url) {
		this.url = url;
	}

	public void setDescription(Description description) {
		this.description = description;
	}

	public Description getDescription() {
		return this.description;
	}
}

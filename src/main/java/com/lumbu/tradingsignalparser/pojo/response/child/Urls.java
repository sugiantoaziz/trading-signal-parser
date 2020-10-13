package com.lumbu.tradingsignalparser.pojo.response.child;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Urls {
	private String url;

	@JsonProperty("expanded_url")
	private String expandedUrl;

	@JsonProperty("display_url")
	private String displayUrl;

	private ArrayList<Long> indices;

	public Urls() {
	}

	public Urls(String url, String expandedUrl, String displayUrl, ArrayList<Long> indices) {
		super();
		this.url = url;
		this.expandedUrl = expandedUrl;
		this.displayUrl = displayUrl;
		this.indices = indices;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getExpandedUrl() {
		return expandedUrl;
	}

	public void setExpandedUrl(String expandedUrl) {
		this.expandedUrl = expandedUrl;
	}

	public String getDisplayUrl() {
		return displayUrl;
	}

	public void setDisplayUrl(String displayUrl) {
		this.displayUrl = displayUrl;
	}

	public ArrayList<Long> getIndices() {
		return indices;
	}

	public void setIndices(ArrayList<Long> indices) {
		this.indices = indices;
	}

	@Override
	public String toString() {
		return "Urls [url=" + url + ", expandedUrl=" + expandedUrl + ", displayUrl=" + displayUrl + ", indices="
				+ indices + "]";
	}

}

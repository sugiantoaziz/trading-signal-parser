package com.lumbu.tradingsignalparser.pojo.response.child;

import java.util.ArrayList;

public class HashTags {
	private String text;

	private ArrayList<Long> indices;

	public HashTags() {
	}

	public HashTags(String text, ArrayList<Long> indices) {
		this.text = text;
		this.indices = indices;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public ArrayList<Long> getIndices() {
		return indices;
	}

	public void setIndices(ArrayList<Long> indices) {
		this.indices = indices;
	}

	@Override
	public String toString() {
		return "HashTags [text=" + text + ", indices=" + indices + "]";
	}

}

package com.lumbu.tradingsignalparser.pojo;

import java.io.Serializable;

import com.lumbu.tradingsignalparser.pojo.child.Entities;
import com.lumbu.tradingsignalparser.pojo.child.User;

public class TwitterMsg implements Serializable {
	private String created_at;

	private Long id;

	private String id_str;

	private String text;

	private boolean truncated;

	private Entities entities;

	private String source;

	private Long in_reply_to_status_id;

	private String in_reply_to_status_id_str;

	private Long in_reply_to_user_id;

	private String in_reply_to_user_id_str;

	private String in_reply_to_screen_name;

	private User user;

	private String geo;

	private String coordinates;

	private String place;

	private String contributors;

	private boolean is_quote_status;

	private int retweet_count;

	private int favorite_count;

	private boolean favorited;

	private boolean retweeted;

	private String lang;

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getCreated_at() {
		return this.created_at;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId_str(String id_str) {
		this.id_str = id_str;
	}

	public String getId_str() {
		return this.id_str;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return this.text;
	}

	public void setTruncated(boolean truncated) {
		this.truncated = truncated;
	}

	public boolean getTruncated() {
		return this.truncated;
	}

	public void setEntities(Entities entities) {
		this.entities = entities;
	}

	public Entities getEntities() {
		return this.entities;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSource() {
		return this.source;
	}

	public void setIn_reply_to_status_id(Long in_reply_to_status_id) {
		this.in_reply_to_status_id = in_reply_to_status_id;
	}

	public Long getIn_reply_to_status_id() {
		return this.in_reply_to_status_id;
	}

	public void setIn_reply_to_status_id_str(String in_reply_to_status_id_str) {
		this.in_reply_to_status_id_str = in_reply_to_status_id_str;
	}

	public String getIn_reply_to_status_id_str() {
		return this.in_reply_to_status_id_str;
	}

	public void setIn_reply_to_user_id(Long in_reply_to_user_id) {
		this.in_reply_to_user_id = in_reply_to_user_id;
	}

	public Long getIn_reply_to_user_id() {
		return this.in_reply_to_user_id;
	}

	public void setIn_reply_to_user_id_str(String in_reply_to_user_id_str) {
		this.in_reply_to_user_id_str = in_reply_to_user_id_str;
	}

	public String getIn_reply_to_user_id_str() {
		return this.in_reply_to_user_id_str;
	}

	public void setIn_reply_to_screen_name(String in_reply_to_screen_name) {
		this.in_reply_to_screen_name = in_reply_to_screen_name;
	}

	public String getIn_reply_to_screen_name() {
		return this.in_reply_to_screen_name;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return this.user;
	}

	public void setGeo(String geo) {
		this.geo = geo;
	}

	public String getGeo() {
		return this.geo;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}

	public String getCoordinates() {
		return this.coordinates;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getPlace() {
		return this.place;
	}

	public void setContributors(String contributors) {
		this.contributors = contributors;
	}

	public String getContributors() {
		return this.contributors;
	}

	public void setIs_quote_status(boolean is_quote_status) {
		this.is_quote_status = is_quote_status;
	}

	public boolean getIs_quote_status() {
		return this.is_quote_status;
	}

	public void setRetweet_count(int retweet_count) {
		this.retweet_count = retweet_count;
	}

	public int getRetweet_count() {
		return this.retweet_count;
	}

	public void setFavorite_count(int favorite_count) {
		this.favorite_count = favorite_count;
	}

	public int getFavorite_count() {
		return this.favorite_count;
	}

	public void setFavorited(boolean favorited) {
		this.favorited = favorited;
	}

	public boolean getFavorited() {
		return this.favorited;
	}

	public void setRetweeted(boolean retweeted) {
		this.retweeted = retweeted;
	}

	public boolean getRetweeted() {
		return this.retweeted;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getLang() {
		return this.lang;
	}
}

package com.lumbu.tradingsignalparser.pojo.response.child;

import java.util.List;

public class User_mentions {
	private String screen_name;

	private String name;

	private Long id;

	private String id_str;

	private List<Integer> indices;

    public void setScreen_name(String screen_name){
        this.screen_name = screen_name;
    }

	public String getScreen_name() {
		return this.screen_name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
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

	public void setIndices(List<Integer> indices) {
        this.indices = indices;
    }

	public List<Integer>

	getIndices(){
        return this.indices;
    }
}

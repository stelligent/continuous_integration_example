package com.beer.business.domain;

public class Beer {

	private String id;
	
	private String name;

	private String brewer;

	private String dateReceived;

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBrewer(String brewer) {
		this.brewer = brewer;

	}

	public void setDateReceived(String dateReceived) {
		this.dateReceived = dateReceived;

	}

	public String getId() {
		return id;

	}

	public String getName() {
		return name;

	}

	public String getBrewer() {
		return brewer;

	}

	public String getDateReceived() {
		return dateReceived;
	}


}

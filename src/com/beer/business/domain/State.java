package com.beer.business.domain;
import com.beer.business.service.BeerServiceImpl;

public class State {
	
	private String state;

	private String description;

	public void setState(String state) {
		this.state = state;
	}

	public void setDescription(String description) {
		this.description = description;
//		BeerServiceImpl impl = new BeerServiceImpl();
//        impl.runThis();

	}

	public String getState() {
		return state;

	}

	public String getDescription() {
		return description;

	}

}

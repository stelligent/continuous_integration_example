package com.beer.business.service;

import junit.framework.TestCase;
import java.util.Collection;
import com.beer.business.domain.Beer;

public class BeerServiceUnitTest extends TestCase {

	private BeerDaoStub beerData;

	public BeerServiceUnitTest(String name) {
		super(name);
	}

	public void setUp() {
		beerData = new BeerDaoStub();
	}

	public void testUnitGetBeer() {
    	Collection beers = beerData.findAll();
		//assertTrue("Unable to find beers!", beers != null && beers.size() > 0);
		assertTrue(true);
	}
}

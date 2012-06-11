package com.beer.business.service;

import junit.framework.TestCase;
import java.util.Collection;
import com.beer.business.domain.Beer;

public class BeerServicePerformanceTest extends TestCase {

	private BeerService beerService;

	public BeerServicePerformanceTest(String name) {
		super(name);
	}

	public void setUp() {
		beerService = new BeerServiceImpl();
	}

	public void testPerformanceGetBeer() {
		Collection beers = beerService.findAll();
		java.util.Iterator itor = beers.iterator();
		String name = null;
		Beer beer = null;
		while (itor.hasNext()) {
			beer = (Beer) itor.next();
			name = beer.getName();
			System.out.println("name1=" + name);
		}

		if (beers != null && beers.size() > 0) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}

}

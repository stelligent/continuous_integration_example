package com.beer.business.service;

import junit.framework.TestCase;
import java.util.Collection;
import com.beer.business.domain.Beer;
import com.beer.business.domain.State;

public class BeerServiceComponentTest extends TestCase {

    private BeerService beerService;

    public BeerServiceComponentTest(String name) {
        super(name);
    }

    public void setUp() {
        beerService = new BeerServiceImpl();
    }

    public void testComponentGetBeer() {
        Collection beers = beerService.findAll();            
        assertTrue(beers != null && beers.size() > 0);
    }

    public void testComponentCreateBeer() {
        Beer beer = new Beer();
        beer.setBrewer("My Brewer 11");
        beer.setName("My Ale 11");
        if (beerService.create(beer) == 0) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }
    }

	public void testGetStates() {
      Collection states = beerService.findAllStates();
      java.util.Iterator itor = states.iterator();
        String name = null;
        State state = null;
        while (itor.hasNext()) {
            state = (State) itor.next();
            name = state.getState();
            System.out.println("name1=" + name);
        }
        if (states != null && states.size() > 0) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }
	}

}

package com.beer.business.service;

import java.util.Collection;
import com.beer.business.data.BeerDao;
import com.beer.business.data.BeerDaoImpl;
import com.beer.business.domain.Beer;
import java.util.Iterator;

public class BeerServiceImpl implements BeerService {

    public Collection findAll() {
        BeerDao beerData = new BeerDaoImpl();
        Collection beers = beerData.findAll(BeerDao.ALL_BEER);
		for (Iterator it=beers.iterator(); it.hasNext(); ) {
          Beer beer = (Beer)it.next();
		  System.out.println("beer.getName()=" + beer.getName() + "beer.getBrewer()=" + beer.getBrewer());
        } 
        return beers;
    }

	public Collection findAllStates() {
        BeerDao beerData = new BeerDaoImpl();
        Collection states = beerData.findAllStates(BeerDao.ALL_STATES);
        return states;
    }

	 public int create(Beer beer) {
        BeerDao beerData = new BeerDaoImpl();
        beerData.create(BeerDao.CREATE_BEER, beer);
        return 0;
    }

	public void runThisBranch() {
		System.out.println("test");
	}

}

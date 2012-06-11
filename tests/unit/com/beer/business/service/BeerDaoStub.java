package com.beer.business.service;
import java.util.ArrayList;
import java.util.List;
import com.beer.business.domain.Beer;


public class BeerDaoStub {

    public static List FIND_ALL = createList();
    
    public List findAll() {
        return FIND_ALL;
    }

    private static ArrayList createList() {
        ArrayList list = new ArrayList();
        list.add(createBeer());
        return list;
    }

    private static Beer createBeer() {
        Beer beer = new Beer();
        beer.setBrewer("My Brewery");
		beer.setName("Random Lager");
        beer.setDateReceived("2006-08-24");        
        return beer;
    }
}

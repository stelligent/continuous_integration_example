package com.beer.business.data;

import junit.framework.TestCase;
import java.util.Collection;
import com.beer.business.domain.Beer;
import com.beer.business.domain.State;

public class BeerDaoComponentTest extends TestCase {

    private BeerDaoImpl beerData;

    public BeerDaoComponentTest(String name) {
        super(name);
    }

    public void setUp() {
        beerData = new BeerDaoImpl();
    }

    public void testGetAllStates() {
        Collection states = beerData.findAllStates(BeerDao.ALL_STATES);
        assertTrue("No states found!", states != null && states.size() > 0); 
    }

     public void testInvalidSql() {
		 Collection states = null;
		 try
		 {
			 states = beerData.findAllStates("select * from junk");
			 
		 }
		 catch (Exception e)
		 {
	       assertTrue("No states found!", states != null && states.size() > 0);
		 }   

        
    }

 
}

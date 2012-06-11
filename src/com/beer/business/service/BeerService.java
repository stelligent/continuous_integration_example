package com.beer.business.service;
import java.util.Collection;
import com.beer.business.domain.Beer;

public interface BeerService {
    
    Collection findAll();

	Collection findAllStates();

	int create(Beer beer);

 
    

}

package com.beer.business.data;

import java.util.Collection;
import com.beer.business.domain.Beer;

public interface BeerDao {

    String ALL_BEER = "SELECT * from beer ";
	String ALL_STATES = "SELECT * from state ";
    String CREATE_BEER = "INSERT INTO beer(id, beer_name, brewer, date_received) VALUES(?,?,?,'2006-08-20');  ";

    Collection findAll(String sql);

	Collection findAllStates(String sql);

    int create(String sql, Beer beer);

}

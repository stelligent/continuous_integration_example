package com.beer.business.data;

import java.sql.Connection;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Random;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.beer.business.domain.Beer;
import com.beer.business.domain.State;
import com.beer.common.BaseDao;
import com.beer.common.Constants;
//import com.beer.business.service.BeerServiceImpl;

public class BeerDaoImpl extends BaseDao implements BeerDao {

    public BeerDaoImpl() {
		//BeerServiceImpl impl = new BeerServiceImpl();
		//impl.runThis();
    }

    public Collection findAll(String sql) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Collection results = new ArrayList();
        try {
            conn = this.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Beer beer = new Beer();
                beer.setName(rs.getString("beer_name"));
                beer.setBrewer(rs.getString("brewer"));
                beer.setDateReceived(rs.getString("date_received"));
                results.add(beer);
            }

        } catch (SQLException se) {
            throw new RuntimeException(se);
        } finally {
            closeDbConnection(rs, stmt, conn);
        }
        return results;
    }

	    public Collection findAllStates(String sql) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Collection states = new ArrayList();
        try {
            conn = this.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                State state = new State();
                state.setState(rs.getString("state"));
                state.setDescription(rs.getString("description"));
                states.add(state);
            }

        } catch (SQLException se) {
           se.printStackTrace();
        } finally {
            closeDbConnection(rs, stmt, conn);
        }
        return states;
    }

    public int create(String sql, Beer beer) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        System.out.println("beer.getName()=" + beer.getName());
        System.out.println("beer.getBrewer()=" + beer.getBrewer());
        Random generator = new Random();
        int r = generator.nextInt();
        String s = Integer.toString(r);
        try {
            conn = this.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, s);
            stmt.setString(2, beer.getName());
            stmt.setString(3, beer.getBrewer());
            stmt.executeUpdate();
            conn.commit();
        } catch (SQLException se) {
            throw new RuntimeException(se);
        } finally {
            closeDbConnection(rs, stmt, conn);
        }
        return 0;
    }

}

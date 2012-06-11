package com.beer.business.service;
import com.clarkware.junitperf.*;
import junit.framework.Test;

public class ExampleTimedTest {

    private static final String TEST_PERFORMANCE_GET_BEER = "testPerformanceGetBeer";

    public static Test suite() {
        
        long maxElapsedTime = 300;
        
        Test testCase = new BeerServicePerformanceTest(TEST_PERFORMANCE_GET_BEER);
        Test timedTest = new TimedTest(testCase, maxElapsedTime);
        
        return timedTest;
    }
    
    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }
}
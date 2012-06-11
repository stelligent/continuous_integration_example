package com.beer.business.service;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import junit.framework.TestCase;

public class RegularExpressionTest extends TestCase {
	
 private String zipRegEx = "^\\d{5}([\\-]\\d{4})?$";
 private Pattern pattern;

 protected void setUp() throws Exception {
   this.pattern = Pattern.compile(this.zipRegEx);
 }

 public void testZipCode() throws Exception {		 
   Matcher mtcher = this.pattern.matcher("22101");
   boolean isValid = mtcher.matches();		
   assertTrue("Pattern did not validate zip code", isValid);
 }
}
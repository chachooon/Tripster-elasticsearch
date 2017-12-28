package com.tripster.elasticsearch;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.test.ESIntegTestCase;
import org.elasticsearch.test.ESTestCase;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MyTest extends ESTestCase{
	
	private static final Logger logger = LogManager.getLogger(MyTest.class);	


	private Client client;

	// DataBase 이름지정 
	public String getIndexName() {
		return "test";
	}
	// Table 이름지정 
	public String getTypeName() {
		return "data";
	}	
	
	
	
}

package com.tripster.elasticsearch;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.Client;

public class EsConnectionTest {

	private Client client;
	@Autowired
    public EsConnectionTest(Client client) {
        this.client = client;
    }
	@Test
	public void testFactory() {
		
		GetResponse response = client.prepareGet("_cat","master","v").get();
		System.out.println(response.getSourceAsString());
		
		
	}
	
	
}

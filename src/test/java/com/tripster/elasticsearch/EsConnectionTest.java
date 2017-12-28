package com.tripster.elasticsearch;

import org.junit.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequestBuilder;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingRequestBuilder;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.node.Node;

import static org.elasticsearch.common.xcontent.XContentFactory.*;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class test {
	
	private static final Logger logger = LogManager.getLogger(test.class);	

	private Settings settings;
	private Client client;

	// DataBase 이름지정 
	public String getIndexName() {
		return "test";
	}
	// Table 이름지정 
	public String getTypeName() {
		return "data";
	}	
	
	@Before
	public void setup() throws Exception {
		settings = Settings.builder()
                .put("cluster.name",  "elasticsearch").build();

		TransportClient client = new PreBuiltTransportClient(settings)
				.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
	}
	
	
	

	
	@Test // DataBase 생성
	public void createIndexTest() {
        CreateIndexResponse r = client.admin().indices().prepareCreate(getIndexName()).execute().actionGet();

        if (r.isAcknowledged() == true) {
            System.out.println("Create Index : " + getIndexName());
        }		
	}
//	
//	@Test 
//    public void createIndexSettings() throws IOException {
//        XContentBuilder settingBuilder =
//                jsonBuilder()
//                        .startObject()
//                        .startObject("index")
//                        .startObject("analysis")
//                        .startObject("analyzer")
//                        .startObject("low_analyzer")
//                        .field("type", "custom")
//                        .array("char_filter", "html_strip")
//                        .array("filter", "lowercase", "asciifolding")
//                        .field("tokenizer", "standard")
//                        .endObject()
//                        .startObject("upper_analyzer")
//                        .field("type", "custom")
//                        .array("char_filter", "html_strip")
//                        .array("filter", "uppercase", "asciifolding")
//                        .field("tokenizer", "standard")
//                        .endObject()
//                        .endObject()
//                        .endObject()
//                        .endObject()
//                        .endObject();
//
//        XContentBuilder mappingBuilder =
//                jsonBuilder()
//                        .startObject()
//                        .startObject(getTypeName())
//                        .startObject("properties")
//                        .startObject("name")
//                        .field("type", "string")
//                        .field("analyzer", "low_analyzer")
//                        .endObject()
//                        .startObject("age")
//                        .field("type", "string")
//                        .field("index", "not_analyzed")
//                        .endObject()
//                        .startObject("memo")
//                        .field("type", "string")
//                        .field("analyzer", "upper_analyzer")
//                        .endObject()
//                        .endObject()
//                        .endObject()
//                        .endObject();
//
//        System.out.println(settingBuilder.string());
//        System.out.println(mappingBuilder.string());
//        final CreateIndexRequestBuilder createIndexRequestBuilder = client.admin().indices().prepareCreate(getIndexName());
//
//        createIndexRequestBuilder.setSettings(settingBuilder);
//        createIndexRequestBuilder.addMapping(getTypeName(), mappingBuilder);
//
//        // MAPPING DONE
//        CreateIndexResponse r = createIndexRequestBuilder.execute().actionGet();
//
//        if (r.isAcknowledged() == true) {
//            System.out.println("Create Index : " + getIndexName());
//        }
//    }
//	
//	@Test
//    public void addMapping() throws IOException {
//
//        XContentBuilder mappingBuilder =
//                jsonBuilder()
//                        .startObject()
//                        .startObject(getTypeName())
//                        .startObject("properties")
//                        .startObject("studio")
//                        .field("type", "string")
//                        .field("index", "not_analyzed")     /// 입력값이 배열인 경우 반드시 *not_analyzed* 로 매핑되어야 함.
//                        .endObject()
//                        .endObject()
//                        .endObject()
//                        .endObject();
//
//        System.out.println(mappingBuilder.string());
//
//        PutMappingRequestBuilder putMappingRequestBuilder = client.admin().indices().preparePutMapping(getIndexName())
//                .setType(getTypeName()).setSource(mappingBuilder);
//
//        PutMappingResponse putMappingResponse = putMappingRequestBuilder.execute().actionGet();
//
//        if (putMappingResponse.isAcknowledged() == true) {
//            System.out.println("Put Mapping : ");
//        }
//    }
	@After
	public void tearDown() throws Exception {
		client.close();
	}	
	
}

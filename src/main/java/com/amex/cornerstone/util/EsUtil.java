package com.amex.cornerstone.util;
import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.node.Node;
import org.elasticsearch.search.SearchHit;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amex.cornerstone.model.Student;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EsUtil {
	
	@Autowired
	private Student student;
	
	
	//private String index="amex";
	//private String type="student";
	private String index = "";
	private String type= "";
	public Client getEsConnection(){
		
		String clName = System.getProperty("cluster.name");
		index = System.getProperty("index.name").toString();
		type= System.getProperty("type.name").toString();
		System.out.println("Cluseter name " + clName);
		System.out.println("Index name " + index);
		System.out.println("Type name " + type);
		//to run it locally
		Client client;
		Node node = nodeBuilder().clusterName(clName).node();
		client = node.client();
		
		/**
		 * to run it remotely
		 */
		/* Client client = new TransportClient()
        .addTransportAddress(new InetSocketTransportAddress("127.0.0.1", 9300));
       */

			// on shutdown

			//client.close();
		 
		return client;
	}
	
	public  void insertInES(Client client,JSONObject obj,String id){
		
	
		//System.out.println(obj);
		IndexResponse response = client.prepareIndex(index, type, id)
		        .setSource(obj)
		        .execute()
		        .actionGet();
	}
	
	public BulkResponse insertInEsBulk(Client client,String jsonString) throws JsonParseException, JsonMappingException, IOException{
			
		  
		  /*JSONObject obj = new JSONObject();
			//{"id":1,"name":"himanga","dept":"BIDS2"}
			//obj.put("id", 2).put("name", "raja").put("dept","BIDS2");
			obj.put("id", employeeBody.getId());
			obj.put("name",employeeBody.getName());
			obj.put("dept",employeeBody.getDept());*/

		List<Student> studentList = new ArrayList<Student>();

		ObjectMapper mapper = new ObjectMapper();

		JsonNode rootNode = mapper.readTree(jsonString);

		// JsonNode columnDetails = new JsonNode();

		TypeReference<List<Student>> typeRef = new TypeReference<List<Student>>() {
		};
		studentList = mapper.readValue(rootNode.traverse(), typeRef);

		BulkRequestBuilder bulkRequest = client.prepareBulk();

		for (Student e : studentList) {
			// postHttpMethod(httpClient,e,id);
			System.out.println(e.getId());

			// esUtil.insertInEsBulk(client,e.toString(),e.getId());

			// String tmp=new String(id);
			String tmp = "" + e.getId();
			// either use client#prepare, or use Requests# to directly build
			// index/delete requests
			bulkRequest.add(client.prepareIndex(index, type, tmp).setSource(
					e.toString()));

		}

		BulkResponse bulkResponse = bulkRequest.execute().actionGet();
		if (bulkResponse.hasFailures()) {
			System.out.println("Errror on BULK insert!!!!");
		}

		return bulkResponse;

		/*
		 * BulkRequestBuilder bulkRequest = client.prepareBulk();
		 * 
		 * //String tmp=new String(id); String tmp=""+id; // either use
		 * client#prepare, or use Requests# to directly build index/delete
		 * requests bulkRequest.add(client.prepareIndex(index, type, tmp)
		 * .setSource(jsonString) );
		 */
	
	}
	
	//currently working on it 
	  public  List<Object> readFrmES(Client client,String field,String value){
		  JSONObject obj = new JSONObject();
		  
		  List<Object> tmp=new ArrayList<Object>();
		SearchResponse response = client.prepareSearch(index)
                .setTypes(type)
                .setSearchType(SearchType.QUERY_AND_FETCH)
                //.setQuery(QueryBuilders.termQuery(field, value))
                .setFrom(0).setSize(60).setExplain(true)
                .execute()
                .actionGet();
		SearchHit[] results = response.getHits().getHits();
		//response.getHits().getHits();
		for (SearchHit hit : results) {
            System.out.println("------------------------------");
            Map<String,Object> result = hit.getSource();   
           System.out.println(result);
             // em =(Employee) hit.getSource() ;
              tmp.add(result);
             //Map<String,Object> result_mp=hit.getSource() ;
            //obj.putAll(result);
            //em.setEmployeeList(em1);
            
        }
		
		return tmp;
	}
	
	/*public static void main(String args[]){
		insertInES();
		
	}*/
}

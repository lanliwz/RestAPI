package com.elasticsearch;
import java.util.Map;

import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.node.Node;


import org.elasticsearch.search.SearchHit;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.ibatis.Employee;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

@Service
public class EsUtil {
	private String index="amex_test";
	private String type="employee";
	public Client getEsConnection(){
		
		//to run it locally
		Client client;
		Node node = nodeBuilder().clusterName("elastic_search").node();
		client = node.client();
		
		/**
		 * to run it remotely
		 * Client client = new TransportClient()
        .addTransportAddress(new InetSocketTransportAddress("host1", 9300))
        .addTransportAddress(new InetSocketTransportAddress("host2", 9300));

			// on shutdown

			client.close();
		 */
		return client;
	}
	
	public  void insertInES(Client client,JSONObject obj,String id){
		
	
		//System.out.println(obj);
		IndexResponse response = client.prepareIndex(index, type, id)
		        .setSource(obj)
		        .execute()
		        .actionGet();
	}
	
	
	/*currently working on it 
	 * public  String readFrmES(Client client,String field,String value){
		
		SearchResponse response = client.prepareSearch(index)
                .setTypes(type)
                .setSearchType(SearchType.QUERY_AND_FETCH)
                .setQuery(QueryBuilders.termQuery(field, value))
                .setFrom(0).setSize(60).setExplain(true)
                .execute()
                .actionGet();
		SearchHit[] results = response.getHits().getHits();
		
		for (SearchHit hit : results) {
            System.out.println("------------------------------");
            Map<String,Object> result = hit.getSource();   
            System.out.println(result);
        }
		
		return results;
	}*/
	
	/*public static void main(String args[]){
		insertInES();
		
	}*/
}

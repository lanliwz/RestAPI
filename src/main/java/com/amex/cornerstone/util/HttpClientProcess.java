package com.amex.cornerstone.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.stereotype.Service;

import com.amex.cornerstone.model.Student;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class HttpClientProcess {

	/*public static void main(String[] args) {
		int id=2;
		 processGetToPostRequest(id);
	}*/
	
	String esUrl = System.getProperty("esurl");
	
	
	public  List<Student> processMysqlToEsInBulk() {
		System.out.println("The esurl is" + esUrl);
		//Employee em=null;
		DefaultHttpClient httpClient = new DefaultHttpClient();
		BufferedReader br=getHttpMethodInBulk(httpClient);
		
		//postHttpMethod(httpClient,em); BufferedReader getHttpMethodInBulk(DefaultHttpClient httpClient)
		
		List<Student> EmployeeList = new ArrayList<Student>();

        ObjectMapper mapper = new ObjectMapper();
		
		String output;
		System.out.println("Output from Server ....get \n");
		try {
			while ((output = br.readLine()) != null) {
				System.out.println("output is " + output );
				postHttpMethodInBulk(httpClient,output);
				
				
				/*System.out.println("--------------------");
				System.out.println(output);
				
				//List<Employee> tmp=CollectionUtil.output
				
				
				//System.out.println(tmp.get(0));
				JsonNode rootNode = mapper.readTree(output);

			     //JsonNode columnDetails = new JsonNode();
				
				
				TypeReference<List<Employee>> typeRef = new TypeReference<List<Employee>>() {
			  };
			  EmployeeList = mapper.readValue(rootNode.traverse(), typeRef);
			  
			  for (Employee e: EmployeeList){
				  postHttpMethod(httpClient,e,id);
			  	System.out.println(e.getId());
			  	
			  }*/
			}
			//return EmployeeList;
		} catch (JsonParseException e) {
			
			e.printStackTrace();
		} catch (JsonMappingException e) {
			
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return EmployeeList;
	}
	
	
	
	

	private void postHttpMethodInBulk(DefaultHttpClient httpClient,
			String jsonInput) {

		try {
			 
			
			
		  System.out.println("2");
		 
		  
			//DefaultHttpClient httpClient = new DefaultHttpClient();
			//String postUrl="http://localhost:8080/SwaggerBackendCode/students/postRecordInEsBulk";
			
			String postUrl= esUrl +"/students/postRecordInEsBulk";
			HttpPost postRequest = new HttpPost(
					postUrl);
			 System.out.println("3"); 
			//StringEntity input = new StringEntity("{\"qty\":100,\"name\":\"iPad 4\"}");
			StringEntity input = new StringEntity(jsonInput);
			
			//System.out.println("json string : "+em.toString());
			input.setContentType("application/json");
			postRequest.setEntity(input);
	 
			 System.out.println("4");
			HttpResponse response = httpClient.execute(postRequest);
	 
			if (response.getStatusLine().getStatusCode() != 201 && response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatusLine().getStatusCode());
			}
	 
			BufferedReader br = new BufferedReader(
	                        new InputStreamReader((response.getEntity().getContent())));
	 
			String output;
			System.out.println("Output from Server ....post \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
	 
			httpClient.getConnectionManager().shutdown();
			
	 
		  } catch (MalformedURLException e) {
	 
			e.printStackTrace();
	 
		  } catch (IOException e) {
	 
			e.printStackTrace();
	 
		  }
		
	
		
	}





	public  List<Student> processGetToPostRequest(String id) {
		//Employee em=null;
		DefaultHttpClient httpClient = new DefaultHttpClient();
		BufferedReader br=getHttpMethod(httpClient,id);
		
		//postHttpMethod(httpClient,em);
		
		List<Student> studentList = new ArrayList<Student>();

        ObjectMapper mapper = new ObjectMapper();
		
		String output;
		System.out.println("Output from Server ....get \n");
		try {
			while ((output = br.readLine()) != null) {
				System.out.println("--------------------");
				System.out.println(output);
				
				//List<Employee> tmp=CollectionUtil.output
				
				
				//System.out.println(tmp.get(0));
				JsonNode rootNode = mapper.readTree(output);

			     //JsonNode columnDetails = new JsonNode();
				
				
				TypeReference<List<Student>> typeRef = new TypeReference<List<Student>>() {
			  };
			  studentList = mapper.readValue(rootNode.traverse(), typeRef);
			  
			  for (Student e: studentList){
				  postHttpMethod(httpClient,e,id);
			  	System.out.println(e.getId());
			  	
			  }
			}
			//return EmployeeList;
		} catch (JsonParseException e) {
			
			e.printStackTrace();
		} catch (JsonMappingException e) {
			
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return studentList;
	}

	public  void postHttpMethod(DefaultHttpClient httpClient, Student em,String postId) {
		try {
			 
			//DefaultHttpClient httpClient = new DefaultHttpClient();
			//String postUrl="http://localhost:8080/SwaggerBackendCode/students/postRecordInES/"+postId;
			String postUrl= esUrl +"/students/postRecordInES/"+postId;
			
			HttpPost postRequest = new HttpPost(
					postUrl);
	 
			//StringEntity input = new StringEntity("{\"qty\":100,\"name\":\"iPad 4\"}");
			StringEntity input = new StringEntity(em.toString());
			
			System.out.println("json string : "+em.toString());
			input.setContentType("application/json");
			postRequest.setEntity(input);
	 
			HttpResponse response = httpClient.execute(postRequest);
	 
			if (response.getStatusLine().getStatusCode() != 201 && response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatusLine().getStatusCode());
			}
	 
			BufferedReader br = new BufferedReader(
	                        new InputStreamReader((response.getEntity().getContent())));
	 
			String output;
			System.out.println("Output from Server ....post \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
	 
			httpClient.getConnectionManager().shutdown();
			
	 
		  } catch (MalformedURLException e) {
	 
			e.printStackTrace();
	 
		  } catch (IOException e) {
	 
			e.printStackTrace();
	 
		  }
		
	 
		
	}

	public  BufferedReader getHttpMethod(DefaultHttpClient httpClient,String getId) {
		try {
	 
			//String getUrl="http://localhost:8080/SwaggerBackendCode/students/getRecordFrmMysqlById/"+getId;
			
			String getUrl= esUrl + "/students/getRecordFrmMysqlById/"+getId;
			
			HttpGet getRequest = new HttpGet(
					getUrl);
			getRequest.addHeader("accept", "application/json");
	 
			HttpResponse response = httpClient.execute(getRequest);
	 
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
				   + response.getStatusLine().getStatusCode());
			}
	 
			BufferedReader br = new BufferedReader(
	                         new InputStreamReader((response.getEntity().getContent())));
	 
			
			 
	 
			//httpClient.getConnectionManager().shutdown();
			return br;
	 
		  } catch (ClientProtocolException e) {
	 
			e.printStackTrace();
	 
		  } catch (IOException e) {
	 
			e.printStackTrace();
		  }
		return null;
		
	}

	public  BufferedReader getHttpMethodInBulk(DefaultHttpClient httpClient) {
		try {
	 
			//String getUrl="http://localhost:8080/SwaggerBackendCode/students/getAllRecordFrmMysql";
			String getUrl= esUrl + "/students/getAllRecordFrmMysql";
			
			HttpGet getRequest = new HttpGet(
					getUrl);
			getRequest.addHeader("accept", "application/json");
	 
			HttpResponse response = httpClient.execute(getRequest);
	 
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
				   + response.getStatusLine().getStatusCode());
			}
	 
			BufferedReader br = new BufferedReader(
	                         new InputStreamReader((response.getEntity().getContent())));
	 
			
			 
	 
			//httpClient.getConnectionManager().shutdown();
			return br;
	 
		  } catch (ClientProtocolException e) {
	 
			e.printStackTrace();
	 
		  } catch (IOException e) {
	 
			e.printStackTrace();
		  }
		return null;
		
	}
	
	
	
}

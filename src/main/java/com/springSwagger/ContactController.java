package com.springSwagger;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import org.elasticsearch.client.Client;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.elasticsearch.EsUtil;
import com.ibatis.Employee;
import com.ibatis.IbatisInsert;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.wordnik.swagger.annotations.Api;

@Api(value = "contacts", description = "contacts") // Swagger annotation
@Controller
@RequestMapping("/contacts")
public class ContactController {
	@Autowired 
	ContactService contactService;
	
	@Autowired 
	IbatisInsert ibatisInsert;
	
	@Autowired
	private static Employee employee;
	
	//EsUtil
	@Autowired 
	EsUtil esUtil;
	
	
	  @ResponseBody
	  @RequestMapping(value="/getcontacts",method=RequestMethod.GET)
	  public Collection<Contact> select() {
	    return contactService.select();
	  }
	 
	  @ResponseBody
	  @RequestMapping(value="/{id}",method=RequestMethod.GET)
	  public Contact get(@PathVariable Long id) {
	    return contactService.get(id);
	  }
	  
	  @ResponseBody
	  @RequestMapping(value="/getRecordFrmMysql",method=RequestMethod.GET)
	  public Employee getAllRecord() {
		  SqlMapClient smc = null;
		  
		  
	    try {
	    	smc = ibatisInsert.getMysqlMapClient();
			return IbatisInsert.readMysql(smc);
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return null;
	  }
	  
	 /* currently working on it 
	  * @ResponseBody
	  @RequestMapping(value="/getRecordFromES/{filedName}/{value}",method=RequestMethod.GET)
	  public String getRecordFromES(@PathVariable String filedName,@PathVariable String value) {
		  Client client=esUtil.getEsConnection();
		  String results=esUtil.readFrmES(client,filedName,value);
		  
	    
		return results;
	  }*/
	  
	 
	  
	  @RequestMapping(value = "/putRecordInMysql", method = RequestMethod.PUT,consumes="application/json",produces="application/json")
	  @ResponseBody
	    public Employee putRecordInMysql(@RequestBody Employee employeeBody) {
	        
		  
		  SqlMapClient smc = null;
		  
	
		  
		    try {
		    	smc = ibatisInsert.getMysqlMapClient();
		    	ibatisInsert.insertIntoMysql(smc,employeeBody);
			} catch (SQLException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			return employeeBody;
		  
		  
	    }
	  
	  
	  @RequestMapping(value = "/putRecordInES/{id}", method = RequestMethod.PUT,consumes="application/json",produces="application/json")
	  @ResponseBody
	    public Employee putRecordInES(@PathVariable String id,@RequestBody Employee employeeBody) {
		  
		  Client client=esUtil.getEsConnection();
		  
		  JSONObject obj = new JSONObject();
			//{"id":1,"name":"himanga","dept":"BIDS2"}
			//obj.put("id", 2).put("name", "raja").put("dept","BIDS2");
			obj.put("id", employeeBody.getId());
			obj.put("name",employeeBody.getName());
			obj.put("dept",employeeBody.getDept());
			
		  esUtil.insertInES(client,obj,id);
		  
			return employeeBody;
		  
	  }
	  
	 
	  
	
	  
	@RequestMapping(value="/postdata",method=RequestMethod.POST,consumes="application/json",produces="application/json")  
	@ResponseBody  
	public Employee postData(@RequestBody Employee emp)
	{
		//sample one for future use
		return emp;
	}
	 
	
}

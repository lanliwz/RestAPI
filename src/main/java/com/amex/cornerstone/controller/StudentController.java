package com.amex.cornerstone.controller;

import java.io.IOException;
import java.util.List;

import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.client.Client;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amex.cornerstone.model.Student;
import com.amex.cornerstone.service.StudentService;
import com.amex.cornerstone.util.EsUtil;
import com.amex.cornerstone.util.HttpClientProcess;
import com.amex.cornerstone.vo.Register;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wordnik.swagger.annotations.Api;





@Api(value = "students", description = "students") // Swagger annotation
@Controller
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private EsUtil esUtil;
	
	@Autowired
	private HttpClientProcess httpClientProcess;
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signup(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "signup";
	}
	
	 @ResponseBody
	 @RequestMapping(value="/{userName}",method=RequestMethod.GET)
	 public Student get(@PathVariable String userName) throws Exception {
		  
	    return studentService.getStudent(userName);
	  }
	 
	 
	 @RequestMapping(value = "/putRecordInMysql", method = RequestMethod.PUT,consumes="application/json",produces="application/json")
	 @ResponseBody
	 public Student putRecordInMysql(@RequestBody Student student) {	        
		 		  
		    studentService.insertStudent(student);
			return student;
		  
	  }
	 
	 
	 
	  @ResponseBody
	  @RequestMapping(value="/getAllRecordsFromES",method=RequestMethod.GET)
	  public  List<Object> getAllRecordsFromES() {
		  String fieldname="";
		  String value="";
		  
		  Client client=esUtil.getEsConnection();
		  //JSONObject results=esUtil.readFrmES(client,fieldname,value);
		  /*JSONObject obj = new JSONObject();
		  obj.put(results.getHits().getHits().);*/
		return esUtil.readFrmES(client,fieldname,value);
	  }
	  
	  
	  @RequestMapping(value = "/postRecordInES/{id}", method = RequestMethod.POST,consumes="application/json",produces="application/json")
	  @ResponseBody
	    public Student postRecordInES(@PathVariable String id,@RequestBody Student studentBody) {
		  
		  Client client=esUtil.getEsConnection();
		  
		  JSONObject obj = new JSONObject();
			//{"id":1,"name":"himanga","dept":"BIDS2"}
			//obj.put("id", 2).put("name", "raja").put("dept","BIDS2");
				obj.put("id", studentBody.getId());
				obj.put("emailAddress",studentBody.getEmailAddress());
				obj.put("firstName",studentBody.getFirstName());
				obj.put("lastName",studentBody.getLastName());
				obj.put("userName",studentBody.getUserName());
				obj.put("password",studentBody.getPassword());
				
				esUtil.insertInES(client,obj,id);
			  
				return studentBody;
		  
	  }
	  
	  
	  @RequestMapping(value="/postFromMysqlToEsInBulk",method=RequestMethod.POST,consumes="application/json",produces="application/json")  
		@ResponseBody  
		public List<Student> postFromMysqlToEsInBulk()
		{
			List<Student> studentList=httpClientProcess.processMysqlToEsInBulk();
			
			//List<Employee> processMysqlToEsInBulk()
			return studentList;
		}
	  
	  
	  @RequestMapping(value = "/postRecordInEsBulk", method = RequestMethod.POST,consumes="application/json",produces="application/json")
	  @ResponseBody
	    public BulkResponse postRecordInEsBulk(@RequestBody String jsonString) {
		  
		  Client client=esUtil.getEsConnection();
			
		  BulkResponse bulkResponse;
		try {
			bulkResponse = esUtil.insertInEsBulk(client,jsonString);
			return bulkResponse;
		} catch (JsonParseException e) {
			
			e.printStackTrace();
		} catch (JsonMappingException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return null;	  
			
		  
	  }
	  
	  
	  @ResponseBody
	  @RequestMapping(value="/getAllRecordFrmMysql",method=RequestMethod.GET)
	  public List <Student> getAllRecordFrmMysql() {	    	
			return studentService.getAllStudents();
	  }
	  
	  
	  @RequestMapping(value = "/register", method = RequestMethod.POST,consumes="application/json",produces="application/json")
	  @ResponseBody
	    public void register(@PathVariable String id,@RequestBody Student studentBody) {
		  
		  ObjectMapper mapper = new ObjectMapper(); 
		 
		  Student student = new Student();
		  //mapper.writeValue(new File("article.json"), student);
		  //mapper.writeValue(arg0, arg1);
		  System.out.println("json created!");
		  
		 
		  //mapper.writeValue(arg0, arg1);
		  
	  }
	  
	  
	  @RequestMapping(value = "/register", method = RequestMethod.PUT,consumes="application/json",produces="application/json")
	  @ResponseBody
	  public String SamplePut(@RequestBody Register register) {
	        
			System.out.println(register.toString());
			studentService.InsertRegisterInfo(register);
			return register.toString();
		  
		  
	    }
	  
	  
	  
	  
		
	
}

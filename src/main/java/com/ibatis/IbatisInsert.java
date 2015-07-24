package com.ibatis;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

@Service
public class IbatisInsert {
	
	@Autowired
	private  Employee employee;

	/*public static void main(String[] args) throws IOException, SQLException {
		 Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
	      SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);

	       This would insert one record in Employee table. 
	      System.out.println("Going to insert record.....");
	      Employee em = new Employee(1111, "ravi", "HR");

	      smc.insert("Employee.insert", em);

	      System.out.println("Record Inserted Successfully ");
	      
	      
	      ////////////////////////////////////////////
	      
	      
	       //This would read all records from the Employee table. 
	      readMysql(smc);
	      

	}*/

	public static Employee readMysql(SqlMapClient smc) throws SQLException, IOException {
		
		 //SqlMapClient smc = getMysqMaplClient();
		System.out.println("Going to read records.....");
	      List <Employee> ems = (List<Employee>)
	         smc.queryForList("Employee.getAll", null);
	      Employee em = null;
			
	      for (Employee e : ems) {
	         System.out.print("  " + e.getId());
	         System.out.print("  " + e.getName());
	         System.out.print("  " + e.getDept());
	         //System.out.print("  " + e.getSalary());
	         em = e; 
	         System.out.println("");
	         //return em;
	      }    
			
	      System.out.println("Records Read Successfully ");
		return em;
	}

	public static SqlMapClient getMysqlMapClient() throws IOException {
		Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
	      SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);
		return smc;
	}
	
	public  void insertIntoMysql(SqlMapClient smc,Employee employee) throws IOException, SQLException{
		//SqlMapClient smc = getMysqMaplClient();

	       //This would insert one record in Employee table. 
	      System.out.println("Going to insert record.....");
	      //Employee em = new Employee(1111, "ravi", "HR");
	      
	      //employee.setEmployee(4, "pankaj", "BIDS2");

	      smc.insert("Employee.insert", employee);

	      System.out.println("Record Inserted Successfully ");
	}

}

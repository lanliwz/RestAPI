package com.amex.cornerstone.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.amex.cornerstone.model.CstoneTransformation;
import com.amex.cornerstone.model.Student;

public interface StudentMapper {
	@Insert("INSERT INTO student(userName, password, firstName,"
			+ "lastName, emailAddress) VALUES"
			+ "(#{userName},#{password}, #{firstName}, #{lastName},"
			+ " #{emailAddress})")
	@Options(useGeneratedKeys=true, keyProperty="id", flushCache=true, keyColumn="id")
	public void insertStudent(Student student);
		
	@Select("SELECT ID as id,USERNAME as userName, PASSWORD as password, "
			+ "FIRSTNAME as firstName, LASTNAME as lastName, "
			+ "EMAILADDRESS as emailAddress "
			+ "FROM student WHERE userName = #{userName}")
	public Student getStudentByUserName(String userName);
	
	
	@Select("SELECT ID as id,USERNAME as userName, PASSWORD as password, "
			+ "FIRSTNAME as firstName, LASTNAME as lastName, "
			+ "EMAILADDRESS as emailAddress "
			+ "FROM student")
	public List<Student> getAllStudents();	
	
	
	
	@Insert("INSERT INTO cstone_transformation(trsf_name, trsf_desc, src_tool, src_tool_version, src_name, src_id, business_unit, business_owner_id, business_purpose, data_interaction, reg_compliance, status, create_date, last_updated) VALUES"
			+ "(#{trsf_name},#{trsf_desc},#{src_tool},#{src_tool_version},#{src_name},#{src_id},#{business_unit},#{business_owner_id},#{business_purpose},#{data_interaction},#{reg_compliance},#{status},#{create_date},#{last_updated})")
	@Options(useGeneratedKeys=true, keyProperty="trsf_id", flushCache=true, keyColumn="trsf_id")
	public void insertRegsiterInfo(CstoneTransformation cstoneTransformation);

}

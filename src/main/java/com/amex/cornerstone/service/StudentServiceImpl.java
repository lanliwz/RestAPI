package com.amex.cornerstone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amex.cornerstone.mappers.StudentMapper;
import com.amex.cornerstone.model.CstoneTransformation;
import com.amex.cornerstone.model.Student;
import com.amex.cornerstone.vo.Input;
import com.amex.cornerstone.vo.Output;
import com.amex.cornerstone.vo.OutputTable;
import com.amex.cornerstone.vo.Register;
import com.amex.cornerstone.vo.InputTable;
import com.amex.cornerstone.vo.TransInfo;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper studentMapper;
	
	@Transactional
	public void insertStudent(Student student) {
		studentMapper.insertStudent(student);
	}

	public boolean getStudentByLogin(String userName, String password) {
		Student student = studentMapper.getStudentByUserName(userName);
		
		if(student != null && student.getPassword().equals(password)) {
			return true;
		}
		
		return false;
	}
	
	public Student getStudent(String userName) {
		Student student = studentMapper.getStudentByUserName(userName);		
		return student;
	}

	

	public boolean getStudentByUserName(String userName) {
		Student student = studentMapper.getStudentByUserName(userName);
		
		if(student != null) {
			return true;
		}
		
		return false;
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> students = studentMapper.getAllStudents();
		return students;
	}

	@Override
	public void InsertRegisterInfo(Register register) {
		System.out.printf("The regsiter object is ", register.toString());
		TransInfo transInfo = register.getTrsf_info();
		System.out.printf("The transinfo object is ", transInfo.toString());
		
		Input  input = transInfo.getInput();
		List<InputTable> inputTables = input.getTables();
		System.out.println(inputTables.get(0).getDb_name());
		
		Output  output = transInfo.getOutput();
		List<OutputTable> outputTables = output.getTables();
		System.out.println(outputTables.get(0).getDb_name());
		
		
		
		CstoneTransformation cstoneTransformation = new CstoneTransformation();
		if(null != register.getTrsf_name())
			cstoneTransformation.setTrsf_name(register.getTrsf_name());
		if(null != register.getTrsf_name())
			cstoneTransformation.setTrsf_desc(register.getTrsf_desc());
		if(null != transInfo.getSrc_tool())
			cstoneTransformation.setSrc_name(transInfo.getSrc_tool());
		if(null != transInfo.getSrc_tool_version())
			cstoneTransformation.setSrc_name(transInfo.getSrc_tool_version());
		if(null != transInfo.getSrc_name())
			cstoneTransformation.setSrc_name(transInfo.getSrc_name());		
		if(null != transInfo.getSrc_id())
			cstoneTransformation.setSrc_id(transInfo.getSrc_id());
		if(null != transInfo.getBusiness_unit())
			cstoneTransformation.setBusiness_unit(transInfo.getBusiness_unit());
		if(null != transInfo.getBusiness_owner_id())
			cstoneTransformation.setBusiness_owner_id(transInfo.getBusiness_owner_id());
		if(null != transInfo.getBusiness_purpose())
			cstoneTransformation.setBusiness_purpose(transInfo.getBusiness_purpose());
		if(null != transInfo.getData_interaction())
			cstoneTransformation.setData_interaction(transInfo.getData_interaction());
		if(null != transInfo.getReg_compliance())
			cstoneTransformation.setReg_compliance(transInfo.getReg_compliance());
		if(null != transInfo.getStatus())
			cstoneTransformation.setStatus(transInfo.getStatus());		
		
		studentMapper.insertRegsiterInfo(cstoneTransformation);
		
		
	}
	
	

}

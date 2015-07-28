package com.amex.cornerstone.model;

public class SampleMain {

	public static void main(String[] args) {
		Student st=new Student();
		st.setEmailAddress("email");
		st.setFirstName("firstname");
		st.setId(1L);
		st.setLastName("lastname");
		st.setPassword("pass");
		st.setUserName("usname");
		
	System.out.println(st.toString());

	}

}

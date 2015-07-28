package com.amex.cornerstone.model;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class CstoneTransformation {
	
	  private int trsf_id;
	  private String trsf_name;
	  private String trsf_desc;
	  private String src_tool;
	  private String src_tool_version;
	  private String src_id;
	  private String src_name;
	  private String business_unit;
	  private String business_owner_id;
	  private String business_purpose;
	  private String data_interaction;
	  private String reg_compliance;
	  private String status;
	  private Date  create_date;
	  private Date last_updated;
	  
	public int getTrsf_id() {
		return trsf_id;
	}
	public void setTrsf_id(int trsf_id) {
		this.trsf_id = trsf_id;
	}
	public String getTrsf_name() {
		return trsf_name;
	}
	public void setTrsf_name(String trsf_name) {
		this.trsf_name = trsf_name;
	}
	public String getTrsf_desc() {
		return trsf_desc;
	}
	public void setTrsf_desc(String trsf_desc) {
		this.trsf_desc = trsf_desc;
	}
	public String getSrc_tool() {
		return src_tool;
	}
	public void setSrc_tool(String src_tool) {
		this.src_tool = src_tool;
	}
	public String getSrc_tool_version() {
		return src_tool_version;
	}
	public void setSrc_tool_version(String src_tool_version) {
		this.src_tool_version = src_tool_version;
	}
	public String getSrc_id() {
		return src_id;
	}
	public void setSrc_id(String src_id) {
		this.src_id = src_id;
	}
	public String getSrc_name() {
		return src_name;
	}
	public void setSrc_name(String src_name) {
		this.src_name = src_name;
	}
	public String getBusiness_unit() {
		return business_unit;
	}
	public void setBusiness_unit(String business_unit) {
		this.business_unit = business_unit;
	}
	public String getBusiness_owner_id() {
		return business_owner_id;
	}
	public void setBusiness_owner_id(String business_owner_id) {
		this.business_owner_id = business_owner_id;
	}
	public String getBusiness_purpose() {
		return business_purpose;
	}
	public void setBusiness_purpose(String business_purpose) {
		this.business_purpose = business_purpose;
	}
	public String getData_interaction() {
		return data_interaction;
	}
	public void setData_interaction(String data_interaction) {
		this.data_interaction = data_interaction;
	}
	public String getReg_compliance() {
		return reg_compliance;
	}
	public void setReg_compliance(String reg_compliance) {
		this.reg_compliance = reg_compliance;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Date getLast_updated() {
		return last_updated;
	}
	public void setLast_updated(Date last_updated) {
		this.last_updated = last_updated;
	}
	  
	  
	 


}

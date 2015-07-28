package com.amex.cornerstone.vo;

import org.springframework.stereotype.Service;


@Service
public class TransInfo {
	/**
	 * "src_name": "datameer",
		"src_id": "f15837b7-ad26-4ef5-9216-d31a48ce1a9f",
		"version": "5.7.0",
		"business_unit": "datameer",
		"business_owner_id": "wz1234",
		"business_purpose": "marketing",
		"data_interaction": "no",
		"reg_compliance": "yes",
		"status": "initial",
		"notification": "jhon@yahoo.com",
		"notification_on_success": "jhon@yahoo.com",
	 */
	
	private String src_name;	
	private String src_id;
	private String version;
	private String src_tool;
	 private String src_tool_version;
	private String business_unit;
	private String business_owner_id;
	private String business_purpose;
	private String data_interaction;
	private String reg_compliance;
	private String status;
	private String notification;
	private String notification_on_success;
	private Input input;
	private Output output;
	
	
	public String getSrc_name() {
		return src_name;
	}
	public void setSrc_name(String src_name) {
		this.src_name = src_name;
	}
	public String getSrc_id() {
		return src_id;
	}
	public void setSrc_id(String src_id) {
		this.src_id = src_id;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
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
	public String getNotification() {
		return notification;
	}
	public void setNotification(String notification) {
		this.notification = notification;
	}
	public String getNotification_on_success() {
		return notification_on_success;
	}
	public void setNotification_on_success(String notification_on_success) {
		this.notification_on_success = notification_on_success;
	}
	
		
	public Input getInput() {
		return input;
	}
	public void setInput(Input input) {
		this.input = input;
	}
	
	
	
	public Output getOutput() {
		return output;
	}
	public void setOutput(Output output) {
		this.output = output;
	}
	@Override
	public String toString() {
		return "TransInfo [src_name=" + src_name + ", src_id=" + src_id
				+ ", version=" + version + ", src_tool=" + src_tool
				+ ", src_tool_version=" + src_tool_version + ", business_unit="
				+ business_unit + ", business_owner_id=" + business_owner_id
				+ ", business_purpose=" + business_purpose
				+ ", data_interaction=" + data_interaction
				+ ", reg_compliance=" + reg_compliance + ", status=" + status
				+ ", notification=" + notification
				+ ", notification_on_success=" + notification_on_success
				+ ", input=" + input + ", output=" + output + "]";
	}
	
	
	
	
	}

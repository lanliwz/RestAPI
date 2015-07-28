package com.amex.cornerstone.vo;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class InputTable {
/**
 * "db_name": "cstone",  
					"name": "feed101",
					"id": "85b7b972-e6d5-4db5-9198-587ed42c6999",    //no
					"src_type": "das.internal.DataSourceSheetType",  //no
					"keep": true,                //no
					"desc": "feed table",
					
 */
	private String db_name;
	private String name;
	private String id;
	private String src_type;
	private String keep;
	private String desc;
	private List<InputColumn> columns;
	
	public String getDb_name() {
	return db_name;
	}
	public void setDb_name(String db_name) {
		this.db_name = db_name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSrc_type() {
		return src_type;
	}
	public void setSrc_type(String src_type) {
		this.src_type = src_type;
	}
	public String getKeep() {
		return keep;
	}
	public void setKeep(String keep) {
		this.keep = keep;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public List<InputColumn> getColumns() {
		return columns;
	}
	public void setColumns(List<InputColumn> columns) {
		this.columns = columns;
	}
	
	
		
		
	}

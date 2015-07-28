package com.amex.cornerstone.vo;

import java.util.List;

public class OutputTable {
	
	private String db_name;
	private String name;
	private String id;
	private String src_type;
	private String keep;
	private String desc;
	private String trsf_logic;
	private List<OutputColumn> columns;
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
	public String getTrsf_logic() {
		return trsf_logic;
	}
	public void setTrsf_logic(String trsf_logic) {
		this.trsf_logic = trsf_logic;
	}
	public List<OutputColumn> getColumns() {
		return columns;
	}
	public void setColumns(List<OutputColumn> columns) {
		this.columns = columns;
	}
	
	

}

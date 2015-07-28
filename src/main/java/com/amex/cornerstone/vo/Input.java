package com.amex.cornerstone.vo;

import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class Input {
	List<InputTable> tables;

	public List<InputTable> getTables() {
		return tables;
	}

	public void setTables(List<InputTable> tables) {
		this.tables = tables;
	}
	
}

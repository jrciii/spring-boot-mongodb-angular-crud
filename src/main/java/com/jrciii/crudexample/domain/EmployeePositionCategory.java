package com.jrciii.crudexample.domain;

public enum EmployeePositionCategory {
	INDIRECT("Indirect"), DIRECT("Direct"), PROGRAM_MANAGER("Program Manager"), DIRECTOR("Director"), EXECUTIVE("Executive");
	
	private String category;
	
	EmployeePositionCategory(String category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return category;
	}
}

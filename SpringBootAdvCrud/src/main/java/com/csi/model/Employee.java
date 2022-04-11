package com.csi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data

public class Employee {
	@Id
	@GeneratedValue
	
	private int empId;
	private String empName;
	private String empAddress;
	private long contactNumber;
	private Date empDob;
	private String empEmailId;
	private String empPassword;
	
	

}

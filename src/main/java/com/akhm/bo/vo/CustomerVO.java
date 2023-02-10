package com.akhm.bo.vo;

import lombok.Data;

@Data
public class CustomerVO {
	private Integer customerId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String password;
	private String mobileNumber;

}

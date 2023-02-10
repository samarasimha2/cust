package com.akhm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.akhm.bo.CustomerBO;
import com.akhm.bo.vo.CustomerVO;

@Controller
@RequestMapping("/custom/v0")
public class CustomerController {
	@Autowired
	private CustomerBO customerBO;
	@GetMapping("/isUserExist")
	public ResponseEntity<Boolean> isCustomerExist(@RequestParam String emailId)
	{
		try {
			Boolean isExists=customerBO.isCustomerExist(emailId);
			return new ResponseEntity<>(isExists,HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
	}
	@PostMapping("/registration")
	public ResponseEntity<Integer> registration(@RequestBody CustomerVO customerVO)
	{
		try {
			Integer customerId = customerBO.insertCustomer(customerVO);
			return new ResponseEntity(customerId, HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	@PostMapping("/login")
	public ResponseEntity<CustomerVO> login(@RequestBody CustomerVO customerVO)
	{
		try {
			CustomerVO customer=customerBO.getCustomer(customerVO.getEmailId(), customerVO.getPassword());
			return new ResponseEntity(customer,HttpStatus.CREATED);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}


}

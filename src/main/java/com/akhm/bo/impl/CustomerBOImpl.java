package com.akhm.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akhm.bo.CustomerBO;
import com.akhm.bo.vo.CustomerVO;
import com.akhm.exception.MyCustomerCustomException;
import com.akhm.repository.CustomerRepository;
import com.akhm.repository.entity.CustomerEntity;







@Service
public class CustomerBOImpl implements CustomerBO{
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public CustomerVO getCustomer(String emailId, String password) {
		try {
			CustomerEntity customer=customerRepository.findByEmailIdAndPassword(emailId, password);
			if(customer!=null)
			{
				CustomerVO customerVO=new CustomerVO();
				customerVO.setFirstName(customer.getFirstName());
				customerVO.setLastName(customer.getLastName());
				customerVO.setEmailId(customer.getEmailId());
				customerVO.setPassword(customer.getPassword());
				customerVO.setMobileNumber(customer.getMobileNumber());
				
				return customerVO;
			}
			else {
				return null;
			}
					
		} catch (Exception e) {
			throw new MyCustomerCustomException(e.getMessage());
		}
		
	}

	@Override
	public boolean isCustomerExist(String emailId) {
		boolean isExist=false;
		try {
			CustomerEntity customerEntity=customerRepository.findByEmailId(emailId);
			 
			if(customerEntity!=null)
			{
				isExist=true;
			}
			
		} catch (Exception e) {
			throw new MyCustomerCustomException(e.getMessage());
		}
		return isExist;
	}

	@Override
	public Integer insertCustomer(CustomerVO customerVO) {
		try {
			if(customerVO!=null)
			{
				
				CustomerEntity customerEntity=new CustomerEntity();
				customerEntity.setFirstName(customerVO.getFirstName());
				customerEntity.setLastName(customerVO.getLastName());
				customerEntity.setEmailId(customerVO.getEmailId());
				customerEntity.setPassword(customerVO.getPassword());
				customerEntity.setMobileNumber(customerVO.getMobileNumber());
				CustomerEntity customer=customerRepository.save(customerEntity);
				
				
				if(customer!=null)
				{
					Integer customerId = customer.getCustomerId();
				}
						
			}
			else {
				return null;
			}
			
			
			
		} catch (Exception e) {
			throw new MyCustomerCustomException(e.getMessage());
		}
		return null;
		
	}

	}



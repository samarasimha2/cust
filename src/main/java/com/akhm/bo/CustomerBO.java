package com.akhm.bo;

import com.akhm.bo.vo.CustomerVO;

public interface CustomerBO {
	public CustomerVO getCustomer(String emailId,String password);
	public boolean isCustomerExist(String emailId);
	public Integer insertCustomer(CustomerVO customerVO);

}

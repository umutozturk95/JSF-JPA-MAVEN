package com.service;

import java.util.List;

import com.bean.Address;

public interface ServiceImpl {
	  public String addAddress(Address address);
	  public List<Address> listAddress();
	  public String updateAddress(Address address);
	  public String delete(Address address);
}

package com.service;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;

import com.bean.Address;
import com.dao.*;

@ManagedBean(name="addressService")
public class AddressServiceImp implements ServiceImpl,Serializable {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

   private AddressDaoImp addressDaoImp=new AddressDaoImp();
	@Override
	public String addAddress(Address address) {
	
		addressDaoImp.addAddress(address);
		return "listRecord";
	}

	@Override
	public List<Address> listAddress() {
	    
		return addressDaoImp.listAddress();
	}

	@Override
	public String updateAddress(Address address) {
	   addressDaoImp.updateAddress(address);
		return "listRecord";
	}


	@Override
	public String delete(Address address) {
		addressDaoImp.delete(address);
		return "listRecord";
	}
   
	
}

package com.dao;
import com.bean.*;
import java.util.*;
public interface Dao {
  public void addAddress(Address address);
  public List<Address> listAddress();
  public void updateAddress(Address address);
  public void delete(Address address);
}

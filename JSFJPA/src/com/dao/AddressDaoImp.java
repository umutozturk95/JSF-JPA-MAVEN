package com.dao;
import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.bean.Address;
import com.bean.PhoneNumber;

public class AddressDaoImp implements Dao,Serializable {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private  SessionFactory sessionFactory;

	    public AddressDaoImp() {
       
	    	
	    try {
            
        	Configuration configuration = new Configuration();
        	configuration.configure("hibernate.cfg.xml");
        	
        	
        	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();        	      	
           sessionFactory = configuration.buildSessionFactory(serviceRegistry);       	
           
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }
	
	
	
	@Override
	public void addAddress(Address address) {
		Session session = null;
		Transaction tx = null;
		
		System.out.println("Heyyy--->"+address.getAddress()+"--->"+address.getAge()+"-->"+address.getName()+"-->"+address.getSurname());
		try{
			session=sessionFactory.openSession();
			tx=session.beginTransaction();
			
			List<PhoneNumber> ph=address.getPhones();
			for(int i=0;i<ph.size();i++){
				ph.get(i).setAddress1(address);
			}
			tx.commit();
			session.save(address);
			session.flush();
			//session.close();
			
		}
		catch(Exception e){
			/*
			if (tx!=null) tx.rollback();
		     throw e;
		  */
		}
		finally{
			session.close();
		}
		
	}

	@Override
	public List<Address> listAddress() {
		
		Session session =sessionFactory.openSession();
		List<Address> addresses=null;
		session.beginTransaction();
		
	   addresses=session.createQuery("from Address").list();	
	   session.getTransaction().commit();
	   session.flush();
	   session.close();
	   return addresses;
	}



	@Override
	public void updateAddress(Address address) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("******K**********");
		for(int i=0;i<address.getPhones().size();i++){
			System.out.println(address.getPhones().get(i).getId()+"<--> "+address.getPhones().get(i).getPhoneNo());
			if(address.getPhones().get(i).getId()==0){
			  address.getPhones().get(i).setAddress1(address);
			}
	    }
		System.out.println("*******K*******");
		session.saveOrUpdate(address);
		session.getTransaction().commit();
		session.flush();
		session.close();
	}



	@Override
	public void delete(Address address) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		Query query=session.createQuery("delete PhoneNumber where address_id= :id");
		query.setInteger("id",address.getId());
		int result=query.executeUpdate();
	
		query=session.createQuery("delete Address where id= :id");
		query.setInteger("id",address.getId());
	    result=query.executeUpdate();
		session.getTransaction().commit();
		session.flush();
		session.close();
		
	}

}

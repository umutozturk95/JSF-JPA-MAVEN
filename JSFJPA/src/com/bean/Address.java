package com.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="address")
@ManagedBean(name="address")
@SessionScoped
public class Address implements Serializable {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="address_id",unique=true,nullable=false)
	private int id;
	
	
	@Column(name="name",nullable=false)
	
	private String name;
	
	@Column(name="surname",nullable=false)
	private String surname;
	
	@Column(name="age",nullable=false)
	private int age;
	
	@Column(name="adress",nullable=false)
	private String address;
	
	
	@Column(name="email",nullable=false)
	private String email;
	
	

	@OneToMany(cascade=CascadeType.ALL, mappedBy="address1",orphanRemoval=true,fetch = FetchType.EAGER)
	
	private List<PhoneNumber> phones=new ArrayList<PhoneNumber>();
	
	public Address(){
		phones.add(new PhoneNumber());
	}
    
	
	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<PhoneNumber> getPhones() {
		return phones;
	}

	public void setPhones(List<PhoneNumber> phones) {
		this.phones = phones;
	}
	
	public void onButtonRemoveFieldClick(final PhoneNumber phoneNumber)
    {
		
		phones.remove(phoneNumber);
       
    }
	
	public void onButtonAddFieldClick(AjaxBehaviorEvent p_oEvent)
    {
		
       phones.add(new PhoneNumber());
    }

	public String saveEditedAdress(Address ad){
		 this.id=ad.getId();
		 this.address=ad.getAddress();
		 this.age=ad.getAge();
		 this.name=ad.getName();
		 this.phones=ad.getPhones();
		 this.surname=ad.getSurname();
		 this.email=ad.getEmail();
		 return "editRecord";
	}
	public String fillTheBlank(){
		
		this.id=0;
		this.address="";
		this.age=0;
		this.name="";
		this.surname="";
		this.email="";
		
		if(this.phones.size()>0){
			for(int i=this.phones.size()-1;i>=0;i--){
				this.phones.remove(i);
			}
			this.phones.add(new PhoneNumber());
			
		}
		
		
		return "addRecord";
		
		
	}
	
	public String logout(){
		this.id=0;
		this.address="";
		this.age=0;
		this.name="";
		this.surname="";
		this.email="";
		if(this.phones.size()>0){
			for(int i=this.phones.size()-1;i>=0;i--){
				this.phones.remove(i);
			}
			this.phones.add(new PhoneNumber());
			
		}
		return "index";				
	}
}

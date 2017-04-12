package com.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;

@ManagedBean(name="login")
@RequestScoped
public class Login implements Serializable {
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String name;
 private String password;
 
 public String getName(){
	 
	 return this.name;
 }
 
 public void setName(String name){
	 this.name=name;
	 
 }
 
 public String getPassword(){
	 return this.password;
 }
 public void setPassword(String password){
	 
	 this.password=password;
 }
  	
 
 public String login(){
	 if(name.equals("admin1")&&password.equals("123")){
		 FacesContext facesContex=FacesContext.getCurrentInstance();
		// FacesMessage facesMessage=new FacesMessage("Welcome "+name+" !");
		// facesContex.addMessage(null,facesMessage);
		 return "addRecord";
		 
	 }
	 else{
		 
		 FacesContext facesContex=FacesContext.getCurrentInstance();
		 FacesMessage facesMessage=new FacesMessage("Invalid Password or Username!");
		 facesContex.addMessage(null,facesMessage);
	 }
	 return null;
 }
 
}

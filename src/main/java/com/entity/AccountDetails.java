package com.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AccountDetails")
public class AccountDetails implements Serializable{
	private static final long serialVersionUID = -8729314956848665741L;
	
	public static final String ROLE_ADMIN="ADMIN";
	public static final String ROLE_STAFF="STAFF";
	
	private String username;
    private String password;
    private String userrole;
    
    @Id
    @Column(name = "username", length = 20 , nullable = false)
    public String getusername(){
    	return username;
    }
    public void setusername(String username){
    	this.username=username;
    }
    @Column(name = "password", length= 16 , nullable = false)
    public String getPassword(){
    	return password;
    }
    public void setPassword(String password){
    	this.password=password;
    }
    @Column(name = "role", length = 20, nullable = false)
    public String getUserRole() {
        return userrole;
    }
 
    public void setUserRole(String userRole) {
        this.userrole = userRole;
    }
    @Override
    public String toString()  {
        return "["+ this.username+","+ this.password+","+ this.userrole+"]";
    }
}
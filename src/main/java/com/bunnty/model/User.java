package com.bunnty.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;


@Entity
@Table(name="User")
public class User{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="Username",unique=true , nullable=false)
	private String userName;
	
	@Column(name="Password",nullable=false)
	private String password;
	
	@Column(name="Email", nullable=false)
	private String email;
	
	@Column(name="State",nullable=false)
	private String state=State.Active.getState();
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "User_UserType",
			joinColumns= { @JoinColumn(name="User_id") },
			inverseJoinColumns = { @JoinColumn(name = "Usertype_id") })
	private Set<UserProfile> userProfiles = new HashSet<UserProfile>();
	
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	public String getuserName(){
		return userName;
	}
	public void setuserName(String userName){
		this.userName=userName;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email=email;
	}
	public String getState(){
		return state;
	}
	public void setState(String state){
		this.state=state;
	}
	public Set<UserProfile> getUserProfiles(){
		return userProfiles; 
	}
	public void setUserProfiles(Set<UserProfile> userProfiles){
		this.userProfiles=userProfiles;
	}
	@Override
	public boolean equals(Object obj){
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(!(obj instanceof User))
			return false;
		User other = (User) obj;
		if(id !=other.id)
			return false;
		if(userName == null){
			if(other.userName != null)
				return false;
		}else if (!userName.equals(other.userName))
			return false;
		return true;
		}
	@Override
	public String toString(){
		return "User [id="+id+" ,Username="+userName+" "
				+ ",Password=" +password+ " ,Email=" +email+
				" ,State="+state+" ,UserProfiles=" +userProfiles +"]";
	}
}	
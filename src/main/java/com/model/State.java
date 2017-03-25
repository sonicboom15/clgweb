package com.model;

public enum State{
	Active("Active"),
	Inactive("Inactive"),
	Deleted("Deleted"),
	Locked("Locked");
	
	private String state;
	
	private State(final String state){
		this.state= state;
	}
	public String getState(){
		return this.state;
	}
	@Override
	public String toString(){
		return this.state;
	}
	public String getName(){
		return this.name();
	}
}
package com.example.demo.Model;

public class TestModel {
	public int id;
	public String name;
	
	public TestModel() {
		
	}
	
	public TestModel(int id, String name) {
		this.id=id;
		this.name=name;
	}
	
	@Override
	public String toString() {
	     return "TestModel [ArtistId=" + id + ", Name=" + name + "]";
	}
}

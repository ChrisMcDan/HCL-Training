package com.daily;

public class Cat
{
	private int catId;
	private String catName;
	
	public Cat(int catId, String catName)
	{
		super();	//Implied so don't necessarily need it.
		this.catId = catId;
		this.catName = catName;
	}
	
	public int getCatId()
	{
		return catId;
	}
	
	public void setCatId(int catId)
	{
		this.catId = catId;
	}
	
	public String getCatName()
	{
		return catName;
	}
	
	public void setCatName(String catName)
	{
		this.catName = catName;
	}
}
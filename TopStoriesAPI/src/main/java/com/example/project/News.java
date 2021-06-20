package com.example.project;

public class News 
{
	
private String title;
private String section;
public Results[] results;

public String getTitle() 
{
	return title;
}
public void setTitle(String title) 
{
	this.title = title;
}
public String getSection()
{
	return section;
}

public void setSection(String section)
{
	this.section = section;
}

public Results[] getResults()
{
	return results;
}
public void setResults(Results[] results) 
{
	this.results = results;
}

@Override
public String toString() 
{
	return section;	
} 

}

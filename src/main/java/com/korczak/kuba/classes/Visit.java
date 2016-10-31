package com.korczak.kuba.classes;

public class Visit
{
	private int id;
	private int idPatient;
	private int idDoctor;
	private String visitPlace;
	
	
	
	public Visit(int id, int idPatient, int idDoctor, String visitPlace)
	{
		this.id = id;
		this.idPatient = idPatient;
		this.idDoctor = idDoctor;
		this.visitPlace = visitPlace;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public int getIdPatient()
	{
		return idPatient;
	}
	public void setIdPatient(int idPatient)
	{
		this.idPatient = idPatient;
	}
	public int getIdDoctor()
	{
		return idDoctor;
	}
	public void setIdDoctor(int idDoctor)
	{
		this.idDoctor = idDoctor;
	}
	public String getVisitPlace()
	{
		return visitPlace;
	}
	public void setVisitPlace(String visitPlace)
	{
		this.visitPlace = visitPlace;
	}
	@Override
	public String toString()
	{
		return "Visit [visitPlace=" + visitPlace + "]";
	}
	
	
}

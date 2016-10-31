package com.korczak.kuba.classes;

public class Merge
{
	private int id;
	private String nameD;
	private String surnameD;
	private int salary;
	
	private String nameP;
	private String surnameP;
	private String ilness;
	private int age;
	
	private String visitPlace;

	public Merge(int id, String nameD, String surnameD, int salary, String nameP, String surnameP, String ilness,
			int age, String visitPlace)
	{
		this.id = id;
		this.nameD = nameD;
		this.surnameD = surnameD;
		this.salary = salary;
		this.nameP = nameP;
		this.surnameP = surnameP;
		this.ilness = ilness;
		this.age = age;
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

	public String getNameD()
	{
		return nameD;
	}

	public void setNameD(String nameD)
	{
		this.nameD = nameD;
	}

	public String getSurnameD()
	{
		return surnameD;
	}

	public void setSurnameD(String surnameD)
	{
		this.surnameD = surnameD;
	}

	public int getSalary()
	{
		return salary;
	}

	public void setSalary(int salary)
	{
		this.salary = salary;
	}

	public String getNameP()
	{
		return nameP;
	}

	public void setNameP(String nameP)
	{
		this.nameP = nameP;
	}

	public String getSurnameP()
	{
		return surnameP;
	}

	public void setSurnameP(String surnameP)
	{
		this.surnameP = surnameP;
	}

	public String getIlness()
	{
		return ilness;
	}

	public void setIlness(String ilness)
	{
		this.ilness = ilness;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
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
		return "Merge [id=" + id + ", nameD=" + nameD + ", surnameD=" + surnameD + ", salary=" + salary + ", nameP="
				+ nameP + ", surnameP=" + surnameP + ", ilness=" + ilness + ", age=" + age + ", visitPlace="
				+ visitPlace + "]";
	}
	
	
	
	
}

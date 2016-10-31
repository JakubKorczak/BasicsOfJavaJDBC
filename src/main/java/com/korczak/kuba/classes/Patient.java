package com.korczak.kuba.classes;

import java.util.Scanner;

public class Patient
{
	private int id;
	private String name;
	private String surname;
	private String ilness;
	private int age;
	
	
	public Patient(int id, String name, String surname, String ilness, int age)
	{
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.ilness = ilness;
		this.age = age;
	}
	public Patient()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id");
		id = Integer.parseInt(sc.nextLine());
		System.out.println("Enter name");
		name = sc.nextLine();
		System.out.println("Entr surname");
		surname = sc.nextLine();
		System.out.println("Enter age");
		age = Integer.parseInt(sc.nextLine());
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getSurname()
	{
		return surname;
	}
	public void setSurname(String surname)
	{
		this.surname = surname;
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
	
	@Override
	public String toString()
	{
		return "Patient: [ ID: " + id + ", name: " + name + ", surname: " + surname + ", ilness: " + ilness + ", age: " + age + " ]\n";
	}
	
	
}

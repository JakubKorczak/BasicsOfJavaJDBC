package com.korczak.kuba.classes;

import java.util.Scanner;

public class Doctor
{
	private int id;
	private String name;
	private String surname;
	private int salary;

	public Doctor(int id, String name, String surname, int salary)
	{
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.salary = salary;
	}

	public Doctor()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id");
		id = Integer.parseInt(sc.nextLine());
		System.out.println("Enter name");
		name = sc.nextLine();
		System.out.println("Entr surname");
		surname = sc.nextLine();
		System.out.println("Enter salary");
		salary = Integer.parseInt(sc.nextLine());
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

	public double getSalary()
	{
		return salary;
	}

	public void setSalary(int salary)
	{
		this.salary = salary;
	}

	@Override
	public String toString()
	{
		return "Doctor: [ ID=" + id + ", name: " + name + ", surname: " + surname + ", salary: " + salary + " ]\n";
	}

}

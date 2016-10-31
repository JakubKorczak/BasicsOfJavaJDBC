package com.korczak.kuba;

import java.util.Scanner;

import javax.swing.JOptionPane;

import com.korczak.kuba.database.Database;

//SIMPLE APP CONNECTED WITH DATABASE

public class Main
{

	private final static String DRV = "org.sqlite.JDBC";
	private final static String DB = "jdbc:sqlite:Hospital.db";

	public static void showMenu()
	{
		String printMenu = "===============\nMENU - HOSPITAL\n===============\n";
		printMenu += "Choose an option:\n";
		printMenu += "\t1.Find doctor (by ID)\n";
		printMenu += "\t2.Show all doctors\n";
		printMenu += "\t3.Delete doctor (by ID)\n";
		printMenu += "\t4.Find patient (by ID)\n";
		printMenu += "\t5.Show all patients\n";
		printMenu += "\t6.Delete patient (by ID)\n";
		printMenu += "\t7.Show doctors max salary\n";
		printMenu += "\t8.Show patient average age\n";
		printMenu += "\t9.Add doctor\n";
		printMenu += "\t10.Add patient\n";
		printMenu += "\t11.Creat a visit\n";
		printMenu += "\t12.Show visits\n";
		printMenu += "\t13.EXIT PROGRAM";

		System.out.println(printMenu);
		System.out.print("Your option is: ");
	}

	public static int optionChoice()
	{

		Scanner inputOption = new Scanner(System.in);

		if (inputOption.hasNextInt())
		{
			int choice = Integer.parseInt(inputOption.nextLine());
			return choice;
		} else
		{
			System.out.println("Sorry, couldn't understand you!");
			return 0;
		}

	}

	public static void functionSwitcher()
	{
		Scanner inputChoice = new Scanner(System.in);

		boolean isExit = false;

		while (isExit == false)
		{
			showMenu();
			switch (optionChoice())
			{
			case 1:
				System.out.println("Enter doctor ID");
				int choiceFindDoctor = Integer.parseInt(inputChoice.nextLine());
				System.out.println(Database.selectOneDoctor(choiceFindDoctor));
				break;
			case 2:
				System.out.println(Database.selectDoctor());
				break;
			case 3:
				System.out.println("Enter doctor ID");
				int choiceDeleteDoctor = Integer.parseInt(inputChoice.nextLine());
				Database.deleteDoctor(choiceDeleteDoctor);
				System.out.println("Doctore was deleted.");
				break;
			case 4:
				System.out.println("Enter patient ID");
				int choiceFindPatient = Integer.parseInt(inputChoice.nextLine());
				System.out.println(Database.selectonePatient(choiceFindPatient));
				break;
			case 5:
				System.out.println(Database.selectPatient());
				break;
			case 6:
				System.out.println("Enter patient ID");
				int choiceDeletePatient = Integer.parseInt(inputChoice.nextLine());
				Database.deletePatient(choiceDeletePatient);
				System.out.println("Patient was deleted");
				break;
			case 7:
				System.out.println("Max doctors salary = " + Database.maxSalOfDoctors());
				break;
			case 8:
				System.out.println("Avarag patients age = " + Database.avgAgeOfPatient());
				break;
			case 9:
				System.out.println("Enter doctor name");
				String doctorName = inputChoice.nextLine();
				System.out.println("Enter doctor surname;");
				String doctorSurname = inputChoice.nextLine();
				System.out.println("Enter doctor salary");
				int salary = Integer.parseInt(inputChoice.nextLine());
				Database.insertDoctor(doctorName, doctorSurname, salary);
				System.out.println("Doctor was added");
				break;
			case 10:
				System.out.println("Enter patient name");
				String patientName = inputChoice.nextLine();
				System.out.println("Enter patient surname;");
				String patientSurname = inputChoice.nextLine();
				System.out.println("Enter patient ilness");
				String ilness = inputChoice.nextLine();
				System.out.println("Enter patient age");
				int age = Integer.parseInt(inputChoice.nextLine());
				Database.insertPatient(patientName, patientSurname, ilness, age);
				System.out.println("Patient was added");
				break;
			case 11:
				System.out.println("Enter doctor ID");
				int doctorID = Integer.parseInt(inputChoice.nextLine());
				System.out.println("Enter patient ID");
				int patientID = Integer.parseInt(inputChoice.nextLine());
				System.out.println("Enter place");
				String visitPlace = inputChoice.nextLine();
				Database.insertVisit(doctorID, patientID, visitPlace);
				System.out.println("Visit was arranged");
				break;
			case 12:
				System.out.println(Database.innerJoinNameSurname());
				break;
			case 13:
				System.out.println("Program closed");
				isExit = true;
				break;
			default:
				JOptionPane.showMessageDialog(null, "Wrong choice! Try again.");
				break;
			}
		}
	}

	public static void main(String[] args)
	{
		Database.connect(DRV, DB);
		Database.createTables();

		functionSwitcher();

		/*Database.insertDoctor("Steven", "Strange", 325000);
		Database.insertDoctor("Jan", "Dolittle", 1350);
		Database.insertDoctor("Gregory", "House", 42999);

		Database.insertPatient("Jack", "Nicholson", "Schizophrenia", 79);
		Database.insertPatient("Walter", "White", "Cancer", 49);
		Database.insertPatient("Freddie", "Mercury", "AIDS", 79);

		Database.insertVisit(1, 1, "Baker Street");
		Database.insertVisit(2, 3, "Queens");
		Database.insertVisit(3, 2, "Prison");*/

	}

}

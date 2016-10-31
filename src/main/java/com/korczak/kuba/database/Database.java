package com.korczak.kuba.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.sqlite.SQLiteConfig;

import com.korczak.kuba.classes.Doctor;
import com.korczak.kuba.classes.Merge;
import com.korczak.kuba.classes.Patient;
import com.korczak.kuba.classes.Visit;

public class Database
{

	private static Connection conn;
	private static Statement stat;

	public static Connection getConn()
	{
		return conn;
	}

	public static void connect(String drv, String db)
	{
		try
		{
			Class.forName(drv);
			SQLiteConfig conf = new SQLiteConfig();
			conf.enforceForeignKeys(true);
			conn = DriverManager.getConnection(db, conf.toProperties());
			stat = conn.createStatement();
		} catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}

	public static void createTables()
	{
		String createDoctors = "CREATE TABLE IF NOT EXISTS Doctors (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(50) NOT NULL, "
				+ "surname VARCHAR(50) NOT NULL, salary INTEGER NOT NULL);";

		String createPatients = "CREATE TABLE IF NOT EXISTS Patients (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(50) NOT NULL, "
				+ "surname VARCHAR(50) NOT NULL, ilness VARCHAR(50) NOT NULL, age INTEGER NOT NULL);";

		String createVisits = "CREATE TABLE IF NOT EXISTS Visits (id INTEGER PRIMARY KEY AUTOINCREMENT, idDoctor INTEGER NOT NULL , "
				+ "idPatient INTEGER NOT NULL, visitPlace VARCHAR(50) NOT NULL, FOREIGN KEY (idDoctor) REFERENCES Doctors(id) ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "FOREIGN KEY (idPatient) REFERENCES Patients(id) ON DELETE CASCADE ON UPDATE CASCADE);";

		try
		{
			stat.execute(createDoctors);
			stat.execute(createPatients);
			stat.execute(createVisits);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}

	}

	public static void insertDoctor(String name, String surname, int salary)
	{
		String insertDoctor = "INSERT INTO Doctors (name, surname, salary) VALUES (?, ?, ?);";
		PreparedStatement ps;
		try
		{
			ps = conn.prepareStatement(insertDoctor);
			ps.setString(1, name);
			ps.setString(2, surname);
			ps.setInt(3, salary);
			ps.execute();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public static void deleteDoctor(int id)
	{
		String deleteD = "DELETE FROM Doctors WHERE id = ?;";
		PreparedStatement ps;

		try
		{
			ps = conn.prepareStatement(deleteD);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public static List<Doctor> selectDoctor()
	{
		List<Doctor> lista = new ArrayList<>();
		String selectD = "SELECT * FROM Doctors";
		try
		{
			int id, salary;
			String name, surname;
			ResultSet rs = stat.executeQuery(selectD);
			while (rs.next())
			{
				id = rs.getInt("id");
				name = rs.getString("name");
				surname = rs.getString("surname");
				salary = rs.getInt("salary");
				lista.add(new Doctor(id, name, surname, salary));
			}
			return lista;
		} catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public static Doctor selectOneDoctor(Integer id1)
	{

		try
		{
			String selectD = "SELECT * FROM Doctors WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(selectD);
			ps.setInt(1, id1);

			int id = 0, salary = 0;
			String name = "", surname = "";
			ResultSet rs = ps.executeQuery();

			id = rs.getInt("id");
			name = rs.getString("name");
			surname = rs.getString("surname");
			salary = rs.getInt("salary");

			return new Doctor(id, name, surname, salary);

		} catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public static void insertPatient(String name, String surname, String ilness, int age)
	{
		String insertPatient = "INSERT INTO Patients (name, surname, ilness, age) VALUES (?, ?, ?, ?);";
		PreparedStatement ps;
		try
		{
			ps = conn.prepareStatement(insertPatient);
			ps.setString(1, name);
			ps.setString(2, surname);
			ps.setString(3, ilness);
			ps.setInt(4, age);
			ps.execute();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public static void deletePatient(int id)
	{
		String deleteP = "DELETE FROM Patients WHERE id = ?;";
		PreparedStatement ps;

		try
		{
			ps = conn.prepareStatement(deleteP);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public static List<Patient> selectPatient()
	{
		List<Patient> lista = new ArrayList<>();
		String selectP = "SELECT * FROM Patients";
		try
		{
			int id, age;
			String name, surname, ilness;
			ResultSet rs = stat.executeQuery(selectP);
			while (rs.next())
			{
				id = rs.getInt("id");
				name = rs.getString("name");
				surname = rs.getString("surname");
				ilness = rs.getString("ilness");
				age = rs.getInt("age");
				lista.add(new Patient(id, name, surname, ilness, age));
			}
			return lista;
		} catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public static Patient selectonePatient(Integer id1)
	{

		try
		{
			String selectP = "SELECT * FROM Patients WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(selectP);
			ps.setInt(1, id1);

			int id = 0, age = 0;
			String name = "", surname = "", ilness = "";
			ResultSet rs = ps.executeQuery();

			id = rs.getInt("id");
			name = rs.getString("name");
			surname = rs.getString("surname");
			ilness = rs.getString("ilness");
			age = rs.getInt("age");

			return new Patient(id, name, surname, ilness, age);
		} catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public static void insertVisit(int idDoctor, int idPatient, String visitPlace)
	{
		String insertVisit = "INSERT INTO Visits (idDoctor, idPatient, visitPlace) VALUES (?, ?, ?);";
		PreparedStatement ps;
		try
		{
			ps = conn.prepareStatement(insertVisit);
			ps.setInt(1, idDoctor);
			ps.setInt(2, idPatient);
			ps.setString(3, visitPlace);
			ps.execute();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}

	}

	public static void deleteVisit(int id)
	{
		String deleteV = "DELETE FROM Visits WHERE id = ?;";
		PreparedStatement ps;

		try
		{
			ps = conn.prepareStatement(deleteV);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}

	}

	public static List<Visit> selectVisit()
	{
		List<Visit> lista = new ArrayList<>();
		String selectV = "SELECT * FROM Visits";
		try
		{
			int id, idDoctor, idPatient;
			String visitPlace;
			ResultSet rs = stat.executeQuery(selectV);
			while (rs.next())
			{
				id = rs.getInt("id");
				idDoctor = rs.getInt("idDoctor");
				idPatient = rs.getInt("idPatient");
				visitPlace = rs.getString("visitPlace");
				lista.add(new Visit(id, idPatient, idDoctor, visitPlace));
			}
			return lista;
		} catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}

	}

	public static double maxSalOfDoctors()
	{
		String avgSal = "Select MAX(salary) FROM Doctors;";
		try
		{
			ResultSet rs = stat.executeQuery(avgSal);
			if (rs.next())
			{
				return rs.getDouble(1);
			}
			return -1;
		} catch (SQLException e1)
		{
			e1.printStackTrace();
			return -1;
		}

	}

	public static double avgAgeOfPatient()
	{
		String avgAge = "Select AVG(age) FROM Patients;";
		try
		{
			ResultSet rs = stat.executeQuery(avgAge);
			if (rs.next())
			{
				return rs.getDouble(1);
			}
			return -1;
		} catch (SQLException e1)
		{
			e1.printStackTrace();
			return -1;
		}

	}

	public static List<Merge> innerJoin()
	{

		String innerJoinSQL = "SELECT "
				+ "Visits.id,  Visits.visitPlace, Doctors.name, Doctors.surname, Doctors.salary, "
				+ "Patients.name, Patients.surname, Patients.ilness, Patients.age " + "FROM "
				+ "Doctors INNER JOIN Visits " + "ON Doctors.id = Visits.idDoctor " + "INNER JOIN "
				+ "Patients ON Visits.idPatient = Patients.id;";

		int id, salary, age;
		String visitPlace, nameD, surnameD, nameP, surnameP, ilness;

		List<Merge> lista = new ArrayList<>();

		try
		{
			ResultSet rs = stat.executeQuery(innerJoinSQL);
			while (rs.next())
			{
				id = rs.getInt(1);
				visitPlace = rs.getString(2);
				nameD = rs.getString(3);
				surnameD = rs.getString(4);
				salary = rs.getInt(5);
				nameP = rs.getString(6);
				surnameP = rs.getString(7);
				ilness = rs.getString(8);
				age = rs.getInt(9);

				lista.add(new Merge(id, nameD, surnameD, salary, nameP, surnameP, ilness, age, visitPlace));
			}
			return lista;
		} catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}

	}

	public static List<String> innerJoinNameSurname()
	{

		String innerJoinSQL = "SELECT " + "Visits.id, Visits.visitPlace, Doctors.name, Doctors.surname, "
				+ "Patients.name, Patients.surname " + "FROM " + "Doctors INNER JOIN Visits "
				+ "ON Doctors.id = Visits.idDoctor " + "INNER JOIN " + "Patients ON Visits.idPatient = Patients.id;";

		List<String> lista = new ArrayList<>();

		try
		{
			ResultSet rs = stat.executeQuery(innerJoinSQL);
			while (rs.next())
			{
				lista.add(rs.getInt(1) + ". Visit takes place in: " + rs.getString(2) + ".\nDoctor: " + rs.getString(3)
						+ " " + rs.getString(4) + " with patient: " + rs.getString(5) + " " + rs.getString(6));

			}
			return lista;
		} catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}

	}

	public static void closeDatabase()
	{
		try
		{
			stat.close();
			conn.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}

	}
}

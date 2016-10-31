package com.korczak.kuba;

import org.junit.Assert;
import org.junit.Test;

import com.korczak.kuba.database.Database;

public class AppTest
{
	@Test
	public void connTest()
	{
		String drvGood = "org.sqlite.JDBC";
		;
		String dbGood = "jdbc:sqlite:Hospital.db";

		Database.connect(drvGood, dbGood);
		Assert.assertNotNull("Connection should NOT be null.", Database.getConn());
		Database.closeDatabase();
	}

	@Test
	public void maxTest()
	{
		String drvGood = "org.sqlite.JDBC";
		;
		String dbGood = "jdbc:sqlite:Hospital.db";

		Database.connect(drvGood, dbGood);
		Database.createTables();

		Database.insertDoctor("Steven", "Strange", 325000);
		Database.insertDoctor("Jan", "Dolittle", 1350);
		Database.insertDoctor("Gregory", "House", 42999);

		Database.insertVisit(1, 1, "Baker Street");
		Database.insertVisit(2, 3, "Queens");
		Database.insertVisit(3, 2, "Prison");

		Assert.assertEquals("Max value is not correct", Database.maxSalOfDoctors(), 325000, 0.01);

		Database.closeDatabase();

	}

	@Test
	public void selectsTest()
	{
		String drvGood = "org.sqlite.JDBC";
		;
		String dbGood = "jdbc:sqlite:Hospital.db";

		Database.connect(drvGood, dbGood);
		Database.createTables();

		Database.insertDoctor("Steven", "Strange", 325000);
		Database.insertDoctor("Jan", "Dolittle", 1350);
		Database.insertDoctor("Gregory", "House", 42999);

		Database.insertPatient("Jack", "Nicholson", "Schizophrenia", 79);
		Database.insertPatient("Walter", "White", "Cancer", 49);
		Database.insertPatient("Freddie", "Mercury", "AIDS", 79);

		Database.insertVisit(1, 1, "Baker Street");
		Database.insertVisit(2, 3, "Queens");
		Database.insertVisit(3, 2, "Prison");

		Assert.assertNotNull(Database.selectDoctor());
		Assert.assertNotNull(Database.selectPatient());
		Assert.assertNotNull(Database.selectVisit());

		Database.closeDatabase();

	}

}

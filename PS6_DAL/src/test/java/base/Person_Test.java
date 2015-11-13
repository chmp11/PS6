package base;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;

public class Person_Test {

	public static PersonDomainModel testPerson;
	
	@BeforeClass
	public static void setup() throws Exception {
		PersonDomainModel testPerson=new PersonDomainModel();
		testPerson.setFirstName("William");
		testPerson.setLastName("Windsor");
		testPerson.setStreet("Royal Road");
		testPerson.setPostalCode(11111);
		testPerson.setCity("London");
		testPerson.setBirthday(LocalDate.of(1980, 01, 01));
	}
	
	@After
	public void teardown() throws Exception{
		PersonDomainModel per;
		PersonDAL.deletePerson(testPerson.getPersonID());
		per = PersonDAL.getPerson(testPerson.getPersonID());
		assertNull("There should be nothing left in the database",per);
	}
	
	@Test
	public void testAddPerson() {
		PersonDomainModel per;		
		per = PersonDAL.getPerson(testPerson.getPersonID());		
		assertNull("The Person shouldn't have been in the database",per);		
		PersonDAL.addPerson(testPerson);	
		
		per = PersonDAL.getPerson(testPerson.getPersonID());
		System.out.println(testPerson.getPersonID() + " found");
		assertNotNull("The Person should have been added to the database",per);
		
	}
	
	@Test
	public void testUpdatePerson(){
		PersonDomainModel per;
		final String C_FirstName = "Harry";
		
		per = PersonDAL.getPerson(testPerson.getPersonID());		
		assertNull("The Person shouldn't have been in the database",per);		
		PersonDAL.addPerson(testPerson);	
		
		testPerson.setFirstName(C_FirstName);
		PersonDAL.updatePerson(testPerson);
		
		per = PersonDAL.getPerson(testPerson.getPersonID());

		assertTrue("Name Didn't Change",testPerson.getFirstName() == C_FirstName);
	}
	
	@Test
	public void DeletePersonTest()
	{		
		PersonDomainModel per;		
		per = PersonDAL.getPerson(testPerson.getPersonID());		
		assertNull("The Person shouldn't have been in the database",per);	
		
		PersonDAL.addPerson(testPerson);			
		per = PersonDAL.getPerson(testPerson.getPersonID());
		System.out.println(testPerson.getPersonID() + " found");
		assertNotNull("The Person should have been added to the database",per);
		
		PersonDAL.deletePerson(testPerson.getPersonID());
		per = PersonDAL.getPerson(testPerson.getPersonID());		
		assertNull("The Person shouldn't have been in the database",per);	
		
	}
	

}

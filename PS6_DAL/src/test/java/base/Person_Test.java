package base;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;

public class Person_Test {

	public static PersonDomainModel testPerson;
	
	@BeforeClass
	public static void setup(){
		PersonDomainModel testPerson=new PersonDomainModel();
		testPerson.setPersonID();
		testPerson.setFirstName("William");
		testPerson.setLastName("Windsor");
		testPerson.setStreet("Royal Road");
		testPerson.setPostalCode(11111);
		testPerson.setCity("London");
		testPerson.setBirthday(LocalDate.of(1980, 01, 01));
	}
	
	@Test
	public void testAddPerson() {
		PersonDAL.addPerson(testPerson);
	}

}

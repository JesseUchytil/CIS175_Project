package junitTests;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Account;

public class AccountTests {
	private Account testacc;

	@Before
	public void setUp() throws Exception {
		testacc = new Account("Name", 300.25f);
		testacc.setId(25);
	}
	
	//////Test Constructors//////

	@Test
	public void testEmptyConstructorNotNull() {
		Account acc = new Account();
		assertNotNull(acc);
	}

	@Test
	public void testParameterizedConstructorNameNotNull() {
		Account acc = new Account("rightName", 0);
		assertNotNull(acc.getAccount_name());
	}

	@Test
	public void testParameterizedConstructorBalanceNotNull() {
		Account acc = new Account("rightName", 0f);
		assertNotNull(acc.getAccount_balance());
	}

	@Test
	public void testParameterizedConstructorNameCorrect() {
		Account acc = new Account("rightName", 0);
		assertEquals("rightName", acc.getAccount_name());
	}

	@Test
	public void testParameterizedConstructorbalanceCorrect() {
		Account acc = new Account("rightName", 0f);
		assertEquals(0.0f, acc.getAccount_balance(), 0.001);
	}

	//////Test Getters////// 
	
	@Test
	public void testExistingAccountGetName() {
		assertEquals("Name", testacc.getAccount_name());
	}

	@Test
	public void testExistingAccountGetBalance() {
		assertEquals(300.25f, testacc.getAccount_balance(), 0.001);
	}

	@Test
	public void testExistingAccountGetId() {
		assertEquals(25, testacc.getId());
	}
	
	//////Test Setters////// 

	@Test
	public void testExistingAccountSetName() {
		testacc.setAccount_name("Name2");
		assertEquals("Name2", testacc.getAccount_name());
	}

	@Test
	public void testExistingAccountSetBalance() {
		testacc.setAccount_balance(500.25f);
		assertEquals(500.25f, testacc.getAccount_balance(), 0.001);
	}

	@Test
	public void testExistingAccountSetId() {
		testacc.setId(35);
		assertEquals(35, testacc.getId());
	}
	
	//////Test Methods//////
	
	@Test
	public void test_returnAccountDetails() {
		assertEquals("Name: Name --- Balance: $300.25", testacc.returnAccountDetatils());
	}
}

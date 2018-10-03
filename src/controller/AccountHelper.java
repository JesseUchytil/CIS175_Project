package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Account;

public class AccountHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CIS175_Project");
	
	public void insertAccount(Account acc) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(acc);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Account> findAccount(Account acc) {
		EntityManager em = emfactory.createEntityManager();
		List<Account> list = em.createQuery("SELECT acc FROM Account acc WHERE acc.account_name = '"+acc.getAccount_name()+"'", Account.class).getResultList();
		return list;
	}
	
	public List<Account> findAccountById(int id) {
		EntityManager em = emfactory.createEntityManager();
		List<Account> list = em.createQuery("SELECT acc FROM Account acc WHERE acc.id= '"+id+"'", Account.class).getResultList();
		return list;
	}
	
	public List<Account> getAllAccounts(){
		EntityManager em = emfactory.createEntityManager();
		List<Account> list = em.createQuery("SELECT acc FROM Account acc", Account.class).getResultList();
		return list;
	}
	
	public void deleteAccount(Account acc) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Account.class, acc.getId()));
		em.getTransaction().commit();
	}
	
	public void updateAccount(Account acc){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Account toUpdate = em.find(Account.class, acc.getId());
		toUpdate.setAccount_name(acc.getAccount_name());
		toUpdate.setAccount_balance(acc.getAccount_balance());
		em.getTransaction().commit();
	}
	
	
}

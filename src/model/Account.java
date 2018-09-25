
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="accounts")
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="ACCOUNT_NAME")
	private String account_name;
	@Column(name="ACCOUNT_BALANCE")
	private float account_balance;
	
	//constructors
	public Account(){
		
	}
	
	public Account(String name, float balance) {
		this.account_name = name;
		this.account_balance = balance;
	}
	
	//methods
	public String returnAccountDetatils() {
		return "Name: " + account_name + " --- Balance: $" + String.format("%.2f",account_balance);
	}

	//getters and setters
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}

	public String getAccount_name() {return account_name;}
	public void setAccount_name(String account_name) {this.account_name = account_name;}

	public float getAccount_balance() {return account_balance;}
	public void setAccount_balance(float account_balance) {this.account_balance = account_balance;}

}
